package com.tencent.mobileqq.pymk;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001.\u0018\u0000 42\u00020\u0001:\u0001\u0017B\u0013\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u001e\u0010\f\u001a\u00020\u00022\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nJ(\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nJ\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00100\bj\b\u0012\u0004\u0012\u00020\u0010`\nJ\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u0018R\u0016\u0010&\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u0018R\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/pymk/c;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/pymk/api/a;", "listener", "l", "r", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "filterUins", "t", "", "isForce", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "addFriendSubId", "u", "", "a", "Ljava/lang/String;", "getCurrentPage", "()Ljava/lang/String;", "currentPage", "b", "Lcom/tencent/mobileqq/pymk/api/a;", "businessListener", "Ljava/util/concurrent/CopyOnWriteArrayList;", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mRecommendData", "d", "mETag", "e", "reqETag", "f", "Z", "mIsEnd", "Ljava/util/concurrent/atomic/AtomicBoolean;", "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasReported", "com/tencent/mobileqq/pymk/c$b", tl.h.F, "Lcom/tencent/mobileqq/pymk/c$b;", "recommendDataListener", "<init>", "(Ljava/lang/String;)V", "i", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String currentPage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.pymk.api.a businessListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<MayKnowRecommend> mRecommendData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mETag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String reqETag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsEnd;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean hasReported;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b recommendDataListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/pymk/c$a;", "", "", "EV_KL_PULL_UP", "Ljava/lang/String;", "PARAM_NOW_PAGE", "PG_KL_NEW_FRIEND", "PG_SEARCH_PEOPLE", "", "PRELOAD_ITEM_COUNT", "I", "TAG", "<init>", "()V", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.pymk.c$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/pymk/c$b", "Lcom/tencent/mobileqq/pymk/api/d;", "Lcom/tencent/mobileqq/pymk/api/c;", "data", "", "e", "", "uin", "c", "eTag", "b", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends com.tencent.mobileqq.pymk.api.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.pymk.api.d, com.tencent.mobileqq.pymk.api.a
        public void b(@Nullable String eTag) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) eTag);
            } else if (!TextUtils.isEmpty(eTag) && Intrinsics.areEqual(eTag, c.this.reqETag)) {
                c.this.reqETag = "";
            }
        }

        @Override // com.tencent.mobileqq.pymk.api.d, com.tencent.mobileqq.pymk.api.a
        public void c(@NotNull String uin) {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uin);
                return;
            }
            Intrinsics.checkNotNullParameter(uin, "uin");
            Iterator it = c.this.mRecommendData.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((MayKnowRecommend) obj).uin, uin)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MayKnowRecommend mayKnowRecommend = (MayKnowRecommend) obj;
            if (mayKnowRecommend == null) {
                return;
            }
            c.this.mRecommendData.remove(mayKnowRecommend);
            com.tencent.mobileqq.pymk.api.a aVar = c.this.businessListener;
            if (aVar != null) {
                aVar.c(uin);
            }
            com.tencent.mobileqq.pymk.api.a aVar2 = c.this.businessListener;
            if (aVar2 != null) {
                aVar2.d(c.this.mRecommendData, c.this.mIsEnd);
            }
            QLog.i("MayKnowFriendDataUtil", 1, "onGetPageData mRecommendDataSize " + c.this.mRecommendData.size() + " isEnd " + c.this.q());
        }

        @Override // com.tencent.mobileqq.pymk.api.d, com.tencent.mobileqq.pymk.api.a
        public void e(@NotNull com.tencent.mobileqq.pymk.api.c data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            if (!TextUtils.isEmpty(c.this.mETag) && Intrinsics.areEqual(c.this.mETag, data.a())) {
                QLog.i("MayKnowFriendDataUtil", 1, "onGetPageData mEtag is Same or not experimentGroup");
                return;
            }
            c.this.mRecommendData.addAll(data.b());
            c.this.mETag = data.a();
            c.this.mIsEnd = data.c();
            com.tencent.mobileqq.pymk.api.a aVar = c.this.businessListener;
            if (aVar != null) {
                aVar.d(c.this.mRecommendData, c.this.mIsEnd);
            }
            QLog.i("MayKnowFriendDataUtil", 1, "onGetPageData mRecommendDataSize " + c.this.mRecommendData.size() + " isEnd " + c.this.q() + " mETag " + c.this.mETag);
            c.this.m();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25346);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        if (((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).pymkTestSwitch() && q()) {
            List<MayKnowRecommend> localRecommendData = ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).getLocalRecommendData(4);
            Iterator<MayKnowRecommend> it = localRecommendData.iterator();
            String str = "";
            int i3 = 0;
            while (true) {
                boolean z16 = true;
                if (it.hasNext()) {
                    MayKnowRecommend next = it.next();
                    int size = this.mRecommendData.size();
                    int i16 = 0;
                    while (true) {
                        if (i16 < size) {
                            if (Intrinsics.areEqual(this.mRecommendData.get(i16).uin, next.uin)) {
                                str = str + "uin " + next.uin + " index " + i16 + " \n";
                                break;
                            }
                            i16++;
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (!z16) {
                        i3++;
                        str = str + "uin " + next.uin + " not show \n";
                    }
                } else {
                    QLog.e("MayKnowFriendDataUtil", 1, "total count " + this.mRecommendData.size() + " top2 count " + localRecommendData.size() + " \u4e2a \n " + str);
                    QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(QBaseActivity.sTopActivity, 230, "\u805a\u5408\u9875\u8bf7\u6c42\u5b8c\u6210", "\u805a\u5408\u9875\u6570\u636e " + this.mRecommendData.size() + "\u4e2a \n top2 \u6570\u636e " + localRecommendData.size() + " \u4e2a \n " + i3 + " \u4e2a\u4e0d\u5c55\u793a", "\u5173\u95ed", "\u5173\u95ed", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.pymk.a
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i17) {
                            c.n(dialogInterface, i17);
                        }
                    }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.pymk.b
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i17) {
                            c.o(dialogInterface, i17);
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026()\n                    })");
                    createCustomDialog.show();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    public final void l(@NotNull com.tencent.mobileqq.pymk.api.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.businessListener = listener;
        ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).addListener(this.recommendDataListener);
    }

    @NotNull
    public final ArrayList<MayKnowRecommend> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new ArrayList<>(this.mRecommendData);
    }

    public final boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.mIsEnd;
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.businessListener = null;
            ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).removeListener(this.recommendDataListener);
        }
    }

    public final void s(boolean isForce, @NotNull ArrayList<Long> filterUins) {
        com.tencent.mobileqq.pymk.api.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(isForce), filterUins);
            return;
        }
        Intrinsics.checkNotNullParameter(filterUins, "filterUins");
        com.tencent.mobileqq.pymk.api.c mayKnowDataSet = ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).getMayKnowDataSet();
        if ((!mayKnowDataSet.b().isEmpty()) && (aVar = this.businessListener) != null) {
            aVar.d(mayKnowDataSet.b(), mayKnowDataSet.c());
        }
        if (!this.mRecommendData.isEmpty()) {
            this.mRecommendData.clear();
            this.mETag = "";
            this.mIsEnd = true;
        }
        if (mayKnowDataSet.d() && !mayKnowDataSet.b().isEmpty() && !isForce) {
            this.mRecommendData.addAll(mayKnowDataSet.b());
            this.mETag = mayKnowDataSet.a();
            this.mIsEnd = mayKnowDataSet.c();
            return;
        }
        ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).fetchRecommendDataRemoteWithFilter(isForce, filterUins);
    }

    public final void t(@NotNull ArrayList<Long> filterUins) {
        Map mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) filterUins);
            return;
        }
        Intrinsics.checkNotNullParameter(filterUins, "filterUins");
        if (!q() && !TextUtils.isEmpty(this.mETag) && !Intrinsics.areEqual(this.reqETag, this.mETag)) {
            String str = this.currentPage;
            if (str == null) {
                str = "";
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("now_page", str));
            VideoReport.reportEvent("ev_kl_pull_up", mapOf);
            this.reqETag = this.mETag;
            ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).fetchRecommendWithFilterAETag(false, filterUins, this.mETag);
        }
    }

    public final void u(int addFriendSubId) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, addFriendSubId);
            return;
        }
        if (this.hasReported.compareAndSet(false, true)) {
            switch (addFriendSubId) {
                case 59:
                    str = "pg_kl_new_friends";
                    break;
                case 60:
                case 64:
                    str = "pg_kl_contact";
                    break;
                case 61:
                case 66:
                default:
                    str = "";
                    break;
                case 62:
                    str = "pg_search_people";
                    break;
                case 63:
                case 67:
                    str = "pg_search_people_middle";
                    break;
                case 65:
                    str = "pg_kl_pymk_more";
                    break;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("current_pageid", str);
            VideoReport.reportEvent("ev_bas_pymk_slide", hashMap);
            QLog.i("MayKnowFriendDataUtil", 1, "slideDTReport " + str);
        }
    }

    public c(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.currentPage = str;
        this.mRecommendData = new CopyOnWriteArrayList<>();
        this.mETag = "";
        this.reqETag = "";
        this.mIsEnd = true;
        this.hasReported = new AtomicBoolean(false);
        this.recommendDataListener = new b();
    }

    public /* synthetic */ c(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
