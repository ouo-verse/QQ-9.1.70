package com.tencent.qqnt.aio.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qcircle.weseevideo.model.MediaConfig;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.ISoGouEmoApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.util.InputMethodUtil;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J(\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J4\u0010\u001a\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u0006H\u0002JB\u0010#\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0017H\u0002J\u0010\u0010%\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J.\u0010&\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/aio/utils/v;", "", "Landroid/os/Bundle;", "data", "Landroid/content/Context;", "context", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", tl.h.F, "", "action", "l", "Landroid/view/View;", "input", "j", "k", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/net/Uri;", "pcmPathUri", "pcmPath", "", "sampleRate", "channels", "e", "path", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "audioData", "", "totalTime", "voiceType", "d", "", "g", "i", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class v {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v f352323a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/aio/utils/v$a", "Lcom/tencent/qqnt/aio/api/ISoGouEmoApi$a;", "", "path", "", "voiceType", "totalTime", "", "onCompressFinished", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements ISoGouEmoApi.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<Byte> f352324a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.api.runtime.a f352325b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ double f352326c;

        a(ArrayList<Byte> arrayList, com.tencent.aio.api.runtime.a aVar, double d16) {
            this.f352324a = arrayList;
            this.f352325b = aVar;
            this.f352326c = d16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, arrayList, aVar, Double.valueOf(d16));
            }
        }

        @Override // com.tencent.qqnt.aio.api.ISoGouEmoApi.a
        public void onCompressFinished(@Nullable String path, int voiceType, int totalTime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, path, Integer.valueOf(voiceType), Integer.valueOf(totalTime));
                return;
            }
            v vVar = v.f352323a;
            ArrayList<Byte> audioData = this.f352324a;
            Intrinsics.checkNotNullExpressionValue(audioData, "audioData");
            vVar.d(path, audioData, this.f352325b, (float) this.f352326c, voiceType);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47946);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f352323a = new v();
        }
    }

    v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final BaseQQAppInterface c() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        return (BaseQQAppInterface) peekAppRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String path, ArrayList<Byte> audioData, com.tencent.aio.api.runtime.a aioContext, float totalTime, int voiceType) {
        if (TextUtils.isEmpty(path)) {
            return;
        }
        com.tencent.mvi.base.route.j e16 = aioContext.e();
        Intrinsics.checkNotNull(path);
        e16.h(new AIOMsgSendEvent.PttSendEvent(path, totalTime, voiceType, audioData, false, false, 0, null, 240, null));
        if (QLog.isColorLevel()) {
            QLog.d("NTSogou NTIMECommandUtil", 2, "handleCompressFinished voiceType = " + voiceType + ", totalTime = " + totalTime + ", path = " + path);
        }
    }

    private final void e(final Uri pcmPathUri, final String pcmPath, final int sampleRate, int channels, final com.tencent.aio.api.runtime.a aioContext) {
        if (!g(aioContext)) {
            if (QLog.isColorLevel()) {
                QLog.d("NTSogou NTIMECommandUtil", 2, "handlePttFile return, isEnableSougouPtt is false");
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.utils.u
            @Override // java.lang.Runnable
            public final void run() {
                v.f(pcmPath, pcmPathUri, sampleRate, aioContext);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String str, Uri uri, int i3, com.tencent.aio.api.runtime.a aioContext) {
        int lastIndexOf$default;
        long j3;
        Intrinsics.checkNotNullParameter(aioContext, "$aioContext");
        BaseQQAppInterface c16 = f352323a.c();
        if (c16 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("NTSogou NTIMECommandUtil", 1, "handlePttFile return, mApp is null");
                return;
            }
            return;
        }
        String uin = c16.getCurrentUin();
        RecordParams.RecorderParam recorderParam = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).getRecorderParam();
        ah ahVar = ah.f352287a;
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        String d16 = ahVar.d(recorderParam.f307257f, ahVar.h(uin, null, 2, null));
        if (TextUtils.isEmpty(d16)) {
            if (QLog.isColorLevel()) {
                QLog.d("NTSogou NTIMECommandUtil", 2, "handlePttFile transfer file failed, return");
                return;
            }
            return;
        }
        Intrinsics.checkNotNull(d16);
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) d16, ".", 0, false, 6, (Object) null);
        String substring = d16.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        String str2 = substring + MediaConfig.AUDIO_PCM_FILE_POSTFIX;
        if (QLog.isColorLevel()) {
            QLog.d("NTSogou NTIMECommandUtil", 2, "handlePttFile pcmPath = " + str + ", realFilePath = " + str2 + ", mPttPath = " + d16);
        }
        if (uri == null) {
            if (!FileUtils.copyFile(str, str2, true)) {
                if (QLog.isColorLevel()) {
                    QLog.d("NTSogou NTIMECommandUtil", 2, "handlePttFile copy file failed, return");
                    return;
                }
                return;
            }
        } else if (TextUtils.isEmpty(ahVar.c(uri, str2))) {
            if (QLog.isColorLevel()) {
                QLog.d("NTSogou NTIMECommandUtil", 2, "handlePttFile copy content provider failed, return");
                return;
            }
            return;
        }
        File file = new File(str2);
        if (file.exists()) {
            j3 = file.length();
        } else {
            j3 = 0;
        }
        double millisecond = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).getMillisecond(i3, 2, 2, j3);
        ((ISoGouEmoApi) QRoute.api(ISoGouEmoApi.class)).startVoiceChange(d16, i3, recorderParam.f307256e, recorderParam.f307257f, 0, str2);
        ((ISoGouEmoApi) QRoute.api(ISoGouEmoApi.class)).queryStateByPath(d16, new a(((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).getSampleWaveData(str2, i3), aioContext, millisecond));
        if (QLog.isColorLevel()) {
            QLog.d("NTSogou NTIMECommandUtil", 2, "handlePttFile file size = " + j3 + ", time = " + millisecond + ", param.mAudioType = " + recorderParam.f307257f);
        }
    }

    private final boolean g(com.tencent.aio.api.runtime.a aioContext) {
        Integer num;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        boolean isSwitchOn = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_input_disable_sougou_ptt_9060_116051201", true);
        Boolean bool = null;
        if (aioContext != null && (g16 = aioContext.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            num = Integer.valueOf(c16.e());
        } else {
            num = null;
        }
        if (aioContext != null) {
            bool = Boolean.valueOf(com.tencent.mobileqq.aio.a.b(aioContext));
        }
        if (QLog.isColorLevel()) {
            QLog.i("NTSogou NTIMECommandUtil", 1, "isEnableSougouPtt switch = " + isSwitchOn + ", chatType = " + num + ", isHorizontalAIO = " + bool);
        }
        if (isSwitchOn || Intrinsics.areEqual(Boolean.TRUE, bool)) {
            return false;
        }
        if (num != null && (1 == num.intValue() || 2 == num.intValue())) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        if (r1 == null) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h(Bundle data, Context context, com.tencent.aio.api.runtime.a aioContext) {
        Cursor cursor;
        ?? r16 = InputMethodUtil.EXP_PATH_URI;
        Uri uri = (Uri) data.getParcelable(InputMethodUtil.EXP_PATH_URI);
        if (uri == null) {
            return;
        }
        Cursor cursor2 = null;
        r9 = null;
        String str = null;
        try {
            try {
                cursor = ContactsMonitor.query(context.getContentResolver(), uri, null, null, null, null, null);
            } catch (Exception e16) {
                e = e16;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (cursor2 != null) {
                }
                throw th;
            }
            try {
                Intrinsics.checkNotNull(cursor);
                cursor.moveToFirst();
                str = cursor.getString(cursor.getColumnIndexOrThrow(InputMethodUtil.SOUGOU_URI_DISPLAYNAME));
                r16 = cursor;
            } catch (Exception e17) {
                e = e17;
                QLog.e("NTSogou NTIMECommandUtil", 1, e, new Object[0]);
                r16 = cursor;
            }
            r16.close();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            QLog.i("NTSogou NTIMECommandUtil", 1, "newSendExp uriPath: " + uri + ", finalTargetName: " + str);
            ((ISoGouEmoApi) QRoute.api(ISoGouEmoApi.class)).sendNewExp(context, aioContext, uri, str);
        } catch (Throwable th6) {
            th = th6;
            cursor2 = r16;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    private final void j(Context context, Bundle data, com.tencent.aio.api.runtime.a aioContext, View input) {
        InputMethodManager inputMethodManager;
        String string = data.getString(InputMethodUtil.KEY_SOGOU_APP_ID);
        ISoGouEmoApi iSoGouEmoApi = (ISoGouEmoApi) QRoute.api(ISoGouEmoApi.class);
        String currentAccountUin = c().getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "getAppRuntime().currentAccountUin");
        String openId = iSoGouEmoApi.getOpenId(context, currentAccountUin, String.valueOf(string));
        Object systemService = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (systemService instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) systemService;
        } else {
            inputMethodManager = null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(InputMethodUtil.KEY_SOGOU_OPEN_ID, openId);
        if (inputMethodManager != null) {
            inputMethodManager.sendAppPrivateCommand(input, InputMethodUtil.ACTION_SOGOU_OPEN_ID, bundle);
        }
        ArrayList<String> stringArrayList = data.getStringArrayList(InputMethodUtil.BUNDLE_KEY_SOGOU_EXP_ALL_PACKID);
        QLog.i("NTSogou NTIMECommandUtil", 2, "sendAppId, allPackId: " + stringArrayList);
        ((ISoGouEmoApi) QRoute.api(ISoGouEmoApi.class)).pullMultipleEmojiKey(c(), context, aioContext, stringArrayList);
    }

    private final void k(Context context, Bundle data, com.tencent.aio.api.runtime.a aioContext) {
        int i3 = data.getInt(InputMethodUtil.BUNDLE_KEY_SOGOU_PACK_ID);
        String string = data.getString(InputMethodUtil.BUNDLE_KEY_SOGOU_EXP_ID);
        QLog.i("NTSogou NTIMECommandUtil", 2, "sendEmojiId, packId: " + i3 + ", exprId: " + string + ", ePath: " + data.getString(InputMethodUtil.BUDNLE_KEY_SOGOU_EXP_PATH));
        ((ISoGouEmoApi) QRoute.api(ISoGouEmoApi.class)).trySend(c(), context, aioContext, i3, string);
    }

    private final void l(Context context, String action, Bundle data, com.tencent.aio.api.runtime.a aioContext) {
        String string;
        if (Intrinsics.areEqual(InputMethodUtil.ACTION_SOGOU_EXPRESSION, action)) {
            string = data.getString(InputMethodUtil.KEY_SOGOU_EXPRESSION);
        } else {
            string = data.getString(InputMethodUtil.KEY_QQPINYIN_EXPRESSION);
        }
        QLog.i("NTSogou NTIMECommandUtil", 1, "sendExp, path: " + string);
        ((ISoGouEmoApi) QRoute.api(ISoGouEmoApi.class)).sendIMEExpression(context, aioContext, string, action);
    }

    private final void m(Context context, Bundle data, com.tencent.aio.api.runtime.a aioContext, View input) {
        Object obj = data.get("PCMFilePathUri");
        String string = data.getString(InputMethodUtil.ARGS_KEY_PCMFILE_PATH);
        int i3 = data.getInt(InputMethodUtil.ARGS_KEY_SAMPLE_RATE);
        int i16 = data.getInt(InputMethodUtil.ARGS_KEY_CHANNELS);
        if (QLog.isColorLevel()) {
            QLog.i("NTSogou NTIMECommandUtil", 2, "sendPtt start pcmPathUri: " + obj + ", pcmPath: " + string + ", sampleRate: " + i3 + ", channels: " + i16);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.net.Uri");
        e((Uri) obj, string, i3, i16, aioContext);
        Object systemService = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        Bundle bundle = new Bundle();
        bundle.putString(InputMethodUtil.ARGS_KEY_PCMFILE_PATH, string);
        ((InputMethodManager) systemService).sendAppPrivateCommand(input, InputMethodUtil.ACTION_SOGOU_PTT_HANDLED_NOTIFY, bundle);
    }

    public final void i(@NotNull Context context, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String action, @NotNull Bundle data, @NotNull View input) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, aioContext, action, data, input);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(input, "input");
        QLog.i("NTSogou NTIMECommandUtil", 1, "onPrivateIMECommand, action: " + action + " data: " + data);
        try {
            switch (action.hashCode()) {
                case -1967022603:
                    if (!action.equals(InputMethodUtil.ACTION_SOUGOU_NEW_EXP)) {
                        break;
                    } else {
                        h(data, context, aioContext);
                        break;
                    }
                case -1685186971:
                    if (!action.equals(InputMethodUtil.ACTION_SOGOU_EXPRESSION)) {
                        break;
                    }
                    l(context, action, data, aioContext);
                    break;
                case -1658907889:
                    if (!action.equals(InputMethodUtil.ACTION_SOGOU_APP_ID)) {
                        break;
                    } else {
                        j(context, data, aioContext, input);
                        break;
                    }
                case -1644111856:
                    if (!action.equals(InputMethodUtil.ACTION_SOGOU_QQEXP)) {
                        break;
                    }
                    k(context, data, aioContext);
                    break;
                case -877063481:
                    if (!action.equals(InputMethodUtil.ACTION_QQPINYIN_EXPRESSION)) {
                        break;
                    }
                    l(context, action, data, aioContext);
                    break;
                case 1516119662:
                    if (!action.equals(InputMethodUtil.ACTION_QQPINYIN_QQEXP)) {
                        break;
                    }
                    k(context, data, aioContext);
                    break;
                case 1953870316:
                    if (!action.equals(InputMethodUtil.ACTION_SOGOU_PTT_ARGS_NOTIFY)) {
                        break;
                    } else {
                        m(context, data, aioContext, input);
                        break;
                    }
            }
        } catch (Exception e16) {
            QLog.e("NTSogou NTIMECommandUtil", 1, "e: " + e16);
        }
    }
}
