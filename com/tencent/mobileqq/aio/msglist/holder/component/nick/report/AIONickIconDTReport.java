package com.tencent.mobileqq.aio.msglist.holder.component.nick.report;

import com.tencent.mobileqq.aio.utils.a;
import com.tencent.mobileqq.aio.utils.b;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J.\u0010\u000b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003R\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000fR&\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/report/AIONickIconDTReport;", "", "", "", "b", "", "a", "msgId", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "bizId", "resId", "c", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lkotlin/Lazy;", "getMMkv", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mMkv", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "reportedIconList", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIONickIconDTReport {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIONickIconDTReport f191405a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mMkv;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ArrayList<Integer> reportedIconList;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48762);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f191405a = new AIONickIconDTReport();
        lazy = LazyKt__LazyJVMKt.lazy(AIONickIconDTReport$mMkv$2.INSTANCE);
        mMkv = lazy;
        reportedIconList = new ArrayList<>();
    }

    AIONickIconDTReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Map<String, Object> b() {
        Map<String, Object> emptyMap;
        a e16;
        Map<String, Object> a16;
        b.a g16 = b.f194119a.g();
        if (g16 == null || (e16 = g16.e()) == null || (a16 = e16.a()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        return a16;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            reportedIconList.clear();
        }
    }

    public final void c(@Nullable String msgId, @Nullable String senderUin, @Nullable String bizId, @Nullable String resId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, msgId, senderUin, bizId, resId);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dt_pgid", "pg_aio");
        linkedHashMap.put("eid", "em_bas_message_bubble_icon");
        if (msgId == null) {
            msgId = "";
        }
        linkedHashMap.put("group_msg_id", msgId);
        if (senderUin == null) {
            senderUin = "";
        }
        linkedHashMap.put("to_uin", senderUin);
        if (bizId == null) {
            bizId = "";
        }
        linkedHashMap.put(QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, bizId);
        if (resId == null) {
            resId = "";
        }
        linkedHashMap.put(IPreloadServiceProxy.KEY_RESID, resId);
        linkedHashMap.put("cur_pg", b());
        VideoReport.reportEvent("clck", linkedHashMap);
    }
}
