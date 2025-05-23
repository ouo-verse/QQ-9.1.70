package com.tencent.mobileqq.onlinestatus.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.onlinestatus.networkhandler.OnlineStatusAggregationHandler;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$LikeItem;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$NotifyItem;

/* compiled from: P */
/* loaded from: classes16.dex */
public class FriendBiaoTaiDialog extends BottomSheetDialogFragment {
    private final AppInterface C = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    private final Context D;
    private final List<OnlineStatusLikeInfo$NotifyItem> E;
    private View F;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends BottomSheetBehavior.e {
        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
            if (QLog.isDevelopLevel()) {
                QLog.i("FriendBiaoTaiDialog", 4, "onSlide\uff1aslideOffset = " + f16);
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            if (QLog.isColorLevel()) {
                QLog.i("FriendBiaoTaiDialog", 2, "onStateChanged\uff1anewState = " + i3);
            }
            if (i3 == 4) {
                FriendBiaoTaiDialog.this.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b extends RecyclerView.Adapter<e> {
        private final Context C;
        private final AppInterface D;

        /* renamed from: m, reason: collision with root package name */
        public boolean f256403m = false;
        private final List<c> E = new ArrayList();

        public b(Context context, AppInterface appInterface, RecyclerView recyclerView) {
            this.C = context;
            this.D = appInterface;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.E.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull e eVar, int i3) {
            if (i3 >= getItemCount()) {
                return;
            }
            c cVar = this.E.get(i3);
            eVar.I.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.D, cVar.f256405a, (byte) 3));
            eVar.E.setText(cVar.f256406b);
            eVar.H.setImageResource(cVar.f256409e);
            eVar.G.setText(cVar.f256407c);
            eVar.F.setText(cVar.f256408d);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public e onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            return new e(LayoutInflater.from(this.C).inflate(R.layout.dzl, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class c {

        /* renamed from: g, reason: collision with root package name */
        private static final StringBuffer f256404g = new StringBuffer(25);

        /* renamed from: a, reason: collision with root package name */
        private final String f256405a;

        /* renamed from: b, reason: collision with root package name */
        private final String f256406b;

        /* renamed from: c, reason: collision with root package name */
        private final String f256407c;

        /* renamed from: d, reason: collision with root package name */
        private final CharSequence f256408d;

        /* renamed from: e, reason: collision with root package name */
        private final int f256409e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f256410f;

        c(OnlineStatusLikeInfo$NotifyItem onlineStatusLikeInfo$NotifyItem, Context context) {
            String valueOf = String.valueOf(onlineStatusLikeInfo$NotifyItem.uin.get());
            this.f256405a = valueOf;
            this.f256408d = en.q(f256404g, onlineStatusLikeInfo$NotifyItem.time.get() * 1000, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
            this.f256407c = context.getResources().getString(h(onlineStatusLikeInfo$NotifyItem.business_type, onlineStatusLikeInfo$NotifyItem.scene));
            this.f256409e = f(onlineStatusLikeInfo$NotifyItem.like_items.get());
            this.f256406b = i(valueOf);
            this.f256410f = onlineStatusLikeInfo$NotifyItem.self_like_items.has() && j(onlineStatusLikeInfo$NotifyItem.self_like_items.get());
        }

        private int f(List<OnlineStatusLikeInfo$LikeItem> list) {
            if (list.isEmpty()) {
                QLog.e("FriendBiaoTaiDialog", 1, "error likeItemList empty");
                return R.drawable.n59;
            }
            int i3 = list.get(0).like_type.get();
            if (i3 == 1) {
                return R.drawable.n59;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            QLog.e("FriendBiaoTaiDialog", 1, "error dianZanType : " + i3);
                            return R.drawable.n59;
                        }
                        return R.drawable.f161163n52;
                    }
                    return R.drawable.f161165n54;
                }
                return R.drawable.f161166n55;
            }
            return R.drawable.f161160n50;
        }

        private int g(PBUInt32Field pBUInt32Field) {
            if (!pBUInt32Field.has()) {
                QLog.e("FriendBiaoTaiDialog", 1, "scene empty");
                return R.string.f201424ur;
            }
            if (pBUInt32Field.get() != 1) {
                return R.string.f201424ur;
            }
            return R.string.f201414uq;
        }

        private int h(PBUInt32Field pBUInt32Field, PBUInt32Field pBUInt32Field2) {
            if (!pBUInt32Field.has()) {
                QLog.e("FriendBiaoTaiDialog", 1, "businessType empty");
                return g(pBUInt32Field2);
            }
            if (pBUInt32Field.get() == 2) {
                return R.string.f201434us;
            }
            return g(pBUInt32Field2);
        }

        private String i(String str) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid;
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            if (uidFromUin != null && !uidFromUin.isEmpty() && (friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "FriendBiaoTaiDialog")) != null) {
                return friendsSimpleInfoWithUid.m();
            }
            return str;
        }

        private boolean j(List<OnlineStatusLikeInfo$LikeItem> list) {
            if (list.isEmpty() || list.get(0).like_type.get() == 0) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class d extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        int f256411d;

        public d(int i3) {
            this.f256411d = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.top = 0;
            } else {
                rect.top = this.f256411d;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class e extends RecyclerView.ViewHolder {
        public final TextView E;
        public final TextView F;
        public final TextView G;
        public final ImageView H;
        public final ImageView I;

        e(View view) {
            super(view);
            this.I = (ImageView) view.findViewById(R.id.dvo);
            this.H = (ImageView) view.findViewById(R.id.dvu);
            this.E = (TextView) view.findViewById(R.id.tv_name);
            this.G = (TextView) view.findViewById(R.id.k6s);
            this.F = (TextView) view.findViewById(R.id.kbp);
        }
    }

    public FriendBiaoTaiDialog(Context context, List<OnlineStatusLikeInfo$NotifyItem> list) {
        this.D = context;
        this.E = list;
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) this.F.findViewById(R.id.t6o);
        b bVar = new b(this.D, this.C, recyclerView);
        Iterator<OnlineStatusLikeInfo$NotifyItem> it = this.E.iterator();
        while (it.hasNext()) {
            bVar.E.add(new c(it.next(), this.D));
        }
        int size = bVar.E.size();
        int a16 = com.tencent.mobileqq.utils.x.a(18.0f);
        int a17 = com.tencent.mobileqq.utils.x.a(12.0f);
        int a18 = (com.tencent.mobileqq.utils.x.a(54.0f) * size) + ((size - 1) * a17) + a16;
        int a19 = com.tencent.mobileqq.utils.x.a(584.0f);
        int max = Math.max(Math.min(a18, a19), com.tencent.mobileqq.utils.x.a(234.0f));
        recyclerView.getLayoutParams().height = max;
        recyclerView.setAdapter(bVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new d(a17));
        View findViewById = this.F.findViewById(R.id.t6p);
        if (max == a19) {
            findViewById.setVisibility(0);
        }
        if (QQTheme.isNowThemeIsNight()) {
            findViewById.setBackgroundResource(R.drawable.jl5);
        }
    }

    public static void ph(QBaseActivity qBaseActivity, List<OnlineStatusLikeInfo$NotifyItem> list) {
        if (list != null && !list.isEmpty()) {
            new FriendBiaoTaiDialog(qBaseActivity, list).show(qBaseActivity.getSupportFragmentManager(), "FriendBiaoTaiDialog");
        } else {
            QLog.d("FriendBiaoTaiDialog", 1, "show notifyItems is null or empty");
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) super.onCreateDialog(bundle);
        aVar.getBehavior().setState(3);
        aVar.getBehavior().setSkipCollapsed(true);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view;
        if (getContext() == null) {
            view = null;
        } else {
            this.F = layoutInflater.inflate(R.layout.fqk, viewGroup);
            initView();
            view = this.F;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((ViewGroup) this.F.getParent()).setBackgroundColor(0);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        if (aVar == null) {
            return;
        }
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        behavior.setState(3);
        behavior.setPeekHeight(0);
        behavior.addBottomSheetCallback(new a());
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        super.show(fragmentManager, str);
        ((OnlineStatusAggregationHandler) this.C.getBusinessHandler(OnlineStatusAggregationHandler.class.getName())).L2();
        com.tencent.mobileqq.onlinestatus.utils.z.o();
    }
}
