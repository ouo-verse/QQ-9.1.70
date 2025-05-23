package com.tencent.qqnt.graytips.decoder;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.graytips.util.h;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import com.tencent.qqnt.kernel.api.m;
import com.tencent.qqnt.kernelpublic.nativeinterface.BlockGrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/graytips/decoder/a;", "Lcom/tencent/qqnt/graytips/decoder/f;", "", "uid", "b", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/GrayTipElement;", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqnt/graytips/util/h$a;", "a", "<init>", "()V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/graytips/decoder/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.graytips.decoder.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30360);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String b(String uid) {
        try {
            long uinFromUid = ((IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class)).getUinFromUid(uid);
            if (uinFromUid == 0) {
                return "";
            }
            return String.valueOf(uinFromUid);
        } catch (Exception e16) {
            QLog.e("BlockGrayTipsDecoder", 1, "uid to uin " + e16);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0098  */
    @Override // com.tencent.qqnt.graytips.decoder.f
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h.a a(@NotNull GrayTipElement element) {
        String str;
        m b16;
        int i3;
        int i16;
        ArrayList<String> arrayListOf;
        ArrayList<String> arrayListOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        BlockGrayTipElement blockGrayTipElement = element.blockGrayTipElement;
        String str2 = "";
        String str3 = null;
        if (blockGrayTipElement != null) {
            Resources resources = BaseApplication.context.getResources();
            m b17 = com.tencent.qqnt.msg.f.b();
            if (b17 != null) {
                String peerUid = blockGrayTipElement.peerUid;
                Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
                arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(peerUid);
                Map<String, String> buddyRemark = b17.getBuddyRemark(arrayListOf2);
                if (buddyRemark != null) {
                    str = buddyRemark.get(blockGrayTipElement.peerUid);
                    b16 = com.tencent.qqnt.msg.f.b();
                    if (b16 != null) {
                        String peerUid2 = blockGrayTipElement.peerUid;
                        Intrinsics.checkNotNullExpressionValue(peerUid2, "peerUid");
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(peerUid2);
                        Map<String, String> buddyNick = b16.getBuddyNick(arrayListOf);
                        if (buddyNick != null) {
                            str3 = buddyNick.get(blockGrayTipElement.peerUid);
                        }
                    }
                    String peerUid3 = blockGrayTipElement.peerUid;
                    Intrinsics.checkNotNullExpressionValue(peerUid3, "peerUid");
                    String b18 = b(peerUid3);
                    if (TextUtils.isEmpty(str)) {
                        if (!TextUtils.isEmpty(str3)) {
                            str = str3;
                        } else if (TextUtils.isEmpty(b18)) {
                            str = "";
                        } else {
                            str = b18;
                        }
                    }
                    if (!blockGrayTipElement.isBuddy) {
                        i3 = R.string.f227536ra;
                    } else {
                        i3 = R.string.f227546rb;
                    }
                    String string = resources.getString(i3);
                    Intrinsics.checkNotNullExpressionValue(string, "if (isBuddy) resources.g\u2026ttings_conversation_temp)");
                    if (!TextUtils.isEmpty(str)) {
                        if (blockGrayTipElement.block) {
                            i16 = R.string.f227596rg;
                        } else {
                            i16 = R.string.f227566rd;
                        }
                    } else if (blockGrayTipElement.block) {
                        i16 = R.string.f227606rh;
                    } else {
                        i16 = R.string.f227576re;
                    }
                    str3 = resources.getString(i16, str, string);
                }
            }
            str = null;
            b16 = com.tencent.qqnt.msg.f.b();
            if (b16 != null) {
            }
            String peerUid32 = blockGrayTipElement.peerUid;
            Intrinsics.checkNotNullExpressionValue(peerUid32, "peerUid");
            String b182 = b(peerUid32);
            if (TextUtils.isEmpty(str)) {
            }
            if (!blockGrayTipElement.isBuddy) {
            }
            String string2 = resources.getString(i3);
            Intrinsics.checkNotNullExpressionValue(string2, "if (isBuddy) resources.g\u2026ttings_conversation_temp)");
            if (!TextUtils.isEmpty(str)) {
            }
            str3 = resources.getString(i16, str, string2);
        }
        if (str3 != null) {
            str2 = str3;
        }
        return new h.a(str2);
    }
}
