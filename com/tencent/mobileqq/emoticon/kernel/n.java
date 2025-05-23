package com.tencent.mobileqq.emoticon.kernel;

import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceResImpl;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.anisticker.view.AniStickerLottieView;
import com.tencent.qqnt.kernel.nativeinterface.BaseEmojiPathInfo;
import com.tencent.qqnt.kernel.nativeinterface.BaseEmojiType;
import com.tencent.qqnt.kernel.nativeinterface.BasePanelResult;
import com.tencent.qqnt.kernel.nativeinterface.DownloadBaseEmojiByIdReq;
import com.tencent.qqnt.kernel.nativeinterface.DownloadBaseEmojiByUrlReq;
import com.tencent.qqnt.kernel.nativeinterface.EmojiPanelCategory;
import com.tencent.qqnt.kernel.nativeinterface.IDownloadBaseEmojiByIdCallback;
import com.tencent.qqnt.kernel.nativeinterface.IDownloadBaseEmojiByIdWithUrlCallback;
import com.tencent.qqnt.kernel.nativeinterface.SysEmoji;
import com.tencent.qqnt.kernel.nativeinterface.SysEmojiGroup;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b,\u0010-JP\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R8\u0010(\u001a&\u0012\f\u0012\n $*\u0004\u0018\u00010\u00070\u0007 $*\u0012\u0012\f\u0012\n $*\u0004\u0018\u00010\u00070\u0007\u0018\u00010%0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/emoticon/kernel/n;", "Lcom/tencent/mobileqq/emoticon/QQSysFaceResImpl;", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiPanelCategory;", "emojiPanelCategory", "Lcom/tencent/qqnt/kernel/nativeinterface/SysEmojiGroup;", "sysEmojiGroup", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "orderList", "aniStickerOrderList", "", tl.h.F, "", "lottieResCacheKey", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/SysEmoji;", "sysEmoji", "g", "Lkotlin/Function0;", "callback", "j", "Lcom/tencent/mobileqq/emoticon/a;", "configData", "parseConfigData", "localId", "addReloadDrawable", "d", "addAniStickerReloadDrawable", "", "enableSingleDownloadFace", "i", "a", "Z", "mEnableSingleDownloadFace", "", "kotlin.jvm.PlatformType", "", "b", "Ljava/util/Set;", "mSingleDownloadFaceLocalIds", "c", "Lkotlin/jvm/functions/Function0;", "mOnRefreshConfigCallback", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class n extends QQSysFaceResImpl {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean mEnableSingleDownloadFace;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Set<Integer> mSingleDownloadFaceLocalIds;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> mOnRefreshConfigCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/emoticon/kernel/n$a;", "", "", "SINGLE_DOWNLOAD_FACE_LIMIT_COUNT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emoticon.kernel.n$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f204836a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32399);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[BaseEmojiType.values().length];
            try {
                iArr[BaseEmojiType.SUPER_EMOJI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BaseEmojiType.RANDOM_SUPER_EMOJI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BaseEmojiType.CHAIN_SUPER_EMOJI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BaseEmojiType.NORMAL_EMOJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f204836a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32401);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mSingleDownloadFaceLocalIds = Collections.synchronizedSet(new HashSet());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(DownloadBaseEmojiByIdReq req, n this$0, int i3, String str, int i16, String str2, SysEmoji sysEmoji, BaseEmojiPathInfo baseEmojiPathInfo) {
        Boolean bool;
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (sysEmoji != null) {
            bool = Boolean.valueOf(sysEmoji.needRefreshPanel);
        } else {
            bool = null;
        }
        QLog.d("KernelQQSysFaceResImpl", 2, "[addReloadDrawable] downloadBaseEmojiById req=" + req + " result=" + i16 + " errMsg=" + str2 + ", needRefreshPanel=" + bool);
        if (i16 == 0) {
            this$0.mSingleDownloadFaceLocalIds.remove(Integer.valueOf(i3));
            if (QQSysFaceSwitcher.f204652a.c() && sysEmoji != null) {
                this$0.g(sysEmoji);
            }
            if (str != null) {
                this$0.k(str);
            }
            boolean z16 = false;
            if (sysEmoji != null && sysEmoji.needRefreshPanel) {
                z16 = true;
            }
            if (z16 && (function0 = this$0.mOnRefreshConfigCallback) != null) {
                function0.invoke();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(DownloadBaseEmojiByUrlReq req, n this$0, int i3, String str, int i16, String str2, BaseEmojiPathInfo baseEmojiPathInfo) {
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("KernelQQSysFaceResImpl", 2, "[addReloadDrawable] downloadBaseEmojiByIdWithUrl req=" + req + " result=" + i16 + " errMsg=" + str2);
        if (i16 == 0) {
            this$0.mSingleDownloadFaceLocalIds.remove(Integer.valueOf(i3));
            if (str != null) {
                this$0.k(str);
            }
        }
    }

    private final void g(SysEmoji sysEmoji) {
        try {
            String str = sysEmoji.emojiId;
            Intrinsics.checkNotNullExpressionValue(str, "sysEmoji.emojiId");
            if (!this.mConfigItemMap.containsKey(Integer.valueOf(QQSysFaceUtil.convertToLocal(Integer.parseInt(str))))) {
                parseQQEmoConfigItem(j.a(EmojiPanelCategory.OTHER_PANEL, "", sysEmoji), null, null);
            }
        } catch (Throwable th5) {
            QLog.e("KernelQQSysFaceResImpl", 2, "[addSingleDownloadEmojiInfoToCache] error. stack=", th5);
        }
    }

    private final void h(EmojiPanelCategory emojiPanelCategory, SysEmojiGroup sysEmojiGroup, ArrayList<Integer> orderList, ArrayList<Integer> aniStickerOrderList) {
        Iterator<SysEmoji> it = sysEmojiGroup.getSysEmojiList().iterator();
        while (it.hasNext()) {
            SysEmoji sysEmoji = it.next();
            try {
                String str = sysEmojiGroup.groupName;
                Intrinsics.checkNotNullExpressionValue(str, "sysEmojiGroup.groupName");
                Intrinsics.checkNotNullExpressionValue(sysEmoji, "sysEmoji");
                parseQQEmoConfigItem(j.a(emojiPanelCategory, str, sysEmoji), orderList, aniStickerOrderList);
            } catch (Throwable th5) {
                QLog.e("KernelQQSysFaceResImpl", 2, "[parseConfigInner] error. stack=", th5);
            }
        }
    }

    private final void k(final String lottieResCacheKey) {
        UiThreadUtil.runOnUiThreadWithCheck(new Runnable() { // from class: com.tencent.mobileqq.emoticon.kernel.m
            @Override // java.lang.Runnable
            public final void run() {
                n.l(lottieResCacheKey);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(String lottieResCacheKey) {
        Intrinsics.checkNotNullParameter(lottieResCacheKey, "$lottieResCacheKey");
        AniStickerLottieView.INSTANCE.h(lottieResCacheKey);
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysFaceResImpl
    public void addAniStickerReloadDrawable(int localId, @NotNull String lottieResCacheKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, localId, (Object) lottieResCacheKey);
            return;
        }
        Intrinsics.checkNotNullParameter(lottieResCacheKey, "lottieResCacheKey");
        if (QQSysFaceSwitcher.f204652a.l()) {
            d(localId, lottieResCacheKey);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public void addReloadDrawable(int localId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, localId);
        } else {
            d(localId, null);
        }
    }

    public final void d(final int localId, @Nullable final String lottieResCacheKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, localId, (Object) lottieResCacheKey);
            return;
        }
        super.addReloadDrawable(localId);
        if (!this.mEnableSingleDownloadFace) {
            return;
        }
        com.tencent.qqnt.kernel.api.i a16 = com.tencent.qqnt.msg.f.a();
        if (a16 == null) {
            QLog.d("KernelQQSysFaceResImpl", 1, "[addReloadDrawable] reload localId " + localId + " error,  baseEmojiService is null!");
            return;
        }
        if (this.mSingleDownloadFaceLocalIds.size() < 10 && !this.mSingleDownloadFaceLocalIds.contains(Integer.valueOf(localId))) {
            int serverId = getServerId(localId);
            this.mSingleDownloadFaceLocalIds.add(Integer.valueOf(localId));
            String fullResPath = QQSysAndEmojiResMgr.getInstance().getFullResPath(2, serverId);
            Intrinsics.checkNotNullExpressionValue(fullResPath, "getInstance()\n          \u2026S_QQSYS_STATIC, serverId)");
            QQSysAndEmojiResInfo.a aVar = null;
            if (FileUtils.fileExists(fullResPath)) {
                final DownloadBaseEmojiByUrlReq downloadBaseEmojiByUrlReq = new DownloadBaseEmojiByUrlReq();
                downloadBaseEmojiByUrlReq.emojiId = String.valueOf(serverId);
                QQSysAndEmojiResInfo.QQEmoConfigItem configItem = getConfigItem(localId);
                if (configItem instanceof QQSysAndEmojiResInfo.a) {
                    aVar = (QQSysAndEmojiResInfo.a) configItem;
                }
                if (aVar != null) {
                    downloadBaseEmojiByUrlReq.groupName = aVar.AniStickerPackName;
                    downloadBaseEmojiByUrlReq.panelCategory = aVar.f204651b;
                    downloadBaseEmojiByUrlReq.downloadInfo = aVar.f204650a;
                }
                QLog.d("KernelQQSysFaceResImpl", 1, "[downloadBaseEmojiByIdWithUrl] req=" + downloadBaseEmojiByUrlReq + ", serverId=" + serverId);
                a16.downloadBaseEmojiByIdWithUrl(downloadBaseEmojiByUrlReq, new IDownloadBaseEmojiByIdWithUrlCallback() { // from class: com.tencent.mobileqq.emoticon.kernel.k
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IDownloadBaseEmojiByIdWithUrlCallback
                    public final void onResult(int i3, String str, BaseEmojiPathInfo baseEmojiPathInfo) {
                        n.f(DownloadBaseEmojiByUrlReq.this, this, localId, lottieResCacheKey, i3, str, baseEmojiPathInfo);
                    }
                });
                return;
            }
            final DownloadBaseEmojiByIdReq downloadBaseEmojiByIdReq = new DownloadBaseEmojiByIdReq();
            downloadBaseEmojiByIdReq.emojiId = String.valueOf(serverId);
            QQSysAndEmojiResInfo.QQEmoConfigItem configItem2 = getConfigItem(localId);
            if (configItem2 instanceof QQSysAndEmojiResInfo.a) {
                aVar = (QQSysAndEmojiResInfo.a) configItem2;
            }
            if (aVar != null) {
                downloadBaseEmojiByIdReq.groupName = aVar.AniStickerPackName;
                downloadBaseEmojiByIdReq.panelCategory = aVar.f204651b;
            }
            QLog.d("KernelQQSysFaceResImpl", 1, "[downloadBaseEmojiById] req=" + downloadBaseEmojiByIdReq + ", pngPath=" + fullResPath);
            a16.downloadBaseEmojiById(downloadBaseEmojiByIdReq, new IDownloadBaseEmojiByIdCallback() { // from class: com.tencent.mobileqq.emoticon.kernel.l
                @Override // com.tencent.qqnt.kernel.nativeinterface.IDownloadBaseEmojiByIdCallback
                public final void onResult(int i3, String str, SysEmoji sysEmoji, BaseEmojiPathInfo baseEmojiPathInfo) {
                    n.e(DownloadBaseEmojiByIdReq.this, this, localId, lottieResCacheKey, i3, str, sysEmoji, baseEmojiPathInfo);
                }
            });
        }
    }

    public final void i(boolean enableSingleDownloadFace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, enableSingleDownloadFace);
        } else {
            this.mEnableSingleDownloadFace = enableSingleDownloadFace;
        }
    }

    public final void j(@Nullable Function0<Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
        } else {
            this.mOnRefreshConfigCallback = callback;
        }
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysFaceResImpl, com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public void parseConfigData(@NotNull com.tencent.mobileqq.emoticon.a configData) {
        boolean z16;
        ArrayList<SysEmojiGroup> sysEmojiGroupList;
        int i3;
        ArrayList<SysEmojiGroup> sysEmojiGroupList2;
        int i16;
        ArrayList<SysEmojiGroup> sysEmojiGroupList3;
        int i17;
        BasePanelResult b16;
        ArrayList<SysEmojiGroup> sysEmojiGroupList4;
        int i18;
        ArrayList<SysEmojiGroup> sysEmojiGroupList5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) configData);
            return;
        }
        Intrinsics.checkNotNullParameter(configData, "configData");
        if (!(configData instanceof c)) {
            return;
        }
        c cVar = (c) configData;
        if (cVar.a() != null) {
            BasePanelResult a16 = cVar.a();
            if (a16 != null && (sysEmojiGroupList5 = a16.getSysEmojiGroupList()) != null && (!sysEmojiGroupList5.isEmpty())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Object mLock = this.mLock;
                Intrinsics.checkNotNullExpressionValue(mLock, "mLock");
                synchronized (mLock) {
                    clearCacheData();
                    Unit unit = Unit.INSTANCE;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (QQSysFaceSwitcher.f204652a.c() && (b16 = cVar.b()) != null && (sysEmojiGroupList4 = b16.getSysEmojiGroupList()) != null) {
                    QLog.d("KernelQQSysFaceResImpl", 1, "[parseConfigData] otherPanelResult.size=" + sysEmojiGroupList4.size());
                    Iterator<SysEmojiGroup> it = sysEmojiGroupList4.iterator();
                    while (it.hasNext()) {
                        SysEmojiGroup sysEmojiGroup = it.next();
                        if (!sysEmojiGroup.getSysEmojiList().isEmpty()) {
                            BaseEmojiType baseEmojiType = sysEmojiGroup.getSysEmojiList().get(0).emojiType;
                            if (baseEmojiType == null) {
                                i18 = -1;
                            } else {
                                i18 = b.f204836a[baseEmojiType.ordinal()];
                            }
                            if (i18 == 1 || i18 == 2 || i18 == 3) {
                                EmojiPanelCategory emojiPanelCategory = EmojiPanelCategory.OTHER_PANEL;
                                Intrinsics.checkNotNullExpressionValue(sysEmojiGroup, "sysEmojiGroup");
                                h(emojiPanelCategory, sysEmojiGroup, null, null);
                            }
                        }
                    }
                }
                BasePanelResult a17 = cVar.a();
                if (a17 != null && (sysEmojiGroupList3 = a17.getSysEmojiGroupList()) != null) {
                    QLog.d("KernelQQSysFaceResImpl", 1, "[parseConfigData] normalPanelResult.size=" + sysEmojiGroupList3.size());
                    Iterator<SysEmojiGroup> it5 = sysEmojiGroupList3.iterator();
                    while (it5.hasNext()) {
                        SysEmojiGroup sysEmojiGroup2 = it5.next();
                        if (!sysEmojiGroup2.getSysEmojiList().isEmpty()) {
                            BaseEmojiType baseEmojiType2 = sysEmojiGroup2.getSysEmojiList().get(0).emojiType;
                            if (baseEmojiType2 == null) {
                                i17 = -1;
                            } else {
                                i17 = b.f204836a[baseEmojiType2.ordinal()];
                            }
                            if (i17 != 1 && i17 != 2 && i17 != 3) {
                                if (i17 == 4) {
                                    EmojiPanelCategory emojiPanelCategory2 = EmojiPanelCategory.NORMAL_PANEL;
                                    Intrinsics.checkNotNullExpressionValue(sysEmojiGroup2, "sysEmojiGroup");
                                    h(emojiPanelCategory2, sysEmojiGroup2, this.mOrderList, null);
                                }
                            } else {
                                EmojiPanelCategory emojiPanelCategory3 = EmojiPanelCategory.NORMAL_PANEL;
                                Intrinsics.checkNotNullExpressionValue(sysEmojiGroup2, "sysEmojiGroup");
                                h(emojiPanelCategory3, sysEmojiGroup2, this.mOrderList, this.mAniStickerOrderList);
                            }
                        }
                    }
                }
                BasePanelResult d16 = cVar.d();
                if (d16 != null && (sysEmojiGroupList2 = d16.getSysEmojiGroupList()) != null) {
                    QLog.d("KernelQQSysFaceResImpl", 1, "[parseConfigData] superPanelResult.size=" + sysEmojiGroupList2.size());
                    Iterator<SysEmojiGroup> it6 = sysEmojiGroupList2.iterator();
                    while (it6.hasNext()) {
                        SysEmojiGroup sysEmojiGroup3 = it6.next();
                        if (!sysEmojiGroup3.getSysEmojiList().isEmpty()) {
                            BaseEmojiType baseEmojiType3 = sysEmojiGroup3.getSysEmojiList().get(0).emojiType;
                            if (baseEmojiType3 == null) {
                                i16 = -1;
                            } else {
                                i16 = b.f204836a[baseEmojiType3.ordinal()];
                            }
                            if (i16 == 1 || i16 == 2 || i16 == 3) {
                                EmojiPanelCategory emojiPanelCategory4 = EmojiPanelCategory.SUPER_PANEL;
                                Intrinsics.checkNotNullExpressionValue(sysEmojiGroup3, "sysEmojiGroup");
                                h(emojiPanelCategory4, sysEmojiGroup3, null, this.mExtAniStickerOrderList);
                            }
                        }
                    }
                }
                BasePanelResult c16 = cVar.c();
                if (c16 != null && (sysEmojiGroupList = c16.getSysEmojiGroupList()) != null) {
                    QLog.d("KernelQQSysFaceResImpl", 1, "[parseConfigData] redHeartPanelResult.size=" + sysEmojiGroupList.size());
                    Iterator<SysEmojiGroup> it7 = sysEmojiGroupList.iterator();
                    while (it7.hasNext()) {
                        SysEmojiGroup sysEmojiGroup4 = it7.next();
                        if (!sysEmojiGroup4.getSysEmojiList().isEmpty()) {
                            BaseEmojiType baseEmojiType4 = sysEmojiGroup4.getSysEmojiList().get(0).emojiType;
                            if (baseEmojiType4 == null) {
                                i3 = -1;
                            } else {
                                i3 = b.f204836a[baseEmojiType4.ordinal()];
                            }
                            if (i3 == 1 || i3 == 2 || i3 == 3) {
                                EmojiPanelCategory emojiPanelCategory5 = EmojiPanelCategory.RED_HEART_PANEL;
                                Intrinsics.checkNotNullExpressionValue(sysEmojiGroup4, "sysEmojiGroup");
                                h(emojiPanelCategory5, sysEmojiGroup4, null, this.mFavPanelAniStickerOrderList);
                            }
                        }
                    }
                }
                resDownloadFinish();
                QLog.d("KernelQQSysFaceResImpl", 1, "sysface configItem:", Integer.valueOf(this.mConfigItemMap.size()), ", orderlist:", Integer.valueOf(this.mOrderList.size()), ", extAniStickerOrderlist:", Integer.valueOf(this.mExtAniStickerOrderList.size()), ", favPanelAniStickerOrderList:", Integer.valueOf(this.mFavPanelAniStickerOrderList.size()), ", maxLid:", Integer.valueOf(this.mMaxLocalId), ", maxSid:", Integer.valueOf(this.mMaxServerId), ", costTime = [", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "]");
                return;
            }
        }
        QLog.e("KernelQQSysFaceResImpl", 1, "[parseConfigData] normalPanelResult is empty.");
    }
}
