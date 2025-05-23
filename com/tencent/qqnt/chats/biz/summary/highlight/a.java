package com.tencent.qqnt.chats.biz.summary.highlight;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.nativeinterface.MsgBoxNecessaryMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.SpecificEventTypeInfoInMsgBox;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/biz/summary/highlight/a;", "Lcom/tencent/qqnt/chats/biz/summary/highlight/core/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/qqnt/chats/biz/summary/highlight/core/b;", "a", "", "b", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends com.tencent.qqnt.chats.biz.summary.highlight.core.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/chats/biz/summary/highlight/a$a;", "", "", "curEventType", "", "b", "", "unreadCnt", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SpecificEventTypeInfoInMsgBox;", LinkReportConstant$GlobalKey.EVENTS, "Lcom/tencent/qqnt/chats/biz/summary/highlight/core/b;", "a", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.summary.highlight.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final boolean b(int curEventType) {
            if (curEventType != 1009 && curEventType != 1008) {
                return true;
            }
            return false;
        }

        @Nullable
        public final com.tencent.qqnt.chats.biz.summary.highlight.core.b a(long unreadCnt, @Nullable List<SpecificEventTypeInfoInMsgBox> events) {
            int i3;
            boolean z16;
            Object last;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            boolean z18 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.qqnt.chats.biz.summary.highlight.core.b) iPatchRedirector.redirect((short) 2, this, Long.valueOf(unreadCnt), events);
            }
            String str = "";
            if (events != null) {
                i3 = -1;
                long j3 = -1;
                for (SpecificEventTypeInfoInMsgBox specificEventTypeInfoInMsgBox : events) {
                    ArrayList<MsgBoxNecessaryMsgInfo> arrayList = specificEventTypeInfoInMsgBox.msgInfos;
                    if (arrayList != null && !arrayList.isEmpty()) {
                        z16 = z18;
                    } else {
                        z16 = z17;
                    }
                    if (!z16) {
                        ArrayList<MsgBoxNecessaryMsgInfo> arrayList2 = specificEventTypeInfoInMsgBox.msgInfos;
                        Intrinsics.checkNotNullExpressionValue(arrayList2, "it.msgInfos");
                        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList2);
                        MsgBoxNecessaryMsgInfo msgBoxNecessaryMsgInfo = (MsgBoxNecessaryMsgInfo) last;
                        if (AtTypeHelper.f354392a.h(msgBoxNecessaryMsgInfo.msgSeq, specificEventTypeInfoInMsgBox.eventTypeInMsgBox, j3, i3)) {
                            j3 = msgBoxNecessaryMsgInfo.msgSeq;
                            i3 = specificEventTypeInfoInMsgBox.eventTypeInMsgBox;
                            str = msgBoxNecessaryMsgInfo.highlightDigest;
                            Intrinsics.checkNotNullExpressionValue(str, "info.highlightDigest");
                        }
                    }
                    z17 = true;
                    z18 = false;
                }
            } else {
                i3 = -1;
            }
            if (i3 <= -1) {
                return null;
            }
            if (unreadCnt <= 0 && b(i3)) {
                return null;
            }
            com.tencent.qqnt.chats.biz.summary.highlight.core.b bVar = new com.tencent.qqnt.chats.biz.summary.highlight.core.b();
            if (TextUtils.isEmpty(str)) {
                str = AtTypeHelper.f354392a.b(i3);
            }
            bVar.e(str);
            return bVar;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44231);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
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

    @Override // com.tencent.qqnt.chats.biz.summary.highlight.core.a
    @Nullable
    public com.tencent.qqnt.chats.biz.summary.highlight.core.b a(@NotNull g item, @NotNull Context context, @NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chats.biz.summary.highlight.core.b) iPatchRedirector.redirect((short) 2, this, item, context, appRuntime);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        return INSTANCE.a(item.s().unreadCnt, item.s().listOfSpecificEventTypeInfosInMsgBox);
    }

    @Override // com.tencent.qqnt.chats.biz.summary.highlight.core.a
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
