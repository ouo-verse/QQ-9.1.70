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
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ*\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002JH\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\fH\u0002J \u0010\u0015\u001a\u0004\u0018\u00010\t2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002J\"\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/chats/biz/summary/highlight/b;", "Lcom/tencent/qqnt/chats/biz/summary/highlight/core/a;", "", "unreadCnt", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SpecificEventTypeInfoInMsgBox;", LinkReportConstant$GlobalKey.EVENTS, "", "position", "", "c", "Lkotlin/Pair;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgBoxNecessaryMsgInfo;", "curEventInfo", "newEventInfo", "e", "curInfo", "newInfo", "", "d", "eventInfo", "f", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/qqnt/chats/biz/summary/highlight/core/b;", "a", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends com.tencent.qqnt.chats.biz.summary.highlight.core.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chats/biz/summary/highlight/b$a;", "", "", "HIGHLIGHT_POS1", "I", "HIGHLIGHT_POS2", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.summary.highlight.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44250);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String c(long unreadCnt, List<SpecificEventTypeInfoInMsgBox> events, int position) {
        Pair<Integer, MsgBoxNecessaryMsgInfo> pair;
        boolean z16;
        Object last;
        Pair<Integer, MsgBoxNecessaryMsgInfo> pair2 = null;
        if (events != null) {
            pair = null;
            for (SpecificEventTypeInfoInMsgBox specificEventTypeInfoInMsgBox : events) {
                ArrayList<MsgBoxNecessaryMsgInfo> arrayList = specificEventTypeInfoInMsgBox.msgInfos;
                if (arrayList != null && !arrayList.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    ArrayList<MsgBoxNecessaryMsgInfo> arrayList2 = specificEventTypeInfoInMsgBox.msgInfos;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "it.msgInfos");
                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList2);
                    pair = e(pair, new Pair<>(Integer.valueOf(specificEventTypeInfoInMsgBox.eventTypeInMsgBox), (MsgBoxNecessaryMsgInfo) last), position);
                }
            }
        } else {
            pair = null;
        }
        if (pair == null || unreadCnt > 0) {
            pair2 = pair;
        }
        return f(pair2);
    }

    private final boolean d(MsgBoxNecessaryMsgInfo curInfo, MsgBoxNecessaryMsgInfo newInfo) {
        if (curInfo == null) {
            return true;
        }
        long j3 = curInfo.msgSeq;
        long j16 = newInfo.msgSeq;
        if (j3 < j16 || (j3 == j16 && curInfo.msgTime < newInfo.msgTime)) {
            return true;
        }
        return false;
    }

    private final Pair<Integer, MsgBoxNecessaryMsgInfo> e(Pair<Integer, MsgBoxNecessaryMsgInfo> curEventInfo, Pair<Integer, MsgBoxNecessaryMsgInfo> newEventInfo, int position) {
        MsgBoxNecessaryMsgInfo msgBoxNecessaryMsgInfo;
        if (AtTypeHelper.f354392a.g(newEventInfo.getFirst().intValue())) {
            if (curEventInfo != null) {
                msgBoxNecessaryMsgInfo = curEventInfo.getSecond();
            } else {
                msgBoxNecessaryMsgInfo = null;
            }
            if (d(msgBoxNecessaryMsgInfo, newEventInfo.getSecond())) {
                return newEventInfo;
            }
        }
        return curEventInfo;
    }

    private final String f(Pair<Integer, MsgBoxNecessaryMsgInfo> eventInfo) {
        if (eventInfo != null) {
            if (TextUtils.isEmpty(eventInfo.getSecond().highlightDigest)) {
                return AtTypeHelper.f354392a.b(eventInfo.getFirst().intValue());
            }
            return eventInfo.getSecond().highlightDigest;
        }
        return null;
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
        if (item.n() == 2) {
            String c16 = c(item.s().unreadCnt, item.s().listOfSpecificEventTypeInfosInMsgBox, 1);
            if (c16 == null) {
                c16 = "";
            }
            if (!TextUtils.isEmpty(c16)) {
                com.tencent.qqnt.chats.biz.summary.highlight.core.b bVar = new com.tencent.qqnt.chats.biz.summary.highlight.core.b();
                bVar.e(c16);
                return bVar;
            }
            return null;
        }
        return null;
    }
}
