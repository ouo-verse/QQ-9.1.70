package com.tencent.mobileqq.emoticon.kernel;

import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.Gson;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.emoticon.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.BaseEmojiPathInfo;
import com.tencent.qqnt.kernel.nativeinterface.BaseEmojiType;
import com.tencent.qqnt.kernel.nativeinterface.GetBaseEmojiPathReq;
import com.tencent.qqnt.kernel.nativeinterface.IFetchFullSysEmojisCallback;
import com.tencent.qqnt.kernel.nativeinterface.PullMomentType;
import com.tencent.qqnt.kernel.nativeinterface.PullSysEmojisReq;
import com.tencent.qqnt.kernel.nativeinterface.PullSysEmojisRsp;
import com.tencent.xweb.FileReaderHelper;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0014J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0004H\u0004J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0017\u001a\u00020\u0006H\u0016J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0016\u0010\u001f\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u0012\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001dH\u0016J\b\u0010&\u001a\u00020\nH\u0014J$\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0'2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001dH\u0016J \u0010+\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0002H\u0016J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u001dH\u0016J(\u0010.\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u0002H\u0016J0\u00101\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\nH\u0016R\u0014\u00104\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001a\u00109\u001a\u00020\u00108\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\"\u0010@\u001a\u00020\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010;R\u0016\u0010D\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010;R\u0018\u0010G\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010HR\u0016\u0010J\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010HR\u0016\u0010K\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010H\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/emoticon/kernel/KernelQQSysAndEmojiResMgr;", "Lcom/tencent/mobileqq/emoticon/e;", "", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/PullSysEmojisRsp;", "pullSysEmojisRsp", "", HippyTKDListViewAdapter.X, "u", "o", "", "initAsync", "p", "w", "Lcom/tencent/mobileqq/emoticon/kernel/n;", "j", "Lcom/tencent/mobileqq/emoticon/kernel/b;", "i", "initConfig", "l", "rsp", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "refreshConfig", "Lcom/tencent/qqnt/kernel/nativeinterface/PullMomentType;", "pullMomentType", "fetchBaseSource", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", "", "downloadResTypeList", "downloadEmoticonRes", "Lcom/tencent/mobileqq/emoticon/QQSysAndEmojiResReloader$IResReloadListener;", "lottieResReloadListener", "setLottieResReloadListener", "type", "serverId", "getFullResPath", tl.h.F, "Landroid/util/Pair;", "getSysFaceFullResPath", "aniStickerPackId", "aniStickerId", "getAniStickerResPath", "getAniStickerLoadingResPath", "resultId", "getAniStickerRandomResultFullResPath", "surpriseId", "isPadLandScape", "getAniStickerSurpriseFullResPath", "b", "Lcom/tencent/mobileqq/emoticon/kernel/n;", "mQQSysFaceResImpl", "c", "Lcom/tencent/mobileqq/emoticon/kernel/b;", "getMEmojiResImpl", "()Lcom/tencent/mobileqq/emoticon/kernel/b;", "mEmojiResImpl", "d", "Z", "getMIsDoingInitConfig", "()Z", "v", "(Z)V", "mIsDoingInitConfig", "e", "mHasRefreshConfig", "f", "mIsNeedReInitConfig", "g", "Lcom/tencent/mobileqq/emoticon/QQSysAndEmojiResReloader$IResReloadListener;", "mLottieResReloadListener", "Ljava/lang/String;", "sysFaceApngTemplatePath", "sysFaceStaticTemplatePath", "emojiTemplatePath", "<init>", "()V", "a", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class KernelQQSysAndEmojiResMgr implements com.tencent.mobileqq.emoticon.e {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final n mQQSysFaceResImpl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mEmojiResImpl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mIsDoingInitConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mHasRefreshConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsNeedReInitConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQSysAndEmojiResReloader.IResReloadListener mLottieResReloadListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sysFaceApngTemplatePath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sysFaceStaticTemplatePath;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String emojiTemplatePath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/emoticon/kernel/KernelQQSysAndEmojiResMgr$a;", "", "", "KEY_HAS_DOWNLOADED_FULL_RES", "Ljava/lang/String;", "KEY_RES_EMOJI_TEMPLATE_PATH", "KEY_RES_SYS_FACE_APNG_TEMPLATE_PATH", "KEY_RES_SYS_FACE_STATIC_TEMPLATE_PATH", "", "KEY_RES_TEMPLATE_EMOJI_ID", "I", "KEY_SWITCH_SINGLE_PULL_NOTIFY", "PULL_SYS_EMOJIS_THRESHOLD_VALUE", "SYS_EMOJI_CONFIG_JSON_SUB_PATH", "TAG", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emoticon.kernel.KernelQQSysAndEmojiResMgr$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32131);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public KernelQQSysAndEmojiResMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        n nVar = new n();
        nVar.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.emoticon.kernel.KernelQQSysAndEmojiResMgr$mQQSysFaceResImpl$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelQQSysAndEmojiResMgr.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean w3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                w3 = KernelQQSysAndEmojiResMgr.this.w();
                if (w3) {
                    KernelQQSysAndEmojiResMgr.this.refreshConfig(PullMomentType.SINGEL_PULL_NOTIFY, true, true);
                }
            }
        });
        this.mQQSysFaceResImpl = nVar;
        b bVar = new b();
        bVar.e(new Function0<Unit>() { // from class: com.tencent.mobileqq.emoticon.kernel.KernelQQSysAndEmojiResMgr$mEmojiResImpl$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) KernelQQSysAndEmojiResMgr.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean w3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                w3 = KernelQQSysAndEmojiResMgr.this.w();
                if (w3) {
                    KernelQQSysAndEmojiResMgr.this.refreshConfig(PullMomentType.SINGEL_PULL_NOTIFY, true, true);
                }
            }
        });
        this.mEmojiResImpl = bVar;
        this.sysFaceApngTemplatePath = "";
        this.sysFaceStaticTemplatePath = "";
        this.emojiTemplatePath = "";
    }

    private final String k() {
        String str = BaseApplication.getContext().getFilesDir().getAbsolutePath() + File.separator + "/emoji/sys_emoji_config.json";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder(BaseApplic\u2026JSON_SUB_PATH).toString()");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final KernelQQSysAndEmojiResMgr this$0, int i3, String str, final PullSysEmojisRsp pullSysEmojisRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("KernelQQSysAndEmojiResMgr", 1, "[initConfig] fetchFullSysEmojis onResult, result=", Integer.valueOf(i3), ", errMsg=", str);
        if (i3 == 0 && pullSysEmojisRsp != null) {
            this$0.q(pullSysEmojisRsp);
            boolean decodeBool = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("keyHasDownloadedFullRes", false);
            this$0.mQQSysFaceResImpl.i(decodeBool);
            this$0.mEmojiResImpl.d(decodeBool);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticon.kernel.g
                @Override // java.lang.Runnable
                public final void run() {
                    KernelQQSysAndEmojiResMgr.n(KernelQQSysAndEmojiResMgr.this, pullSysEmojisRsp);
                }
            }, 64, null, false);
            this$0.mIsDoingInitConfig = false;
            return;
        }
        if (QQSysFaceSwitcher.f204652a.j()) {
            this$0.mIsNeedReInitConfig = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(KernelQQSysAndEmojiResMgr this$0, PullSysEmojisRsp pullSysEmojisRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x(pullSysEmojisRsp);
        this$0.u();
    }

    private final void o() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String decodeString = from.decodeString("sysFaceAPNGTemplatePath", "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(KEY_\u2026E_APNG_TEMPLATE_PATH, \"\")");
        this.sysFaceApngTemplatePath = decodeString;
        String decodeString2 = from.decodeString("sysFaceStaticTemplatePath", "");
        Intrinsics.checkNotNullExpressionValue(decodeString2, "entity.decodeString(KEY_\u2026STATIC_TEMPLATE_PATH, \"\")");
        this.sysFaceStaticTemplatePath = decodeString2;
        String decodeString3 = from.decodeString("emojiTemplatePath", "");
        Intrinsics.checkNotNullExpressionValue(decodeString3, "entity.decodeString(KEY_\u2026_EMOJI_TEMPLATE_PATH, \"\")");
        this.emojiTemplatePath = decodeString3;
        QLog.d("KernelQQSysAndEmojiResMgr", 1, "[initPathInfo] sysFaceApngTemplatePath=" + this.sysFaceApngTemplatePath, ", sysFaceStaticTemplatePath=" + this.sysFaceStaticTemplatePath, ", emojiTemplatePath=" + this.emojiTemplatePath);
    }

    private final void p(boolean initAsync) {
        if (initAsync) {
            com.tencent.mobileqq.emoticon.rare.config.c.f204869a.d();
        } else {
            com.tencent.mobileqq.emoticon.rare.config.c.f204869a.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(final KernelQQSysAndEmojiResMgr this$0, int i3, String str, final PullSysEmojisRsp pullSysEmojisRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("KernelQQSysAndEmojiResMgr", 1, "[refreshConfig] fetchFullSysEmojis onResult, result=", Integer.valueOf(i3), ", errMsg=", str);
        if (i3 == 0 && pullSysEmojisRsp != null) {
            this$0.q(pullSysEmojisRsp);
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool("keyHasDownloadedFullRes", true);
            this$0.mQQSysFaceResImpl.i(true);
            this$0.mEmojiResImpl.d(true);
            QQSysAndEmojiResReloader.IResReloadListener iResReloadListener = this$0.mLottieResReloadListener;
            if (iResReloadListener != null) {
                iResReloadListener.resDownloadFinish();
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticon.kernel.f
                @Override // java.lang.Runnable
                public final void run() {
                    KernelQQSysAndEmojiResMgr.t(KernelQQSysAndEmojiResMgr.this, pullSysEmojisRsp);
                }
            }, 64, null, false);
            this$0.mHasRefreshConfig = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(KernelQQSysAndEmojiResMgr this$0, PullSysEmojisRsp pullSysEmojisRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x(pullSysEmojisRsp);
        this$0.u();
    }

    private final void u() {
        this.sysFaceApngTemplatePath = getFullResPath(4, -1);
        this.sysFaceStaticTemplatePath = getFullResPath(2, -1);
        this.emojiTemplatePath = getFullResPath(3, -1);
        QLog.d("KernelQQSysAndEmojiResMgr", 1, "[savePathInfo] sysFaceApngTemplatePath=" + this.sysFaceApngTemplatePath, ", sysFaceStaticTemplatePath=" + this.sysFaceStaticTemplatePath, ", emojiTemplatePath=" + this.emojiTemplatePath);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeString("sysFaceAPNGTemplatePath", this.sysFaceApngTemplatePath);
        from.encodeString("sysFaceStaticTemplatePath", this.sysFaceStaticTemplatePath);
        from.encodeString("emojiTemplatePath", this.emojiTemplatePath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean w() {
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("emotion_single_pull_notify_910_enabled", true);
    }

    private final void x(PullSysEmojisRsp pullSysEmojisRsp) {
        try {
            FileUtils.writeFile(k(), new Gson().toJson(pullSysEmojisRsp));
        } catch (Throwable th5) {
            QLog.e("KernelQQSysAndEmojiResMgr", 1, "[writeSysEmojiConfigDataToFile] error. stack=", th5);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.e
    public void downloadEmoticonRes(@NotNull List<Integer> downloadResTypeList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) downloadResTypeList);
        } else {
            Intrinsics.checkNotNullParameter(downloadResTypeList, "downloadResTypeList");
        }
    }

    @Override // com.tencent.mobileqq.emoticon.d
    @NotNull
    public String getAniStickerLoadingResPath(int serverId) {
        BaseEmojiPathInfo baseEmojiPathInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this, serverId);
        }
        GetBaseEmojiPathReq getBaseEmojiPathReq = new GetBaseEmojiPathReq();
        getBaseEmojiPathReq.type = BaseEmojiType.NORMAL_EMOJI;
        getBaseEmojiPathReq.emojiId = String.valueOf(serverId);
        com.tencent.qqnt.kernel.api.i a16 = com.tencent.qqnt.msg.f.a();
        String str = null;
        if (a16 != null) {
            baseEmojiPathInfo = a16.S(getBaseEmojiPathReq);
        } else {
            baseEmojiPathInfo = null;
        }
        if (baseEmojiPathInfo != null) {
            str = baseEmojiPathInfo.pngDirPath;
        }
        return str + "/" + serverId + "_0.png";
    }

    @Override // com.tencent.mobileqq.emoticon.d
    @NotNull
    public String getAniStickerRandomResultFullResPath(int serverId, @NotNull String aniStickerPackId, @NotNull String aniStickerId, @NotNull String resultId) {
        BaseEmojiPathInfo baseEmojiPathInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, this, Integer.valueOf(serverId), aniStickerPackId, aniStickerId, resultId);
        }
        Intrinsics.checkNotNullParameter(aniStickerPackId, "aniStickerPackId");
        Intrinsics.checkNotNullParameter(aniStickerId, "aniStickerId");
        Intrinsics.checkNotNullParameter(resultId, "resultId");
        GetBaseEmojiPathReq getBaseEmojiPathReq = new GetBaseEmojiPathReq();
        getBaseEmojiPathReq.type = BaseEmojiType.RANDOM_SUPER_EMOJI;
        getBaseEmojiPathReq.emojiId = String.valueOf(serverId);
        com.tencent.qqnt.kernel.api.i a16 = com.tencent.qqnt.msg.f.a();
        String str = null;
        if (a16 != null) {
            baseEmojiPathInfo = a16.S(getBaseEmojiPathReq);
        } else {
            baseEmojiPathInfo = null;
        }
        if (baseEmojiPathInfo != null) {
            str = baseEmojiPathInfo.lottiDirPath;
        }
        return str + "/" + serverId + "_" + resultId + Sticker.JSON_SUFFIX;
    }

    @Override // com.tencent.mobileqq.emoticon.d
    @NotNull
    public String getAniStickerResPath(int serverId, @NotNull String aniStickerPackId, @NotNull String aniStickerId) {
        BaseEmojiPathInfo baseEmojiPathInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(serverId), aniStickerPackId, aniStickerId);
        }
        Intrinsics.checkNotNullParameter(aniStickerPackId, "aniStickerPackId");
        Intrinsics.checkNotNullParameter(aniStickerId, "aniStickerId");
        GetBaseEmojiPathReq getBaseEmojiPathReq = new GetBaseEmojiPathReq();
        getBaseEmojiPathReq.type = BaseEmojiType.SUPER_EMOJI;
        getBaseEmojiPathReq.emojiId = String.valueOf(serverId);
        com.tencent.qqnt.kernel.api.i a16 = com.tencent.qqnt.msg.f.a();
        String str = null;
        if (a16 != null) {
            baseEmojiPathInfo = a16.S(getBaseEmojiPathReq);
        } else {
            baseEmojiPathInfo = null;
        }
        if (baseEmojiPathInfo != null) {
            str = baseEmojiPathInfo.lottiDirPath;
        }
        return str + "/" + serverId + Sticker.JSON_SUFFIX;
    }

    @Override // com.tencent.mobileqq.emoticon.d
    @NotNull
    public String getAniStickerSurpriseFullResPath(int serverId, @NotNull String aniStickerPackId, @NotNull String aniStickerId, @NotNull String surpriseId, boolean isPadLandScape) {
        BaseEmojiPathInfo baseEmojiPathInfo;
        StringBuilder sb5;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, this, Integer.valueOf(serverId), aniStickerPackId, aniStickerId, surpriseId, Boolean.valueOf(isPadLandScape));
        }
        Intrinsics.checkNotNullParameter(aniStickerPackId, "aniStickerPackId");
        Intrinsics.checkNotNullParameter(aniStickerId, "aniStickerId");
        Intrinsics.checkNotNullParameter(surpriseId, "surpriseId");
        GetBaseEmojiPathReq getBaseEmojiPathReq = new GetBaseEmojiPathReq();
        getBaseEmojiPathReq.type = BaseEmojiType.RANDOM_SUPER_EMOJI;
        getBaseEmojiPathReq.emojiId = String.valueOf(serverId);
        com.tencent.qqnt.kernel.api.i a16 = com.tencent.qqnt.msg.f.a();
        String str2 = null;
        if (a16 != null) {
            baseEmojiPathInfo = a16.S(getBaseEmojiPathReq);
        } else {
            baseEmojiPathInfo = null;
        }
        if (isPadLandScape) {
            sb5 = new StringBuilder();
            sb5.append(surpriseId);
            str = "_padLandScape.json";
        } else {
            sb5 = new StringBuilder();
            sb5.append(surpriseId);
            str = Sticker.JSON_SUFFIX;
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        if (baseEmojiPathInfo != null) {
            str2 = baseEmojiPathInfo.lottiDirPath;
        }
        return str2 + "/surprise/" + sb6;
    }

    @Override // com.tencent.mobileqq.emoticon.d
    @NotNull
    public String getFullResPath(int type, int serverId) {
        String str;
        BaseEmojiPathInfo baseEmojiPathInfo;
        String replace$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(type), Integer.valueOf(serverId));
        }
        if (type != 4 && type != 2 && type != 3) {
            QLog.d("KernelQQSysAndEmojiResMgr", 1, "[getFullResPath] not support type=" + type + ", serverId=" + serverId);
            return "";
        }
        GetBaseEmojiPathReq getBaseEmojiPathReq = new GetBaseEmojiPathReq();
        if (type == 3) {
            getBaseEmojiPathReq.type = BaseEmojiType.EMOJI_EMOJI;
            getBaseEmojiPathReq.emojiId = this.mEmojiResImpl.getQSid(QQEmojiUtil.getEmojiLocalId(serverId));
            str = this.emojiTemplatePath;
        } else {
            getBaseEmojiPathReq.type = BaseEmojiType.NORMAL_EMOJI;
            getBaseEmojiPathReq.emojiId = String.valueOf(serverId);
            if (type == 4) {
                str = this.sysFaceApngTemplatePath;
            } else {
                str = this.sysFaceStaticTemplatePath;
            }
        }
        String str2 = str;
        if (h() && !TextUtils.isEmpty(str2)) {
            String str3 = getBaseEmojiPathReq.emojiId;
            Intrinsics.checkNotNullExpressionValue(str3, "baseEmojiPathReq.emojiId");
            replace$default = StringsKt__StringsJVMKt.replace$default(str2, "-1", str3, false, 4, (Object) null);
            return replace$default;
        }
        com.tencent.qqnt.kernel.api.i a16 = com.tencent.qqnt.msg.f.a();
        String str4 = null;
        if (a16 != null) {
            baseEmojiPathInfo = a16.S(getBaseEmojiPathReq);
        } else {
            baseEmojiPathInfo = null;
        }
        if (type == 4) {
            if (baseEmojiPathInfo != null) {
                str4 = baseEmojiPathInfo.apngDirPath;
            }
        } else if (baseEmojiPathInfo != null) {
            str4 = baseEmojiPathInfo.pngDirPath;
        }
        return str4 + "/" + getBaseEmojiPathReq.emojiId + ".png";
    }

    @Override // com.tencent.mobileqq.emoticon.d
    @NotNull
    public Pair<String, Boolean> getSysFaceFullResPath(int type, int serverId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Pair) iPatchRedirector.redirect((short) 17, this, Integer.valueOf(type), Integer.valueOf(serverId));
        }
        if (type != 4 && type != 2) {
            QLog.d("KernelQQSysAndEmojiResMgr", 4, "[getSysFaceFullResPath] not support type=" + type + ", serverId=" + serverId);
            return new Pair<>(null, Boolean.FALSE);
        }
        if (type == 4) {
            String fullResPath = getFullResPath(type, serverId);
            if (FileUtils.fileExists(fullResPath)) {
                return new Pair<>(fullResPath, Boolean.TRUE);
            }
        }
        String fullResPath2 = getFullResPath(2, serverId);
        if (FileUtils.fileExists(fullResPath2)) {
            if (QLog.isColorLevel()) {
                QLog.i("KernelQQSysAndEmojiResMgr", 2, "getSysFaceFullResPath() ----- static  path:" + fullResPath2 + "  type:" + type);
            }
            return new Pair<>(fullResPath2, Boolean.TRUE);
        }
        return new Pair<>(null, Boolean.FALSE);
    }

    protected boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return QQSysFaceSwitcher.f204652a.i();
    }

    @Override // com.tencent.mobileqq.emoticon.e
    @NotNull
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mEmojiResImpl;
    }

    @Override // com.tencent.mobileqq.emoticon.e
    public void initConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.mIsDoingInitConfig) {
            return;
        }
        p(true);
        if (this.mQQSysFaceResImpl.getConfigEmoCount() > 0) {
            return;
        }
        o();
        l();
    }

    @Override // com.tencent.mobileqq.emoticon.e
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public n c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (n) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mQQSysFaceResImpl;
    }

    protected void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.qqnt.kernel.api.i a16 = com.tencent.qqnt.msg.f.a();
        if (a16 == null) {
            QLog.e("KernelQQSysAndEmojiResMgr", 1, "[initConfig] return,  baseEmojiService is null!");
            return;
        }
        this.mIsDoingInitConfig = true;
        PullSysEmojisReq pullSysEmojisReq = new PullSysEmojisReq();
        pullSysEmojisReq.pullType = 7;
        pullSysEmojisReq.pullMoment = PullMomentType.REINSTALL;
        pullSysEmojisReq.refresh = false;
        pullSysEmojisReq.fetchBaseSource = true;
        pullSysEmojisReq.fetchAdvaceSource = false;
        pullSysEmojisReq.thresholdValue = 40;
        QLog.d("KernelQQSysAndEmojiResMgr", 1, "[initConfig] fetchFullSysEmojis start. pullSysEmojisReq=" + pullSysEmojisReq);
        a16.fetchFullSysEmojis(pullSysEmojisReq, new IFetchFullSysEmojisCallback() { // from class: com.tencent.mobileqq.emoticon.kernel.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchFullSysEmojisCallback
            public final void onResult(int i3, String str, PullSysEmojisRsp pullSysEmojisRsp) {
                KernelQQSysAndEmojiResMgr.m(KernelQQSysAndEmojiResMgr.this, i3, str, pullSysEmojisRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(@NotNull PullSysEmojisRsp rsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) rsp);
            return;
        }
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        this.mQQSysFaceResImpl.parseConfigData(new c(rsp.getNormalPanelResult(), rsp.getSuperPanelResult(), rsp.getRedHeartPanelResult(), rsp.getOtherPanelResult()));
        this.mEmojiResImpl.parseConfigData(new c(rsp.getNormalPanelResult(), null, null, null));
    }

    @Nullable
    public final PullSysEmojisRsp r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (PullSysEmojisRsp) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        try {
            return (PullSysEmojisRsp) new Gson().fromJson(FileUtils.readFileContent(new File(k())), PullSysEmojisRsp.class);
        } catch (Throwable th5) {
            QLog.e("KernelQQSysAndEmojiResMgr", 1, "[writeSysEmojiConfigDataToFile] error. stack=", th5);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.emoticon.e
    public void refreshConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            e.a.a(this, PullMomentType.RESTART_FIRST_AIO, false, false, 6, null);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.e
    public void setLottieResReloadListener(@Nullable QQSysAndEmojiResReloader.IResReloadListener lottieResReloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) lottieResReloadListener);
        } else {
            this.mLottieResReloadListener = lottieResReloadListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.mIsDoingInitConfig = z16;
        }
    }

    @Override // com.tencent.mobileqq.emoticon.e
    public void refreshConfig(@NotNull PullMomentType pullMomentType, boolean fetchBaseSource, boolean force) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, pullMomentType, Boolean.valueOf(fetchBaseSource), Boolean.valueOf(force));
            return;
        }
        Intrinsics.checkNotNullParameter(pullMomentType, "pullMomentType");
        QLog.d("KernelQQSysAndEmojiResMgr", 4, "refreshConfig pullMomentType: " + pullMomentType + ", fetchBaseSource: " + fetchBaseSource + ", force: " + force);
        if (this.mIsNeedReInitConfig) {
            this.mIsNeedReInitConfig = false;
            QLog.d("KernelQQSysAndEmojiResMgr", 1, "[refreshConfig] return, NeedReInitConfig.");
            l();
            return;
        }
        if (!this.mIsDoingInitConfig && (!this.mHasRefreshConfig || force)) {
            com.tencent.qqnt.kernel.api.i a16 = com.tencent.qqnt.msg.f.a();
            if (a16 == null) {
                QLog.d("KernelQQSysAndEmojiResMgr", 1, "[refreshConfig] return,  baseEmojiService is null!");
                return;
            }
            PullSysEmojisReq pullSysEmojisReq = new PullSysEmojisReq();
            pullSysEmojisReq.pullType = 7;
            pullSysEmojisReq.pullMoment = pullMomentType;
            pullSysEmojisReq.refresh = true;
            pullSysEmojisReq.fetchBaseSource = fetchBaseSource;
            pullSysEmojisReq.fetchAdvaceSource = true;
            pullSysEmojisReq.thresholdValue = 40;
            QLog.d("KernelQQSysAndEmojiResMgr", 1, "[refreshConfig] fetchFullSysEmojis start. pullSysEmojisReq=" + pullSysEmojisReq);
            a16.fetchFullSysEmojis(pullSysEmojisReq, new IFetchFullSysEmojisCallback() { // from class: com.tencent.mobileqq.emoticon.kernel.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchFullSysEmojisCallback
                public final void onResult(int i3, String str, PullSysEmojisRsp pullSysEmojisRsp) {
                    KernelQQSysAndEmojiResMgr.s(KernelQQSysAndEmojiResMgr.this, i3, str, pullSysEmojisRsp);
                }
            });
            return;
        }
        QLog.d("KernelQQSysAndEmojiResMgr", 1, "[refreshConfig] return. mIsInInitConfig=" + this.mIsDoingInitConfig);
    }
}
