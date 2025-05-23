package com.tencent.biz.pubaccount.weishi.comment;

import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.ao;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.comment.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static class C0820a extends b {
        C0820a(WsCommentPresenter wsCommentPresenter) {
            super(wsCommentPresenter);
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.l
        public void a(Object obj, int i3) {
            stSimpleMetaPerson stsimplemetaperson = (stSimpleMetaPerson) obj;
            c(stsimplemetaperson, stsimplemetaperson.avatarSchema, 2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    static abstract class b implements l {

        /* renamed from: a, reason: collision with root package name */
        WsCommentPresenter f80560a;

        b(WsCommentPresenter wsCommentPresenter) {
            this.f80560a = wsCommentPresenter;
        }

        private void d(int i3, int i16) {
            Map<String, String> P = this.f80560a.P();
            P.put("click_status", String.valueOf(i16));
            f(1000001, i3, P);
        }

        private void f(int i3, int i16, Map<String, String> map) {
            com.tencent.biz.pubaccount.weishi.report.b.n(this.f80560a.R(), this.f80560a.L(), this.f80560a.N(), i3, i16, this.f80560a.G(), this.f80560a.K(), map);
        }

        protected WSDownloadParams b(String str, int i3) {
            WSDownloadParams wSDownloadParams = new WSDownloadParams();
            wSDownloadParams.mScene = 1;
            wSDownloadParams.mLinkStrategyType = iz.a.g().p();
            wSDownloadParams.mEventId = i3;
            wSDownloadParams.mTestId = bb.x(1);
            wSDownloadParams.mStReportItem = com.tencent.biz.pubaccount.weishi.report.a.g();
            wSDownloadParams.mScheme = str;
            return wSDownloadParams;
        }

        protected void c(stSimpleMetaPerson stsimplemetaperson, stSchema stschema, int i3) {
            String str;
            BaseFragment J = this.f80560a.J();
            QBaseActivity qBaseActivity = J.getQBaseActivity();
            if (J instanceof WSVerticalPageFragment) {
                WSVerticalPageFragment wSVerticalPageFragment = (WSVerticalPageFragment) J;
                String from = wSVerticalPageFragment.getFrom();
                if (TextUtils.equals(from, "personal_guest") || TextUtils.equals(from, "personal_main")) {
                    if (wSVerticalPageFragment.getArguments() != null) {
                        str = wSVerticalPageFragment.getArguments().getString("person_id");
                    } else {
                        str = "";
                    }
                    if (TextUtils.equals(stsimplemetaperson.f25130id, str)) {
                        this.f80560a.d0();
                        qBaseActivity.doOnBackPressed();
                        d(i3, 2);
                        return;
                    }
                }
            }
            WSProfileFragment.qi(qBaseActivity, stsimplemetaperson);
            d(i3, 1);
        }

        protected void e(int i3, int i16) {
            f(i3, i16, this.f80560a.P());
        }

        protected void g(int i3, int i16, String str) {
            Map<String, String> P = this.f80560a.P();
            P.put("comment_id", str);
            f(i3, i16, P);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c extends b {

        /* renamed from: b, reason: collision with root package name */
        private final int f80561b;

        c(int i3, WsCommentPresenter wsCommentPresenter) {
            super(wsCommentPresenter);
            this.f80561b = i3;
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.l
        public void a(Object obj, int i3) {
            if (obj instanceof stSimpleMetaComment) {
                this.f80560a.x0((stSimpleMetaComment) obj, null, 0);
                e(1000001, this.f80561b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class d extends b {
        d(WsCommentPresenter wsCommentPresenter) {
            super(wsCommentPresenter);
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.l
        public void a(Object obj, int i3) {
            if (obj instanceof stSimpleMetaComment) {
                stSimpleMetaComment stsimplemetacomment = (stSimpleMetaComment) obj;
                this.f80560a.D().t(this.f80560a.G(), stsimplemetacomment);
                this.f80560a.o0(true);
                g(stsimplemetacomment.isDing == 0 ? 1001002 : 1001001, 3, stsimplemetacomment.f25128id);
                BaseFragment J = this.f80560a.J();
                if (J instanceof WSFollowFragment) {
                    int i16 = i3 - 1;
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = ((WSFollowFragment) J).x().getRecyclerView().findViewHolderForAdapterPosition(this.f80560a.M());
                    if (findViewHolderForAdapterPosition instanceof WSFollowFeedHolder) {
                        x.l("comment", "***getPosition():" + this.f80560a.M() + ",realPosition:" + i16);
                        ((WSFollowFeedHolder) findViewHolderForAdapterPosition).m0(i16);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class e extends b {
        e(WsCommentPresenter wsCommentPresenter) {
            super(wsCommentPresenter);
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.l
        public void a(Object obj, int i3) {
            Object obj2;
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length <= 1 || (obj2 = objArr[0]) == null) {
                    return;
                }
                this.f80560a.C().o((stSimpleMetaComment) obj2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class f extends b {
        f(WsCommentPresenter wsCommentPresenter) {
            super(wsCommentPresenter);
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.l
        public void a(Object obj, int i3) {
            if (obj instanceof stSimpleMetaComment) {
                this.f80560a.C().p((stSimpleMetaComment) obj);
                e(1000001, 5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class g extends b {
        g(WsCommentPresenter wsCommentPresenter) {
            super(wsCommentPresenter);
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.l
        public void a(Object obj, int i3) {
            if (obj instanceof stSimpleMetaPerson) {
                stSimpleMetaPerson stsimplemetaperson = (stSimpleMetaPerson) obj;
                c(stsimplemetaperson, stsimplemetaperson.avatarSchema, 6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class h extends b {
        h(WsCommentPresenter wsCommentPresenter) {
            super(wsCommentPresenter);
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.l
        public void a(Object obj, int i3) {
            Object obj2;
            Object obj3;
            stSimpleMetaPerson stsimplemetaperson;
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length <= 1 || (obj2 = objArr[0]) == null || (obj3 = objArr[1]) == null || !(obj2 instanceof stSimpleMetaComment) || !(obj3 instanceof stSimpleMetaReply) || (stsimplemetaperson = ((stSimpleMetaReply) obj3).poster) == null) {
                    return;
                }
                c(stsimplemetaperson, stsimplemetaperson.avatarSchema, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class i extends b {

        /* renamed from: b, reason: collision with root package name */
        private final int f80562b;

        i(int i3, WsCommentPresenter wsCommentPresenter) {
            super(wsCommentPresenter);
            this.f80562b = i3;
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.l
        public void a(Object obj, int i3) {
            Object obj2;
            Object obj3;
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length <= 1 || (obj2 = objArr[0]) == null || (obj3 = objArr[1]) == null || !(obj2 instanceof stSimpleMetaComment) || !(obj3 instanceof stSimpleMetaReply)) {
                    return;
                }
                this.f80560a.x0((stSimpleMetaComment) obj2, (stSimpleMetaReply) obj3, 0);
                e(1000001, this.f80562b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class j extends b {
        j(WsCommentPresenter wsCommentPresenter) {
            super(wsCommentPresenter);
        }

        @Override // com.tencent.biz.pubaccount.weishi.comment.l
        public void a(Object obj, int i3) {
            String str = "weishi://feed?feed_id=" + ((String) obj);
            WSDownloadParams b16 = b(str, 14);
            String R = this.f80560a.R();
            String L = this.f80560a.L();
            String f16 = com.tencent.biz.pubaccount.weishi.report.b.f(R);
            if (TextUtils.equals(R, WSPublicAccReport.SOP_NAME_FOCUS)) {
                f16 = f16 + this.f80560a.Q();
            }
            String str2 = f16;
            FragmentActivity activity = this.f80560a.J().getActivity();
            if (com.tencent.biz.qqstory.utils.l.c(activity.getApplicationContext())) {
                ao.f(activity, "biz_src_jc_gzh_weishi", str, b16.mScene, b16.mLinkStrategyType, b16.mEventId);
                com.tencent.biz.pubaccount.weishi.report.b.r(R, L, str2, 1000003, this.f80560a.G());
            } else {
                com.tencent.biz.pubaccount.weishi.report.b.r(R, L, str2, 1000002, this.f80560a.G());
            }
        }
    }

    public static l a(WsCommentPresenter wsCommentPresenter, int i3) {
        if (i3 == 12) {
            return new j(wsCommentPresenter);
        }
        if (i3 == 2) {
            return new g(wsCommentPresenter);
        }
        if (i3 == 1) {
            return new C0820a(wsCommentPresenter);
        }
        if (i3 == 15) {
            return new h(wsCommentPresenter);
        }
        if (i3 == 4) {
            return new c(1, wsCommentPresenter);
        }
        if (i3 == 13) {
            return new c(9, wsCommentPresenter);
        }
        if (i3 == 7) {
            return new i(1, wsCommentPresenter);
        }
        if (i3 == 14) {
            return new i(9, wsCommentPresenter);
        }
        if (i3 == 10) {
            return new f(wsCommentPresenter);
        }
        if (i3 == 11) {
            return new e(wsCommentPresenter);
        }
        if (i3 == 6) {
            return new d(wsCommentPresenter);
        }
        return null;
    }
}
