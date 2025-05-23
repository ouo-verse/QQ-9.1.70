package com.tencent.mobileqq.aio.msglist.holder.base.util;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.download.LibraDownloadKey;
import com.tencent.libra.download.LibraGroupKey;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.PicMsgItem;
import com.tencent.mobileqq.aio.msg.o;
import com.tencent.mobileqq.aio.msg.w;
import com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader;
import com.tencent.mobileqq.aio.msglist.holder.base.PicSize;
import com.tencent.mobileqq.aio.msglist.holder.component.pic.PicUtil;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.RMRichMediaInvalidState;
import defpackage.g;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002;<B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:Jx\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000726\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rH\u0002J`\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n26\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\r2\u0006\u0010\f\u001a\u00020\u0007H\u0002J2\u0010\u001b\u001a\u00020\u00142\u0010\u0010\u001a\u001a\f\u0012\u0004\u0012\u00020\u0019\u0012\u0002\b\u00030\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J8\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002J \u0010\u001f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002Jr\u0010\"\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\u0010\u001a\u001a\f\u0012\u0004\u0012\u00020\u0019\u0012\u0002\b\u00030\u00182\u0006\u0010!\u001a\u00020 26\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rH\u0007JL\u0010#\u001a\u00020\u0014*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0010\u0010\u001a\u001a\f\u0012\u0004\u0012\u00020\u0019\u0012\u0002\b\u00030\u00182\u0006\u0010!\u001a\u00020 Jp\u0010)\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'26\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rH\u0007J\u0084\u0001\u00101\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020*2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020/2\u0006\u0010(\u001a\u00020'2:\b\u0002\u00100\u001a4\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\rH\u0007R\u0014\u00104\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u00103R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/base/util/PicContentViewUtil;", "", "Lcom/tencent/mobileqq/aio/msg/w;", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "picMsgElement", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "Lkotlin/collections/ArrayList;", "picSizeList", "Landroidx/appcompat/widget/AppCompatImageView;", "picView", "preDownloadPicSize", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/mobileqq/aio/msglist/holder/base/util/PicContentViewUtil$FailReason;", "failReason", "", "onLoadResult", "l", "e", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/aio/holder/a;", "vb", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "context", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Runnable;", "clickCallback", "c", "f", "", "imagePath", "picSize", "Lcom/tencent/mobileqq/aio/msglist/holder/base/util/PicContentViewUtil$LoadingImage;", "loadingImage", "k", "Landroid/widget/ImageView;", "", "decodeWidth", "decodeHeight", "msgElement", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "onImageLoad", h.F, "b", "I", "TAG_LOADING_ELEMENT_ID", "TAG_LOADED_ELEMENT_ID", "Lcom/tencent/mobileqq/pic/api/IPicAIOApi;", "Lcom/tencent/mobileqq/pic/api/IPicAIOApi;", "picApi", "<init>", "()V", "FailReason", "LoadingImage", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PicContentViewUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PicContentViewUtil f190621a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int TAG_LOADING_ELEMENT_ID;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int TAG_LOADED_ELEMENT_ID;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IPicAIOApi picApi;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/base/util/PicContentViewUtil$FailReason;", "", "(Ljava/lang/String;I)V", "None", "Expired", "Failed", "Security", "Other", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class FailReason {
        private static final /* synthetic */ FailReason[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final FailReason Expired;
        public static final FailReason Failed;
        public static final FailReason None;
        public static final FailReason Other;
        public static final FailReason Security;

        private static final /* synthetic */ FailReason[] $values() {
            return new FailReason[]{None, Expired, Failed, Security, Other};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59832);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            None = new FailReason("None", 0);
            Expired = new FailReason("Expired", 1);
            Failed = new FailReason("Failed", 2);
            Security = new FailReason("Security", 3);
            Other = new FailReason("Other", 4);
            $VALUES = $values();
        }

        FailReason(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static FailReason valueOf(String str) {
            return (FailReason) Enum.valueOf(FailReason.class, str);
        }

        public static FailReason[] values() {
            return (FailReason[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/base/util/PicContentViewUtil$LoadingImage;", "", "(Ljava/lang/String;I)V", "Original", "Transparent", "LoadingIcon", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class LoadingImage {
        private static final /* synthetic */ LoadingImage[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final LoadingImage LoadingIcon;
        public static final LoadingImage Original;
        public static final LoadingImage Transparent;

        private static final /* synthetic */ LoadingImage[] $values() {
            return new LoadingImage[]{Original, Transparent, LoadingIcon};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59837);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Original = new LoadingImage("Original", 0);
            Transparent = new LoadingImage("Transparent", 1);
            LoadingIcon = new LoadingImage("LoadingIcon", 2);
            $VALUES = $values();
        }

        LoadingImage(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static LoadingImage valueOf(String str) {
            return (LoadingImage) Enum.valueOf(LoadingImage.class, str);
        }

        public static LoadingImage[] values() {
            return (LoadingImage[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f190625a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59858);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[LoadingImage.values().length];
            try {
                iArr[LoadingImage.Original.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadingImage.Transparent.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadingImage.LoadingIcon.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f190625a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59879);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f190621a = new PicContentViewUtil();
        TAG_LOADING_ELEMENT_ID = R.id.f24840_8;
        TAG_LOADED_ELEMENT_ID = R.id.f24830_7;
        QRouteApi api = QRoute.api(IPicAIOApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IPicAIOApi::class.java)");
        picApi = (IPicAIOApi) api;
    }

    PicContentViewUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean d(Context context, MsgElement picMsgElement, w msgItem, ArrayList<PicSize> picSizeList) {
        String string;
        PicElement picElement = picMsgElement.picElement;
        Intrinsics.checkNotNullExpressionValue(picElement, "picMsgElement.picElement");
        if (!f.f(picElement) || msgItem.j2(picMsgElement.elementId, picSizeList) != null) {
            return false;
        }
        QLog.i("PicContentViewUtil", 1, "onclick pic is expire msgId=" + msgItem.getMsgId() + ", invalidState=" + picMsgElement.picElement.invalidState);
        PicElement picElement2 = picMsgElement.picElement;
        Intrinsics.checkNotNullExpressionValue(picElement2, "picMsgElement.picElement");
        if (f.h(picElement2)) {
            string = context.getString(R.string.ysi);
        } else {
            string = context.getString(R.string.ysg);
        }
        Intrinsics.checkNotNullExpressionValue(string, "if (picMsgElement.picEle\u2026ic_expired)\n            }");
        QQToast.makeText(context, string, 0, 1).show();
        return true;
    }

    private final void e(MsgElement picMsgElement, w msgItem, AppCompatImageView picView, Function2<? super Boolean, ? super FailReason, Unit> onLoadResult, PicSize preDownloadPicSize) {
        Unit unit;
        FailReason failReason;
        PicElement picElement = picMsgElement.picElement;
        Intrinsics.checkNotNullExpressionValue(picElement, "picMsgElement.picElement");
        if (f.f(picElement)) {
            QLog.i("PicContentViewUtil", 1, "[applyPicView] pic is expired, msgId=" + msgItem.getMsgId());
            PicElement picElement2 = picMsgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement2, "picMsgElement.picElement");
            if (f.h(picElement2)) {
                picView.setImageDrawable(PicUtil.f191410a.h(picView.getLayoutParams().width, picView.getLayoutParams().height));
            } else {
                picView.setImageDrawable(PicUtil.f191410a.a(picView.getLayoutParams().width, picView.getLayoutParams().height));
            }
            Boolean bool = Boolean.FALSE;
            PicElement picElement3 = picMsgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement3, "picMsgElement.picElement");
            if (f.h(picElement3)) {
                failReason = FailReason.Security;
            } else {
                failReason = FailReason.Expired;
            }
            onLoadResult.invoke(bool, failReason);
            return;
        }
        AIOPicDownloader aIOPicDownloader = AIOPicDownloader.f190570a;
        PicElement picElement4 = picMsgElement.picElement;
        Intrinsics.checkNotNullExpressionValue(picElement4, "picMsgElement.picElement");
        String q16 = aIOPicDownloader.q(picElement4, preDownloadPicSize);
        if (q16 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("PicContentViewUtil", 2, "[applyPicView] needPreDownload=true, msgId=" + msgItem.getMsgId(), ", preDownloadPicSize=" + preDownloadPicSize + ", preDownloadReason=no pic exists!");
            }
            PicElement picElement5 = picMsgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement5, "picMsgElement.picElement");
            Pair<Integer, Integer> b16 = f.b(picElement5);
            f190621a.h(picView, q16, preDownloadPicSize, b16.component1().intValue(), b16.component2().intValue(), picMsgElement, msgItem, LoadingImage.LoadingIcon, onLoadResult);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("PicContentViewUtil", 1, "[applyPicView] error, msgId=" + msgItem.getMsgId() + ", thumbPath is empty, picSize=" + preDownloadPicSize);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(AppCompatImageView this_initPicViewAttrs, MsgElement picMsgElement, w msgItem, ArrayList picSizeList, com.tencent.aio.base.mvvm.a vb5, Runnable clickCallback, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_initPicViewAttrs, "$this_initPicViewAttrs");
        Intrinsics.checkNotNullParameter(picMsgElement, "$picMsgElement");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(picSizeList, "$picSizeList");
        Intrinsics.checkNotNullParameter(vb5, "$vb");
        Intrinsics.checkNotNullParameter(clickCallback, "$clickCallback");
        PicContentViewUtil picContentViewUtil = f190621a;
        Context context = this_initPicViewAttrs.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!picContentViewUtil.d(context, picMsgElement, msgItem, picSizeList)) {
            picContentViewUtil.n(vb5, msgItem, picMsgElement, this_initPicViewAttrs);
            clickCallback.run();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public static /* synthetic */ void i(PicContentViewUtil picContentViewUtil, ImageView imageView, String str, PicSize picSize, int i3, int i16, MsgElement msgElement, AIOMsgItem aIOMsgItem, LoadingImage loadingImage, Function2 function2, int i17, Object obj) {
        Function2 function22;
        if ((i17 & 256) != 0) {
            function22 = null;
        } else {
            function22 = function2;
        }
        picContentViewUtil.h(imageView, str, picSize, i3, i16, msgElement, aIOMsgItem, loadingImage, function22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AIOMsgItem msgItem, MsgElement msgElement, PicSize picSize, ImageView picView, Function2 function2, LoadState loadState, Option option) {
        FailReason failReason;
        r01.c cVar;
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(msgElement, "$msgElement");
        Intrinsics.checkNotNullParameter(picSize, "$picSize");
        Intrinsics.checkNotNullParameter(picView, "$picView");
        if (loadState.isFinish()) {
            if (loadState.isFinishSuccess()) {
                QLog.i("PicContentViewUtil", 1, "[loadImage] success, msgId=" + msgItem.getMsgId() + " msgElementId=" + msgElement.elementId);
                failReason = FailReason.None;
                if (msgItem instanceof w) {
                    ((w) msgItem).l2(msgElement.elementId, 4, option.getLocalPath(), picSize);
                    int i3 = msgElement.elementType;
                    if (i3 != 2) {
                        if (i3 == 5) {
                            picView.setContentDescription(HardCodeUtil.qqStr(R.string.ypf));
                        }
                    } else if (msgItem instanceof PicMsgItem) {
                        picView.setContentDescription(((PicMsgItem) msgItem).n2());
                    } else {
                        picView.setContentDescription(HardCodeUtil.qqStr(R.string.yp6));
                    }
                }
                if (option.getAnimatable() != null) {
                    Animatable animatable = option.getAnimatable();
                    if (animatable instanceof r01.c) {
                        cVar = (r01.c) animatable;
                    } else {
                        cVar = null;
                    }
                    if (cVar != null) {
                        cVar.setLoopCount(65535);
                    }
                    option.getAnimatable().start();
                }
            } else {
                QLog.i("PicContentViewUtil", 1, "[loadImage] fail, msgId=" + msgItem.getMsgId() + " msgElementId=" + msgElement.elementId + " loadState=" + loadState.ordinal());
                if (option.getErrorCode() == 2006021) {
                    PicElement picElement = msgElement.picElement;
                    if (picElement != null) {
                        picElement.invalidState = Integer.valueOf(RMRichMediaInvalidState.KFILEEXPIRED.ordinal());
                    }
                    FileElement fileElement = msgElement.fileElement;
                    if (fileElement != null) {
                        fileElement.invalidState = Integer.valueOf(RMRichMediaInvalidState.KFILEEXPIRED.ordinal());
                    }
                    failReason = FailReason.Expired;
                } else if (option.getErrorCode() == 2006040) {
                    PicElement picElement2 = msgElement.picElement;
                    if (picElement2 != null) {
                        picElement2.invalidState = Integer.valueOf(RMRichMediaInvalidState.KFILESECURITYSTRIKE.ordinal());
                    }
                    FileElement fileElement2 = msgElement.fileElement;
                    if (fileElement2 != null) {
                        fileElement2.invalidState = Integer.valueOf(RMRichMediaInvalidState.KFILESECURITYSTRIKE.ordinal());
                    }
                    failReason = FailReason.Security;
                } else {
                    failReason = loadState.isFinishError() ? FailReason.Failed : FailReason.Other;
                }
            }
            if (function2 != null) {
                function2.invoke(Boolean.valueOf(loadState.isFinishSuccess()), failReason);
            }
        }
    }

    private final boolean l(final w msgItem, MsgElement picMsgElement, final ArrayList<PicSize> picSizeList, AppCompatImageView picView, final PicSize preDownloadPicSize, Function2<? super Boolean, ? super FailReason, Unit> onLoadResult) {
        Pair<PicSize, String> j26 = msgItem.j2(picMsgElement.elementId, picSizeList);
        int i3 = 0;
        if (j26 == null) {
            return false;
        }
        k(msgItem, picMsgElement, picView, j26.getSecond(), j26.getFirst(), LoadingImage.Transparent, onLoadResult);
        if (!Intrinsics.areEqual(msgItem.f(picMsgElement.elementId, preDownloadPicSize), "")) {
            return true;
        }
        PicElement picElement = picMsgElement.picElement;
        Intrinsics.checkNotNullExpressionValue(picElement, "picMsgElement.picElement");
        if (f.f(picElement)) {
            QLog.i("PicContentViewUtil", 1, "[applyPicView] expired with thumb existing, msgId=" + msgItem.getMsgId());
            return true;
        }
        if (m(preDownloadPicSize, msgItem, picMsgElement)) {
            AIOPicDownloader.f190570a.e(picMsgElement, preDownloadPicSize, new AIOPicDownloader.a(msgItem, i3, 2, null), 1, 1, new Function1<FileTransNotifyInfo, Unit>(preDownloadPicSize, picSizeList) { // from class: com.tencent.mobileqq.aio.msglist.holder.base.util.PicContentViewUtil$loadPicFromCache$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ArrayList<PicSize> $picSizeList;
                final /* synthetic */ PicSize $preDownloadPicSize;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$preDownloadPicSize = preDownloadPicSize;
                    this.$picSizeList = picSizeList;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, w.this, preDownloadPicSize, picSizeList);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FileTransNotifyInfo fileTransNotifyInfo) {
                    invoke2(fileTransNotifyInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull FileTransNotifyInfo fileInfo) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) fileInfo);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
                    if (QLog.isColorLevel()) {
                        QLog.d("PicContentViewUtil", 2, "[applyPicView] pre download pic complete, msgId=" + w.this.getMsgId() + ", fileInfo=" + fileInfo + ", preDownloadPicSize=" + this.$preDownloadPicSize + ", picSizeList[0]==" + this.$picSizeList.get(0));
                    }
                }
            });
        }
        return true;
    }

    private final boolean m(PicSize preDownloadPicSize, w msgItem, MsgElement picMsgElement) {
        boolean z16;
        String str;
        if (preDownloadPicSize == PicSize.PIC_DOWNLOAD_THUMB) {
            z16 = !Intrinsics.areEqual(msgItem.f(picMsgElement.elementId, PicSize.PIC_LOCAL_HD_THUMB), "");
            str = "hd thumb exists = " + z16;
        } else {
            z16 = !Intrinsics.areEqual(msgItem.f(picMsgElement.elementId, PicSize.PIC_DOWNLOAD_ORI), "");
            str = "origin pic exists = " + z16;
        }
        boolean z17 = !z16;
        if (QLog.isColorLevel()) {
            QLog.d("PicContentViewUtil", 2, "[applyPicView] needPreDownload=" + z17 + ", msgId=" + msgItem.getMsgId(), ", preDownloadPicSize=" + preDownloadPicSize + ", preDownloadReason=" + str);
        }
        return z17;
    }

    private final void n(com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, ?> vb5, w msgItem, MsgElement picMsgElement, AppCompatImageView picView) {
        vb5.sendIntent(new d.ac(msgItem, picMsgElement, picView));
    }

    @MainThread
    public final void c(@NotNull AppCompatImageView picView, @NotNull w msgItem, @NotNull MsgElement picMsgElement, @NotNull com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, ?> vb5, @NotNull Runnable clickCallback, @NotNull Function2<? super Boolean, ? super FailReason, Unit> onLoadResult) {
        PicSize a16;
        FailReason failReason;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, picView, msgItem, picMsgElement, vb5, clickCallback, onLoadResult);
            return;
        }
        Intrinsics.checkNotNullParameter(picView, "picView");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(picMsgElement, "picMsgElement");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        Intrinsics.checkNotNullParameter(onLoadResult, "onLoadResult");
        PicElement picElement = picMsgElement.picElement;
        Intrinsics.checkNotNullExpressionValue(picElement, "picMsgElement.picElement");
        ArrayList<PicSize> a17 = g.a(picElement, msgItem.getMsgRecord().isImportMsg);
        if (msgItem instanceof PicMsgItem) {
            a16 = ((PicMsgItem) msgItem).q2();
        } else {
            a16 = com.tencent.qqnt.aio.predownload.pic.stragegy.a.f351808a.a(msgItem, picMsgElement);
        }
        PicSize picSize = a16;
        f(picView, picMsgElement, msgItem, a17, vb5, clickCallback);
        if (l(msgItem, picMsgElement, a17, picView, picSize, onLoadResult)) {
            PicElement picElement2 = picMsgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement2, "picMsgElement.picElement");
            if (f.f(picElement2)) {
                QLog.i("PicContentViewUtil", 1, "[applyPicView] pic is expired, but local file exist, msgId=" + msgItem.getMsgId());
                Boolean bool = Boolean.FALSE;
                PicElement picElement3 = picMsgElement.picElement;
                Intrinsics.checkNotNullExpressionValue(picElement3, "picMsgElement.picElement");
                if (f.h(picElement3)) {
                    failReason = FailReason.Security;
                } else {
                    failReason = FailReason.Expired;
                }
                onLoadResult.invoke(bool, failReason);
                return;
            }
            return;
        }
        e(picMsgElement, msgItem, picView, onLoadResult, picSize);
    }

    public final void f(@NotNull final AppCompatImageView appCompatImageView, @NotNull final MsgElement picMsgElement, @NotNull final w msgItem, @NotNull final ArrayList<PicSize> picSizeList, @NotNull final com.tencent.aio.base.mvvm.a<com.tencent.qqnt.aio.holder.a, ?> vb5, @NotNull final Runnable clickCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appCompatImageView, picMsgElement, msgItem, picSizeList, vb5, clickCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(appCompatImageView, "<this>");
        Intrinsics.checkNotNullParameter(picMsgElement, "picMsgElement");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(picSizeList, "picSizeList");
        Intrinsics.checkNotNullParameter(vb5, "vb");
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        appCompatImageView.setBackground(null);
        appCompatImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        PicElement picElement = picMsgElement.picElement;
        Intrinsics.checkNotNullExpressionValue(picElement, "picMsgElement.picElement");
        Pair<Integer, Integer> c16 = f.c(picElement, msgItem instanceof o);
        appCompatImageView.getLayoutParams().width = c16.getFirst().intValue();
        appCompatImageView.getLayoutParams().height = c16.getSecond().intValue();
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.base.util.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PicContentViewUtil.g(AppCompatImageView.this, picMsgElement, msgItem, picSizeList, vb5, clickCallback, view);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ef  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(@NotNull final ImageView picView, @NotNull String imagePath, @NotNull final PicSize picSize, int decodeWidth, int decodeHeight, @NotNull final MsgElement msgElement, @NotNull final AIOMsgItem msgItem, @NotNull LoadingImage loadingImage, @Nullable final Function2<? super Boolean, ? super FailReason, Unit> onImageLoad) {
        boolean z16;
        int i3;
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, picView, imagePath, picSize, Integer.valueOf(decodeWidth), Integer.valueOf(decodeHeight), msgElement, msgItem, loadingImage, onImageLoad);
            return;
        }
        Intrinsics.checkNotNullParameter(picView, "picView");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(loadingImage, "loadingImage");
        picView.setTag(TAG_LOADING_ELEMENT_ID, Long.valueOf(msgElement.elementId));
        IPicAIOApi iPicAIOApi = picApi;
        Option obtain = Option.obtain();
        obtain.setUrl(imagePath);
        obtain.setGroupKey(new LibraGroupKey(String.valueOf(msgElement.elementId)));
        PicElement picElement = msgElement.picElement;
        if (picElement != null) {
            Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
            if (f.d(picElement, picSize)) {
                z16 = true;
                if (!z16) {
                    obtain.setCacheKey(new LibraRequestKey.Builder(new LibraDownloadKey(imagePath)).build());
                }
                obtain.setRequestWidth(decodeWidth);
                obtain.setRequestHeight(decodeHeight);
                obtain.setLocalPath(imagePath);
                obtain.setTargetView(picView);
                i3 = a.f190625a[loadingImage.ordinal()];
                if (i3 == 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            drawable = PicUtil.f191410a.g(picView.getLayoutParams().width, picView.getLayoutParams().height);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        drawable = new ColorDrawable(0);
                    }
                } else {
                    drawable = picView.getDrawable();
                }
                obtain.setLoadingDrawable(drawable);
                obtain.setFailedDrawable(PicUtil.f191410a.h(picView.getLayoutParams().width, picView.getLayoutParams().height));
                obtain.setNeedShowFailedDrawable(true);
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                concurrentHashMap.put("picMsgElement", msgElement);
                concurrentHashMap.put("aioMsgItem", msgItem);
                concurrentHashMap.put("picType", AIOPicDownloader.f190570a.m(picSize));
                obtain.setExtraData(concurrentHashMap);
                Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026          }\n            }");
                iPicAIOApi.loadPic(obtain, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.base.util.e
                    @Override // com.tencent.libra.listener.IPicLoadStateListener
                    public final void onStateChange(LoadState loadState, Option option) {
                        PicContentViewUtil.j(AIOMsgItem.this, msgElement, picSize, picView, onImageLoad, loadState, option);
                    }
                });
            }
        }
        z16 = false;
        if (!z16) {
        }
        obtain.setRequestWidth(decodeWidth);
        obtain.setRequestHeight(decodeHeight);
        obtain.setLocalPath(imagePath);
        obtain.setTargetView(picView);
        i3 = a.f190625a[loadingImage.ordinal()];
        if (i3 == 1) {
        }
        obtain.setLoadingDrawable(drawable);
        obtain.setFailedDrawable(PicUtil.f191410a.h(picView.getLayoutParams().width, picView.getLayoutParams().height));
        obtain.setNeedShowFailedDrawable(true);
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        concurrentHashMap2.put("picMsgElement", msgElement);
        concurrentHashMap2.put("aioMsgItem", msgItem);
        concurrentHashMap2.put("picType", AIOPicDownloader.f190570a.m(picSize));
        obtain.setExtraData(concurrentHashMap2);
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026          }\n            }");
        iPicAIOApi.loadPic(obtain, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.base.util.e
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                PicContentViewUtil.j(AIOMsgItem.this, msgElement, picSize, picView, onImageLoad, loadState, option);
            }
        });
    }

    @MainThread
    public final void k(@NotNull w msgItem, @NotNull MsgElement picMsgElement, @NotNull AppCompatImageView picView, @NotNull String imagePath, @NotNull PicSize picSize, @NotNull LoadingImage loadingImage, @NotNull Function2<? super Boolean, ? super FailReason, Unit> onLoadResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, msgItem, picMsgElement, picView, imagePath, picSize, loadingImage, onLoadResult);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(picMsgElement, "picMsgElement");
        Intrinsics.checkNotNullParameter(picView, "picView");
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        Intrinsics.checkNotNullParameter(loadingImage, "loadingImage");
        Intrinsics.checkNotNullParameter(onLoadResult, "onLoadResult");
        picView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        picView.setBackground(null);
        PicElement picElement = picMsgElement.picElement;
        Intrinsics.checkNotNullExpressionValue(picElement, "picMsgElement.picElement");
        Pair<Integer, Integer> b16 = f.b(picElement);
        f190621a.h(picView, imagePath, picSize, b16.component1().intValue(), b16.component2().intValue(), picMsgElement, msgItem, loadingImage, onLoadResult);
    }
}
