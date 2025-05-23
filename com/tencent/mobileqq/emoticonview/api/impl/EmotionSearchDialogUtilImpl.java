package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.photo.c;
import com.tencent.mobileqq.activity.aio.zhitu.g;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.emosearch.CompositeDrawTextParam;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.api.IEmotionSearchDialogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchTextComposeInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiMall;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ>\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002JL\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0017JD\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017J\u001c\u0010\u001d\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/api/impl/EmotionSearchDialogUtilImpl;", "Lcom/tencent/mobileqq/emoticonview/api/IEmotionSearchDialogUtil;", "Lcom/tencent/mobileqq/emosm/emosearch/EmotionSearchItem;", "searchItem", "", "searchWord", "Landroid/util/Pair;", "", "imageSize", "filePath", "Landroid/graphics/Typeface;", TextComponent.SpanStyle.TYPEFACE, "generateCompositePic", "Lcom/tencent/mobileqq/emosm/emosearch/a;", "param", "Lcom/tencent/mobileqq/activity/aio/zhitu/g$a;", "convertToDrawTextParam", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, QCircleLpReportDc010001.KEY_SUBTYPE, "", "sendCompositePic", "Landroid/content/Context;", "context", "addCompositePicToCustom", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/data/Emoticon;", "e", "fetchEmosmKey", "<init>", "()V", "Companion", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class EmotionSearchDialogUtilImpl implements IEmotionSearchDialogUtil {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "EmotionSearchDialogUtil";

    @NotNull
    private static final String sentPath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/api/impl/EmotionSearchDialogUtilImpl$Companion;", "", "()V", "TAG", "", "sentPath", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55044);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_HOT_PIC_PATH + File.separator + "sent/");
        Intrinsics.checkNotNullExpressionValue(sDKPrivatePath, "getSDKPrivatePath(AppCon\u2026+ ZhituManager.FILE_SENT)");
        sentPath = sDKPrivatePath;
    }

    public EmotionSearchDialogUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addCompositePicToCustom$lambda$1() {
        QQToast.makeText(BaseApplication.getContext(), com.tencent.mobileqq.R.string.cwa, 0).show();
    }

    private final g.a convertToDrawTextParam(CompositeDrawTextParam param) {
        float[] fArr = new float[param.getPointFArray().length];
        int length = param.getPointFArray().length;
        for (int i3 = 0; i3 < length; i3++) {
            fArr[i3] = param.getPointFArray()[i3].y;
        }
        g.a aVar = new g.a(fArr, param.getTextArray(), param.getPaint(), param.getStrokePaint());
        aVar.f180413e = param.getPointFArray();
        return aVar;
    }

    private final String generateCompositePic(EmotionSearchItem searchItem, String searchWord, Pair<Integer, Integer> imageSize, String filePath, Typeface typeface) {
        EmojiHotPicSearchTextComposeInfo emojiHotPicSearchTextComposeInfo = searchItem.textComposeInfo;
        if (emojiHotPicSearchTextComposeInfo == null) {
            QLog.i(TAG, 1, "textComposeInfo is null");
            return null;
        }
        com.tencent.mobileqq.emosm.emosearch.b bVar = com.tencent.mobileqq.emosm.emosearch.b.f204292a;
        RectF f16 = bVar.f(emojiHotPicSearchTextComposeInfo.bBox);
        Paint e16 = bVar.e(emojiHotPicSearchTextComposeInfo.textColor, typeface);
        Paint g16 = bVar.g(emojiHotPicSearchTextComposeInfo.shadowColor, typeface);
        Object obj = imageSize.first;
        Intrinsics.checkNotNullExpressionValue(obj, "imageSize.first");
        int intValue = ((Number) obj).intValue();
        Object obj2 = imageSize.second;
        Intrinsics.checkNotNullExpressionValue(obj2, "imageSize.second");
        CompositeDrawTextParam k3 = bVar.k(f16, searchWord, intValue, ((Number) obj2).intValue(), e16, g16);
        String h16 = bVar.h(emojiHotPicSearchTextComposeInfo);
        String str = new File(filePath).getName() + "_" + h16 + "_" + MD5Utils.encodeHexStr(searchWord);
        String str2 = sentPath;
        File file = new File(str2, str);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("emotion_composite_replace_8983_886237811", true) && file.exists()) {
            QLog.i(TAG, 1, "generateCompositePic already exist, fileName:" + file.getName());
            return file.getAbsolutePath();
        }
        File file2 = new File(str2);
        if (!file2.exists() && !file2.mkdirs()) {
            QLog.i(TAG, 1, "generateCompositePic create dir failed");
            return null;
        }
        if (BaseImageUtil.isGifFile(filePath)) {
            return g.l().d(filePath, convertToDrawTextParam(k3), file);
        }
        g l3 = g.l();
        Object obj3 = imageSize.first;
        Intrinsics.checkNotNullExpressionValue(obj3, "imageSize.first");
        int intValue2 = ((Number) obj3).intValue();
        Object obj4 = imageSize.second;
        Intrinsics.checkNotNullExpressionValue(obj4, "imageSize.second");
        return l3.e(filePath, k3, intValue2, ((Number) obj4).intValue(), file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendCompositePic$lambda$0() {
        QQToast.makeText(BaseApplication.getContext(), com.tencent.mobileqq.R.string.fkh, 0).show();
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmotionSearchDialogUtil
    @WorkerThread
    public void addCompositePicToCustom(@NotNull Context context, @NotNull EmotionSearchItem searchItem, @NotNull String searchWord, @NotNull String filePath, @NotNull Pair<Integer, Integer> imageSize, @NotNull Typeface typeface) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, searchItem, searchWord, filePath, imageSize, typeface);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(searchItem, "searchItem");
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(imageSize, "imageSize");
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        String generateCompositePic = generateCompositePic(searchItem, searchWord, imageSize, filePath, typeface);
        if (generateCompositePic == null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    EmotionSearchDialogUtilImpl.addCompositePicToCustom$lambda$1();
                }
            });
            QLog.i(TAG, 1, "addCompositePicToCustom generateFilePath is null");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            c.b(context, generateCompositePic, qQAppInterface, context.getResources().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.title_bar_height), null);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmotionSearchDialogUtil
    public void fetchEmosmKey(@Nullable AppRuntime app, @Nullable Emoticon e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) app, (Object) e16);
        } else {
            ChatActivityFacade.a1((QQAppInterface) app, e16);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmotionSearchDialogUtil
    @WorkerThread
    public void sendCompositePic(@NotNull FragmentActivity activity, @NotNull EmotionSearchItem searchItem, @NotNull String searchWord, @NotNull String filePath, @NotNull Pair<Integer, Integer> imageSize, int subType, @NotNull Typeface typeface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, searchItem, searchWord, filePath, imageSize, Integer.valueOf(subType), typeface);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(searchItem, "searchItem");
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(imageSize, "imageSize");
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        String generateCompositePic = generateCompositePic(searchItem, searchWord, imageSize, filePath, typeface);
        if (generateCompositePic == null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    EmotionSearchDialogUtilImpl.sendCompositePic$lambda$0();
                }
            });
            QLog.i(TAG, 1, "sendCompositePic generateFilePath is null");
            return;
        }
        com.tencent.qqnt.msg.data.g gVar = new com.tencent.qqnt.msg.data.g(null, null, null, null, null, null, 0, 127, null);
        String str = searchItem.appid;
        Intrinsics.checkNotNullExpressionValue(str, "searchItem.appid");
        gVar.h(new EmojiMall(Integer.parseInt(str), 0));
        gVar.j(2);
        com.tencent.qqnt.aio.utils.c.f352293a.b(activity, "", new AIOMsgSendEvent.PicEmotionSendEvent(generateCompositePic, subType, null, gVar, searchItem.getOriginEmoMd5()));
    }
}
