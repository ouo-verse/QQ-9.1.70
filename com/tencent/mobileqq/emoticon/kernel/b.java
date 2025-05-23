package com.tencent.mobileqq.emoticon.kernel;

import com.tencent.mobileqq.emoticon.QQEmojiResImpl;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BaseEmojiPathInfo;
import com.tencent.qqnt.kernel.nativeinterface.BaseEmojiType;
import com.tencent.qqnt.kernel.nativeinterface.BasePanelResult;
import com.tencent.qqnt.kernel.nativeinterface.DownloadBaseEmojiByIdReq;
import com.tencent.qqnt.kernel.nativeinterface.EmojiPanelCategory;
import com.tencent.qqnt.kernel.nativeinterface.IDownloadBaseEmojiByIdCallback;
import com.tencent.qqnt.kernel.nativeinterface.SysEmoji;
import com.tencent.qqnt.kernel.nativeinterface.SysEmojiGroup;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fR\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R8\u0010\u001a\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\f0\f \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\f0\f\u0018\u00010\u00170\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/emoticon/kernel/b;", "Lcom/tencent/mobileqq/emoticon/QQEmojiResImpl;", "Lcom/tencent/qqnt/kernel/nativeinterface/SysEmojiGroup;", "sysEmojiGroup", "", "c", "Lkotlin/Function0;", "callback", "e", "Lcom/tencent/mobileqq/emoticon/a;", "configData", "parseConfigData", "", "localId", "addReloadDrawable", "", "enableSingleDownloadFace", "d", "a", "Z", "mEnableSingleDownloadFace", "", "kotlin.jvm.PlatformType", "", "b", "Ljava/util/Set;", "mSingleDownloadFaceLocalIds", "Lkotlin/jvm/functions/Function0;", "mOnRefreshConfigCallback", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends QQEmojiResImpl {
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
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/emoticon/kernel/b$a;", "", "", "SINGLE_DOWNLOAD_FACE_LIMIT_COUNT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emoticon.kernel.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31434);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mSingleDownloadFaceLocalIds = Collections.synchronizedSet(new HashSet());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DownloadBaseEmojiByIdReq req, b this$0, int i3, int i16, String str, SysEmoji sysEmoji, BaseEmojiPathInfo baseEmojiPathInfo) {
        Boolean bool;
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (sysEmoji != null) {
            bool = Boolean.valueOf(sysEmoji.needRefreshPanel);
        } else {
            bool = null;
        }
        boolean z16 = true;
        QLog.d("KernelQQEmojiResImpl", 1, "[addReloadDrawable] downloadBaseEmojiById req=" + req + " result=" + i16 + " errMsg=" + str + ", needRefreshPanel=" + bool);
        if (i16 == 0) {
            this$0.mSingleDownloadFaceLocalIds.remove(Integer.valueOf(i3));
            if (sysEmoji == null || !sysEmoji.needRefreshPanel) {
                z16 = false;
            }
            if (z16 && (function0 = this$0.mOnRefreshConfigCallback) != null) {
                function0.invoke();
            }
        }
    }

    private final void c(SysEmojiGroup sysEmojiGroup) {
        Iterator<SysEmoji> it = sysEmojiGroup.getSysEmojiList().iterator();
        while (it.hasNext()) {
            SysEmoji sysEmoji = it.next();
            try {
                EmojiPanelCategory emojiPanelCategory = EmojiPanelCategory.NORMAL_PANEL;
                String str = sysEmojiGroup.groupName;
                Intrinsics.checkNotNullExpressionValue(str, "sysEmojiGroup.groupName");
                Intrinsics.checkNotNullExpressionValue(sysEmoji, "sysEmoji");
                parseQQEmoConfigItem(j.a(emojiPanelCategory, str, sysEmoji));
            } catch (Throwable th5) {
                QLog.e("KernelQQEmojiResImpl", 2, "[parseConfigInner] error. stack=", th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public void addReloadDrawable(final int localId) {
        QQSysAndEmojiResInfo.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, localId);
            return;
        }
        super.addReloadDrawable(localId);
        if (!this.mEnableSingleDownloadFace) {
            return;
        }
        com.tencent.qqnt.kernel.api.i a16 = com.tencent.qqnt.msg.f.a();
        if (a16 == null) {
            QLog.d("KernelQQEmojiResImpl", 1, "[addReloadDrawable] reload localId " + localId + " error,  baseEmojiService is null!");
            return;
        }
        if (this.mSingleDownloadFaceLocalIds.size() < 10 && !this.mSingleDownloadFaceLocalIds.contains(Integer.valueOf(localId))) {
            int serverId = getServerId(localId);
            this.mSingleDownloadFaceLocalIds.add(Integer.valueOf(localId));
            String qSid = getQSid(localId);
            final DownloadBaseEmojiByIdReq downloadBaseEmojiByIdReq = new DownloadBaseEmojiByIdReq();
            downloadBaseEmojiByIdReq.emojiId = qSid;
            QQSysAndEmojiResInfo.QQEmoConfigItem configItem = getConfigItem(localId);
            if (configItem instanceof QQSysAndEmojiResInfo.a) {
                aVar = (QQSysAndEmojiResInfo.a) configItem;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                downloadBaseEmojiByIdReq.groupName = aVar.AniStickerPackName;
                downloadBaseEmojiByIdReq.panelCategory = aVar.f204651b;
            }
            String fullResPath = QQSysAndEmojiResMgr.getInstance().getFullResPath(3, serverId);
            Intrinsics.checkNotNullExpressionValue(fullResPath, "getInstance().getFullRes\u2026pi.RES_QQEMOJI, serverId)");
            QLog.d("KernelQQEmojiResImpl", 1, "[downloadBaseEmojiById] req=" + downloadBaseEmojiByIdReq + ", serverId=" + serverId + ", path=" + fullResPath + ", " + FileUtils.fileExists(fullResPath));
            a16.downloadBaseEmojiById(downloadBaseEmojiByIdReq, new IDownloadBaseEmojiByIdCallback() { // from class: com.tencent.mobileqq.emoticon.kernel.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IDownloadBaseEmojiByIdCallback
                public final void onResult(int i3, String str, SysEmoji sysEmoji, BaseEmojiPathInfo baseEmojiPathInfo) {
                    b.b(DownloadBaseEmojiByIdReq.this, this, localId, i3, str, sysEmoji, baseEmojiPathInfo);
                }
            });
        }
    }

    public final void d(boolean enableSingleDownloadFace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, enableSingleDownloadFace);
        } else {
            this.mEnableSingleDownloadFace = enableSingleDownloadFace;
        }
    }

    public final void e(@Nullable Function0<Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
        } else {
            this.mOnRefreshConfigCallback = callback;
        }
    }

    @Override // com.tencent.mobileqq.emoticon.QQEmojiResImpl, com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
    public void parseConfigData(@NotNull com.tencent.mobileqq.emoticon.a configData) {
        ArrayList<SysEmojiGroup> sysEmojiGroupList;
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
        if (cVar.a() == null) {
            return;
        }
        clearCacheData();
        long currentTimeMillis = System.currentTimeMillis();
        BasePanelResult a16 = cVar.a();
        if (a16 != null && (sysEmojiGroupList = a16.getSysEmojiGroupList()) != null) {
            Iterator<SysEmojiGroup> it = sysEmojiGroupList.iterator();
            while (it.hasNext()) {
                SysEmojiGroup sysEmojiGroup = it.next();
                if (!sysEmojiGroup.getSysEmojiList().isEmpty() && sysEmojiGroup.getSysEmojiList().get(0).emojiType == BaseEmojiType.EMOJI_EMOJI) {
                    Intrinsics.checkNotNullExpressionValue(sysEmojiGroup, "sysEmojiGroup");
                    c(sysEmojiGroup);
                }
            }
        }
        resDownloadFinish();
        if (QLog.isColorLevel()) {
            QLog.d("KernelQQEmojiResImpl", 2, "emoji configItem:", Integer.valueOf(this.mConfigItemMap.size()), " ,orderlist:", Integer.valueOf(this.mOrderList.size()), ", maxLid:", Integer.valueOf(this.mMaxLocalId), " ,costTime = [", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "]");
        }
    }
}
