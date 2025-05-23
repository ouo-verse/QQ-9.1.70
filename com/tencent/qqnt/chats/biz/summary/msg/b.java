package com.tencent.qqnt.chats.biz.summary.msg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi;
import com.tencent.qqnt.aio.utils.ac;
import com.tencent.qqnt.chats.api.IChatsConfigRuntimeService;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.graytips.util.f;
import com.tencent.qqnt.kernel.nativeinterface.MsgStatus;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtAttr;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b2\u00103J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J:\u0010\u0011\u001a\u00020\b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\u0017\u001a\u00020\u00162\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014H\u0002JB\u0010\u001b\u001a\u00020\u001a2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u000eH\u0002J\b\u0010!\u001a\u00020\bH\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020\u000eH\u0002J\u0010\u0010)\u001a\u00020'2\u0006\u0010&\u001a\u00020\u000eH\u0002J\u0010\u0010*\u001a\u00020'2\u0006\u0010&\u001a\u00020\u000eH\u0002J\u0010\u0010+\u001a\u00020'2\u0006\u0010&\u001a\u00020\u000eH\u0002J \u0010-\u001a\u00020'2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010/\u001a\u00020.2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u00100\u001a\u00020.2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u00101\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/chats/biz/summary/msg/b;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime;", "appRuntime", "", h.F, "g", "", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstractElement;", "elementList", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "Landroid/os/Bundle;", "extra", "e", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactExtAttr;", "Lkotlin/collections/ArrayList;", "extraAttrs", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/text/SpannableStringBuilder;", "content", "", "r", "elem", "o", "", DomainData.DOMAIN_NAME, "p", "c", "Landroid/content/res/Resources;", "res", "Landroid/graphics/drawable/Drawable;", "f", "info", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "i", "d", "picSubType", "k", "Lcom/tencent/qqnt/chats/biz/summary/msg/a;", "a", "b", "l", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f354415a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44259);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f354415a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final CharSequence c() {
        ImageSpan imageSpan;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "[Emotion]");
        Resources res = MobileQQ.sMobileQQ.getResources();
        Intrinsics.checkNotNullExpressionValue(res, "res");
        Drawable f16 = f(res);
        if (f16 != null) {
            imageSpan = a.a(res, f16);
        } else {
            imageSpan = null;
        }
        if (imageSpan == null) {
            return "";
        }
        spannableStringBuilder.setSpan(imageSpan, 0, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    private final String d(RecentContactInfo info) {
        Integer num = info.anonymousFlag;
        if ((num == null || num.intValue() != 2) && info.senderUin != 80000000 && !Intrinsics.areEqual(info.senderUid, "u_FtTkoC59JbqBWMNacX6mgw")) {
            return MobileQQ.sMobileQQ.getResources().getString(R.string.f179833_f) + info.sendNickName;
        }
        String string = MobileQQ.sMobileQQ.getResources().getString(R.string.f179833_f);
        Intrinsics.checkNotNullExpressionValue(string, "{\n            MobileQQ.s\u2026_anonymous_tag)\n        }");
        return string;
    }

    private final CharSequence e(List<MsgAbstractElement> elementList, RecentContactInfo item, Bundle extra, Context context, AppRuntime appRuntime) {
        boolean z16;
        Object obj;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (item.chatType == 131) {
            List<MsgAbstractElement> list = elementList;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                Iterator<T> it = elementList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (!f354415a.o((MsgAbstractElement) obj)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                MsgAbstractElement msgAbstractElement = (MsgAbstractElement) obj;
                if (msgAbstractElement != null) {
                    spannableStringBuilder.append((CharSequence) msgAbstractElement.content);
                }
            }
            return spannableStringBuilder;
        }
        r(elementList, spannableStringBuilder, extra, item, context, appRuntime);
        return spannableStringBuilder;
    }

    private final Drawable f(Resources res) {
        try {
            Drawable drawable = res.getDrawable(R.drawable.c0q);
            if (drawable == null) {
                return null;
            }
            int i3 = (int) (16 * res.getDisplayMetrics().scaledDensity);
            drawable.setBounds(0, 0, i3, i3);
            return drawable;
        } catch (Exception e16) {
            QLog.i("MsgSummary", 1, e16.toString());
            return null;
        }
    }

    private final CharSequence g(g item, Context context, AppRuntime appRuntime) {
        return e(item.s().draft, item.s(), item.q(), context, appRuntime);
    }

    private final CharSequence h(g item, Context context, AppRuntime appRuntime) {
        return e(item.s().abstractContent, item.s(), item.q(), context, appRuntime);
    }

    private final String i(RecentContactInfo info) {
        if (!TextUtils.isEmpty(info.sendRemarkName)) {
            String str = info.sendRemarkName;
            Intrinsics.checkNotNullExpressionValue(str, "info.sendRemarkName");
            return str;
        }
        if (!TextUtils.isEmpty(info.sendMemberName)) {
            String str2 = info.sendMemberName;
            Intrinsics.checkNotNullExpressionValue(str2, "info.sendMemberName");
            return str2;
        }
        if (!TextUtils.isEmpty(info.sendNickName)) {
            String str3 = info.sendNickName;
            Intrinsics.checkNotNullExpressionValue(str3, "info.sendNickName");
            return str3;
        }
        long j3 = info.senderUin;
        if (j3 == 0) {
            return "";
        }
        return String.valueOf(j3);
    }

    private final String j(RecentContactInfo info) {
        if (!TextUtils.isEmpty(info.sendMemberName)) {
            String str = info.sendMemberName;
            Intrinsics.checkNotNullExpressionValue(str, "info.sendMemberName");
            return str;
        }
        if (!TextUtils.isEmpty(info.sendRemarkName)) {
            String str2 = info.sendRemarkName;
            Intrinsics.checkNotNullExpressionValue(str2, "info.sendRemarkName");
            return str2;
        }
        if (!TextUtils.isEmpty(info.sendNickName)) {
            String str3 = info.sendNickName;
            Intrinsics.checkNotNullExpressionValue(str3, "info.sendNickName");
            return str3;
        }
        long j3 = info.senderUin;
        if (j3 == 0) {
            return "";
        }
        return String.valueOf(j3);
    }

    private final String k(int picSubType, String content, Context context) {
        if (MsgExtKt.v(picSubType)) {
            if ((picSubType == 1 || picSubType == 4 || picSubType == 7) && !TextUtils.isEmpty(content)) {
                return content;
            }
            String string = context.getString(R.string.f168442fn);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.msg_summary_emo_pic)");
            return string;
        }
        return content;
    }

    private final String m(RecentContactInfo info) {
        Integer num = info.anonymousFlag;
        if (num != null && num.intValue() == 0 && info.senderUin != 80000000 && !Intrinsics.areEqual(info.senderUid, "u_FtTkoC59JbqBWMNacX6mgw")) {
            if (((IChatsConfigRuntimeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IChatsConfigRuntimeService.class, "")).nickUseNTOrder()) {
                return i(info);
            }
            return j(info);
        }
        return d(info);
    }

    private final int n(g item) {
        int i3 = item.s().sendStatus;
        if (i3 != 0) {
            if (i3 == 1) {
                return 1;
            }
            return 0;
        }
        return 2;
    }

    private final boolean o(MsgAbstractElement elem) {
        int i3 = elem.elementType;
        if (i3 != 43 && i3 != 44) {
            return false;
        }
        return true;
    }

    private final boolean p(RecentContactInfo item) {
        ArrayList<MsgAbstractElement> arrayList = item.abstractContent;
        Intrinsics.checkNotNullExpressionValue(arrayList, "item.abstractContent");
        Iterator<T> it = arrayList.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (((MsgAbstractElement) it.next()).elementType == 8) {
                z16 = true;
            }
        }
        return z16;
    }

    private final boolean q(ArrayList<RecentContactExtAttr> extraAttrs) {
        boolean z16;
        if (extraAttrs != null) {
            Iterator<T> it = extraAttrs.iterator();
            while (it.hasNext()) {
                MsgStatus msgStatus = ((RecentContactExtAttr) it.next()).msgStatus;
                if (msgStatus != null && msgStatus.getMsgPushStatus() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r24v0, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r5v16, types: [int] */
    private final void r(List<MsgAbstractElement> elementList, SpannableStringBuilder content, Bundle extra, RecentContactInfo item, Context context, AppRuntime appRuntime) {
        Iterator it;
        boolean z16;
        boolean z17;
        if (q(item.extAttrs)) {
            content.append(context.getString(R.string.f197884l8));
            return;
        }
        IMarkdownFeatureCompatApi iMarkdownFeatureCompatApi = (IMarkdownFeatureCompatApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownFeatureCompatApi.class);
        String str = item.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "item.peerUid");
        String tryParseForChats = iMarkdownFeatureCompatApi.tryParseForChats(context, str, elementList);
        boolean z18 = false;
        if (tryParseForChats != null) {
            if (tryParseForChats.length() > 100) {
                tryParseForChats = tryParseForChats.substring(0, 100);
                Intrinsics.checkNotNullExpressionValue(tryParseForChats, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            content.append(tryParseForChats);
            return;
        }
        if (elementList != null) {
            Iterator it5 = elementList.iterator();
            while (it5.hasNext()) {
                MsgAbstractElement msgAbstractElement = (MsgAbstractElement) it5.next();
                b bVar = f354415a;
                if (!bVar.o(msgAbstractElement)) {
                    int i3 = msgAbstractElement.elementType;
                    boolean z19 = true;
                    if (i3 == 6 && msgAbstractElement.index != null) {
                        Integer num = msgAbstractElement.elementSubType;
                        if (num != null && num.intValue() == 5) {
                            content.append(msgAbstractElement.content);
                        } else {
                            if (extra == null || !extra.getBoolean("is_first_data", z18)) {
                                z19 = z18;
                            }
                            if (z19) {
                                content.append(bVar.c());
                            } else {
                                IEmojiSpanService iEmojiSpanService = (IEmojiSpanService) QRoute.api(IEmojiSpanService.class);
                                Integer num2 = msgAbstractElement.elementSubType;
                                Intrinsics.checkNotNullExpressionValue(num2, "it.elementSubType");
                                int intValue = num2.intValue();
                                Integer num3 = msgAbstractElement.index;
                                Intrinsics.checkNotNullExpressionValue(num3, "it.index");
                                content.append(iEmojiSpanService.createEmojiSpanText(intValue, num3.intValue(), 0, true, 16)).toString();
                            }
                        }
                    } else {
                        if (i3 == 8) {
                            Integer anonymousFlag = item.anonymousFlag;
                            if (anonymousFlag != null) {
                                Intrinsics.checkNotNullExpressionValue(anonymousFlag, "anonymousFlag");
                                anonymousFlag.intValue();
                                Integer num4 = item.anonymousFlag;
                                Intrinsics.checkNotNullExpressionValue(num4, "item.anonymousFlag");
                                z17 = num4.intValue();
                            } else {
                                z17 = z18;
                            }
                            it = it5;
                            z16 = z18;
                            CharSequence d16 = f.d(context, appRuntime, msgAbstractElement, msgAbstractElement.grayTiPElement, item.peerUid, item.senderUid, bVar.m(item), item.chatType, 8, z17 ? 1 : 0);
                            if (!TextUtils.isEmpty(d16)) {
                                content.append(d16);
                            }
                        } else {
                            it = it5;
                            z16 = z18;
                            if (i3 == 21) {
                                com.tencent.qqnt.aio.videochat.a aVar = com.tencent.qqnt.aio.videochat.a.f352344a;
                                Integer num5 = msgAbstractElement.elementSubType;
                                Intrinsics.checkNotNullExpressionValue(num5, "it.elementSubType");
                                int intValue2 = num5.intValue();
                                String str2 = msgAbstractElement.content;
                                Intrinsics.checkNotNullExpressionValue(str2, "it.content");
                                CharSequence a16 = aVar.a(context, appRuntime, intValue2, str2);
                                if (!TextUtils.isEmpty(a16)) {
                                    content.append(a16);
                                }
                            } else if (i3 == 3) {
                                content.append(msgAbstractElement.content).append((CharSequence) msgAbstractElement.fileName);
                            } else if (i3 == 23) {
                                content.append(context.getString(R.string.f168452fo)).append((CharSequence) msgAbstractElement.fileName);
                            } else if (i3 == 2) {
                                Integer num6 = msgAbstractElement.elementSubType;
                                Intrinsics.checkNotNullExpressionValue(num6, "it.elementSubType");
                                int intValue3 = num6.intValue();
                                String str3 = msgAbstractElement.content;
                                Intrinsics.checkNotNullExpressionValue(str3, "it.content");
                                content.append(bVar.k(intValue3, str3, context));
                            } else if (i3 == 1) {
                                if (QQSysFaceSwitcher.f204652a.q()) {
                                    content.append(ac.a(msgAbstractElement.content, z16, null));
                                } else {
                                    content.append(msgAbstractElement.content);
                                }
                            } else {
                                content.append(msgAbstractElement.content);
                            }
                        }
                        z18 = z16;
                        it5 = it;
                    }
                }
                it = it5;
                z16 = z18;
                z18 = z16;
                it5 = it;
            }
        }
    }

    @NotNull
    public final a a(@NotNull g item, @NotNull Context context, @NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, this, item, context, appRuntime);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        a aVar = new a();
        aVar.f354407a = l(item.s(), appRuntime);
        aVar.f354410d = h(item, context, appRuntime);
        aVar.f354411e = "";
        aVar.f354408b = n(item);
        aVar.f354412f = item.F();
        if (item.F()) {
            aVar.f354413g = g(item, context, appRuntime);
        }
        return aVar;
    }

    @NotNull
    public final a b(@NotNull RecentContactInfo item, @NotNull Context context, @NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, this, item, context, appRuntime);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        a aVar = new a();
        aVar.f354410d = e(item.abstractContent, item, null, context, appRuntime);
        aVar.f354407a = l(item, appRuntime);
        boolean z16 = true;
        if (item.draftFlag != 1) {
            z16 = false;
        }
        aVar.f354412f = z16;
        if (z16) {
            aVar.f354413g = e(item.draft, item, null, context, appRuntime);
        }
        return aVar;
    }

    @NotNull
    public final String l(@NotNull RecentContactInfo item, @NotNull AppRuntime appRuntime) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) item, (Object) appRuntime);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        int i3 = item.chatType;
        if (i3 != 2) {
            if (i3 != 7) {
                if (i3 != 30) {
                    if (i3 != 116) {
                        if (i3 == 131) {
                            if (!TextUtils.isEmpty(item.peerName)) {
                                String str = item.peerName;
                                Intrinsics.checkNotNullExpressionValue(str, "item.peerName");
                                return str;
                            }
                            long j3 = item.peerUin;
                            if (j3 != 0) {
                                return String.valueOf(j3);
                            }
                        }
                        return "";
                    }
                    if (Intrinsics.areEqual(item.senderUid, appRuntime.getCurrentUid()) || TextUtils.isEmpty(item.sendNickName)) {
                        return "";
                    }
                    String str2 = item.sendNickName;
                    Intrinsics.checkNotNullExpressionValue(str2, "item.sendNickName");
                    return str2;
                }
                if (TextUtils.isEmpty(item.sendNickName)) {
                    return "";
                }
                String str3 = item.sendNickName;
                Intrinsics.checkNotNullExpressionValue(str3, "item.sendNickName");
                return str3;
            }
            if (Intrinsics.areEqual(item.senderUid, appRuntime.getCurrentUid()) || p(item)) {
                return "";
            }
            String str4 = item.remark;
            if (str4 != null && str4.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                String str5 = item.peerName;
                if (str5 == null) {
                    return "";
                }
                return str5;
            }
            String str6 = item.remark;
            Intrinsics.checkNotNullExpressionValue(str6, "{\n                    it\u2026.remark\n                }");
            return str6;
        }
        if (Intrinsics.areEqual(item.senderUid, appRuntime.getCurrentUid()) || p(item)) {
            return "";
        }
        Integer num = item.anonymousFlag;
        if (num == null || num.intValue() != 0) {
            d(item);
        }
        return m(item);
    }
}
