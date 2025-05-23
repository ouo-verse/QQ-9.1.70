package com.tencent.mobileqq.aio.utils;

import android.os.Bundle;
import android.os.SystemClock;
import az2.c;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.AniStickerMsgItem;
import com.tencent.mobileqq.aio.msg.o;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.adapter.api.IReportControllerApi;
import com.tencent.qqnt.aio.adapter.api.ITextPreviewApi;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0002J4\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006R\"\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/av;", "", "Lcom/tencent/mobileqq/aio/msg/AniStickerMsgItem;", "msgItem", "", "a", "Lcom/tencent/mobileqq/aio/msg/u;", "d", "Lcom/tencent/mobileqq/aio/msg/o;", "b", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "isFormSingleClick", "previewText", "", "realMsgId", "", "f", "c", "e", "J", "getLastClickTextPreviewTimeMillis", "()J", "setLastClickTextPreviewTimeMillis", "(J)V", "lastClickTextPreviewTimeMillis", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class av {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final av f194117a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long lastClickTextPreviewTimeMillis;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65303);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f194117a = new av();
        }
    }

    av() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a(AniStickerMsgItem msgItem) {
        String faceString = QQSysFaceUtil.getFaceString(msgItem.n2());
        Intrinsics.checkNotNullExpressionValue(faceString, "getFaceString(msgItem.localId)");
        return faceString;
    }

    private final String b(com.tencent.mobileqq.aio.msg.o msgItem) {
        StringBuilder sb5 = new StringBuilder();
        int size = msgItem.o2().size();
        for (int i3 = 0; i3 < size; i3++) {
            o.b bVar = msgItem.o2().get(i3);
            if (bVar.b() != null) {
                sb5.append(BaseApplication.context.getString(R.string.ytm));
            } else if (bVar.c() != null) {
                sb5.append(IQQTextApi.a.c((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class), com.tencent.mobileqq.aio.msglist.holder.component.text.c.f191997a.a(bVar.c()).toString(), 13, com.tencent.qqnt.emotion.constant.b.b(), null, null, 24, null));
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "mixText.toString()");
        return sb6;
    }

    private final String d(com.tencent.mobileqq.aio.msg.u msgItem) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        msgItem.C2().i();
        MsgRecord D2 = msgItem.D2();
        if (D2 != null) {
            str = D2.sendMemberName;
        } else {
            str = null;
        }
        if (str != null) {
            str.length();
        }
        sb5.append(b(msgItem));
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "previewText.toString()");
        return sb6;
    }

    public static /* synthetic */ void g(av avVar, com.tencent.aio.api.runtime.a aVar, AIOMsgItem aIOMsgItem, boolean z16, String str, long j3, int i3, Object obj) {
        long j16;
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i3 & 8) != 0) {
            str = avVar.c(aIOMsgItem);
        }
        String str2 = str;
        if ((i3 & 16) != 0) {
            MsgRecord msgRecord = aIOMsgItem.getMsgRecord();
            if (msgRecord != null) {
                j16 = msgRecord.msgId;
            } else {
                j16 = -1;
            }
            j3 = j16;
        }
        avVar.f(aVar, aIOMsgItem, z17, str2, j3);
    }

    @NotNull
    public final String c(@NotNull AIOMsgItem msgItem) {
        String obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof com.tencent.mobileqq.aio.msg.ae) {
            CharSequence u26 = ((com.tencent.mobileqq.aio.msg.ae) msgItem).u2();
            if (u26 == null || (obj = u26.toString()) == null) {
                return "";
            }
            return obj;
        }
        if (msgItem instanceof AniStickerMsgItem) {
            return a((AniStickerMsgItem) msgItem);
        }
        if (msgItem instanceof com.tencent.mobileqq.aio.msg.u) {
            return d((com.tencent.mobileqq.aio.msg.u) msgItem);
        }
        if (!(msgItem instanceof com.tencent.mobileqq.aio.msg.o)) {
            return "";
        }
        return b((com.tencent.mobileqq.aio.msg.o) msgItem);
    }

    @NotNull
    public final String e(@NotNull com.tencent.mobileqq.aio.msg.u msgItem) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        StringBuilder sb5 = new StringBuilder();
        CharSequence E2 = msgItem.E2();
        CharSequence z26 = msgItem.z2();
        if (msgItem.M0()) {
            sb5.append(BaseApplication.context.getString(R.string.f221126_z));
        } else {
            boolean z17 = true;
            if (E2.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                sb5.append(E2);
            }
            MsgElement d16 = msgItem.C2().d();
            if (d16 != null) {
                int i3 = d16.elementType;
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 != 14) {
                                    Unit unit = Unit.INSTANCE;
                                } else {
                                    sb5.append(d16.markdownElement.mdSummary);
                                }
                            } else {
                                sb5.append(BaseApplication.context.getString(R.string.ytp));
                            }
                        } else {
                            sb5.append(BaseApplication.context.getString(R.string.ytn));
                        }
                    } else {
                        String string = BaseApplication.context.getString(R.string.ytk);
                        FileElement fileElement = d16.fileElement;
                        if (fileElement != null) {
                            str = fileElement.fileName;
                        } else {
                            str = null;
                        }
                        sb5.append(string + str);
                    }
                } else {
                    sb5.append(BaseApplication.context.getString(R.string.ytm));
                }
            }
            if (z26.length() <= 0) {
                z17 = false;
            }
            if (z17) {
                sb5.append(z26);
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "previewText.toString()");
        return sb6;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull AIOMsgItem msgItem, boolean isFormSingleClick, @NotNull String previewText, long realMsgId) {
        boolean z16;
        boolean z17;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, aioContext, msgItem, Boolean.valueOf(isFormSingleClick), previewText, Long.valueOf(realMsgId));
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(previewText, "previewText");
        c.a a16 = az2.a.f27386a.a(ABTestController.APPID_1505, "exp_f_club_qq_chat_aiorec_click_exp_new_1");
        if (Intrinsics.areEqual(a16.getMExpGrayId(), "")) {
            QLog.e("TextPreviewUtil", 1, " expEntityInfo.mExpGrayId == null appId = 1505 expName = exp_f_club_qq_chat_aiorec_click_exp_new");
        } else if (Intrinsics.areEqual(a16.b().get("flag"), "1")) {
            z16 = true;
            if (!isFormSingleClick && !z16) {
                return;
            }
            if (aioContext.g().r().c().e() != 3) {
                QLog.i("TextPreviewUtil", 1, "openTextPreview discussion chat return");
                return;
            }
            if (previewText.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                QLog.i("TextPreviewUtil", 1, "openTextPreview text is empty");
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            if (Math.abs(uptimeMillis - lastClickTextPreviewTimeMillis) < 500) {
                QLog.i("TextPreviewUtil", 1, "openTextPreview too quick");
                return;
            }
            lastClickTextPreviewTimeMillis = uptimeMillis;
            com.tencent.mvi.base.route.j e16 = aioContext.e();
            e16.h(new ExternalCommIntent("code_hide_external_panel", new Bundle()));
            e16.h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("AIOBubbleMsgItemVM", false, 2, null));
            a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
            ((ITextPreviewApi) companion.a(ITextPreviewApi.class)).openTextPreview(aioContext, previewText, msgItem, realMsgId);
            IReportControllerApi iReportControllerApi = (IReportControllerApi) companion.a(IReportControllerApi.class);
            if (isFormSingleClick) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            iReportControllerApi.reportWith898(null, "", "", "0X800C531", "0X800C531", i3, 0, "", "", a16.getMExpGrayId(), "");
            return;
        }
        z16 = false;
        if (!isFormSingleClick) {
        }
        if (aioContext.g().r().c().e() != 3) {
        }
    }
}
