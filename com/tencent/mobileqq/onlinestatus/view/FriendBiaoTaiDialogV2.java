package com.tencent.mobileqq.onlinestatus.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusLikeStatusApi;
import com.tencent.mobileqq.onlinestatus.networkhandler.OnlineStatusAggregationHandler;
import com.tencent.mobileqq.onlinestatus.view.FriendBiaoTaiDialogV2;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$LikeItem;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$NotifyItem;

/* compiled from: P */
/* loaded from: classes16.dex */
public class FriendBiaoTaiDialogV2 extends BottomSheetDialogFragment {
    private final AppInterface C;
    private final Context D;
    private final List<OnlineStatusLikeInfo$NotifyItem> E;
    private View F;
    private CalloutPopupWindow G;
    private c H;
    private long I;
    private final com.tencent.mobileqq.onlinestatus.observer.b J;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends com.tencent.mobileqq.onlinestatus.observer.b {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.onlinestatus.observer.b
        public void d(boolean z16, Bundle bundle) {
            boolean z17;
            super.d(z16, bundle);
            boolean z18 = true;
            if (bundle != null && FriendBiaoTaiDialogV2.this.H != null) {
                String string = bundle.getString("os_uin_key", "");
                if (z16 && !TextUtils.isEmpty(string)) {
                    FriendBiaoTaiDialogV2.this.H.t0(string);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("FriendBiaoTaiDialogNew", 2, "[updateLikeStatus] isSuccess = " + z16);
                }
                QQToast.makeText(FriendBiaoTaiDialogV2.this.getContext(), 1, FriendBiaoTaiDialogV2.this.getResources().getString(R.string.f172522qo), 1).show();
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[updateLikeStatus] ");
                if (bundle == null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                if (FriendBiaoTaiDialogV2.this.H != null) {
                    z18 = false;
                }
                sb5.append(z18);
                QLog.i("FriendBiaoTaiDialogNew", 2, sb5.toString());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends BottomSheetBehavior.e {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
            if (QLog.isDevelopLevel()) {
                QLog.i("FriendBiaoTaiDialogNew", 4, "onSlide\uff1aslideOffset = " + f16);
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            if (QLog.isColorLevel()) {
                QLog.i("FriendBiaoTaiDialogNew", 2, "onStateChanged\uff1anewState = " + i3);
            }
            if (i3 == 4) {
                FriendBiaoTaiDialogV2.this.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class c extends RecyclerView.Adapter<f> {
        private final WeakReference<FriendBiaoTaiDialogV2> C;
        private final AppInterface D;
        private final List<d> E = new ArrayList();

        /* renamed from: m, reason: collision with root package name */
        private final Context f256414m;

        public c(Context context, AppInterface appInterface, WeakReference<FriendBiaoTaiDialogV2> weakReference) {
            this.f256414m = context;
            this.D = appInterface;
            this.C = weakReference;
        }

        private void l0() {
            FriendBiaoTaiDialogV2 friendBiaoTaiDialogV2;
            WeakReference<FriendBiaoTaiDialogV2> weakReference = this.C;
            if (weakReference == null || (friendBiaoTaiDialogV2 = weakReference.get()) == null) {
                return;
            }
            try {
                friendBiaoTaiDialogV2.dismiss();
            } catch (Exception unused) {
                QLog.d("FriendBiaoTaiDialogNew", 1, "[closeDialog] wrf");
            }
        }

        private void m0(View view) {
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 0.5f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 0.5f, 1.0f);
            he0.b.m(ofFloat, R.anim.f154979um, 5.0f);
            he0.b.m(ofFloat2, R.anim.f154979um, 5.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            he0.b.m(ofFloat3, R.anim.f154985us, 5.0f);
            animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
            animatorSet.start();
        }

        private void n0(String str, String str2) {
            try {
                AllInOne allInOne = new AllInOne(str, 1);
                if (str2 != null) {
                    allInOne.nickname = str2;
                }
                ProfileUtils.openProfileCard(BaseApplication.getContext(), allInOne);
            } catch (Throwable unused) {
                QLog.e("FriendBiaoTaiDialogNew", 1, "jump to qq profile card failed!");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o0(d dVar, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.mobileqq.utils.u.a().b()) {
                n0(dVar.f256415a, dVar.f256416b);
                if (AppSetting.o(BaseApplication.getContext())) {
                    l0();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("touin", dVar.f256415a);
                com.tencent.mobileqq.onlinestatus.utils.v.b("em_bas_avatar", hashMap);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p0(f fVar, d dVar, View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.mobileqq.utils.u.a().b()) {
                Context context = view.getContext();
                if (!NetworkUtil.isNetSupport(context)) {
                    QQToast.makeText(context, 1, context.getResources().getString(R.string.b3j), 1).show();
                } else {
                    AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    if (appInterface != null) {
                        if (!fVar.J.isSelected()) {
                            m0(fVar.J);
                        }
                        ((IOnlineStatusLikeStatusApi) QRoute.api(IOnlineStatusLikeStatusApi.class)).sendLikeStatusReq(appInterface, dVar.f256415a, dVar.f256419e, 1, fVar.J.isSelected() ? 1 : 0, null, null);
                        HashMap hashMap = new HashMap();
                        hashMap.put("touin", dVar.f256415a);
                        if (fVar.J.isSelected()) {
                            str = "2";
                        } else {
                            str = "1";
                        }
                        hashMap.put("after_click_state", str);
                        com.tencent.mobileqq.onlinestatus.utils.v.b("em_bas_like_button", hashMap);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
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
        /* renamed from: q0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull final f fVar, int i3) {
            final d dVar;
            String str;
            if (i3 >= getItemCount() || (dVar = this.E.get(i3)) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("touin", dVar.f256415a);
            com.tencent.mobileqq.onlinestatus.utils.v.f("em_bas_avatar", hashMap);
            fVar.I.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.D, dVar.f256415a, (byte) 3));
            fVar.I.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.ah
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FriendBiaoTaiDialogV2.c.this.o0(dVar, view);
                }
            });
            com.tencent.mobileqq.onlinestatus.bs.F0(dVar.f256415a, fVar.M, fVar.L, true);
            fVar.E.setText(dVar.f256416b);
            fVar.H.setImageResource(dVar.f256418d);
            fVar.G.setText(" \u00b7 \u5411\u4f60\u53d1\u9001");
            fVar.F.setText(dVar.f256417c);
            fVar.J.setSelected(dVar.f256420f);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("touin", dVar.f256415a);
            if (fVar.J.isSelected()) {
                str = "2";
            } else {
                str = "1";
            }
            hashMap2.put("after_click_state", str);
            com.tencent.mobileqq.onlinestatus.utils.v.f("em_bas_like_button", hashMap2);
            fVar.K.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.ai
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FriendBiaoTaiDialogV2.c.this.p0(fVar, dVar, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: r0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull f fVar, int i3, @NonNull List<Object> list) {
            if (list.isEmpty()) {
                onBindViewHolder(fVar, i3);
            } else {
                fVar.J.setSelected(((Boolean) list.get(0)).booleanValue());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: s0, reason: merged with bridge method [inline-methods] */
        public f onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            return new f(LayoutInflater.from(this.f256414m).inflate(R.layout.fdd, viewGroup, false));
        }

        public void t0(String str) {
            for (int i3 = 0; i3 < this.E.size(); i3++) {
                d dVar = this.E.get(i3);
                if (TextUtils.equals(dVar.f256415a, str)) {
                    dVar.f256420f = !dVar.f256420f;
                    notifyItemChanged(i3, Boolean.valueOf(dVar.f256420f));
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f256415a;

        /* renamed from: b, reason: collision with root package name */
        private final String f256416b;

        /* renamed from: c, reason: collision with root package name */
        private final CharSequence f256417c;

        /* renamed from: d, reason: collision with root package name */
        private final int f256418d;

        /* renamed from: e, reason: collision with root package name */
        private final int f256419e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f256420f;

        d(OnlineStatusLikeInfo$NotifyItem onlineStatusLikeInfo$NotifyItem) {
            boolean z16;
            String valueOf = String.valueOf(onlineStatusLikeInfo$NotifyItem.uin.get());
            this.f256415a = valueOf;
            this.f256417c = en.r(new StringBuffer(25), onlineStatusLikeInfo$NotifyItem.time.get() * 1000, true, "", true);
            this.f256418d = h(onlineStatusLikeInfo$NotifyItem.like_items.get());
            this.f256419e = i(onlineStatusLikeInfo$NotifyItem.self_like_items.get());
            this.f256416b = com.tencent.mobileqq.onlinestatus.bs.x(valueOf);
            if (onlineStatusLikeInfo$NotifyItem.self_like_items.has() && j(onlineStatusLikeInfo$NotifyItem.self_like_items.get())) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f256420f = z16;
        }

        private int h(List<OnlineStatusLikeInfo$LikeItem> list) {
            if (list.isEmpty()) {
                QLog.e("FriendBiaoTaiDialogNew", 1, "error likeItemList empty");
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
                            QLog.e("FriendBiaoTaiDialogNew", 1, "error dianZanType : " + i3);
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

        private int i(List<OnlineStatusLikeInfo$LikeItem> list) {
            if (list.isEmpty()) {
                QLog.e("FriendBiaoTaiDialogNew", 1, "error selfLikeItemList empty");
                return 1;
            }
            return list.get(0).like_type.get();
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
    public static class e extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        int f256421d;

        public e(int i3) {
            this.f256421d = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.top = 0;
            } else {
                rect.top = this.f256421d;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class f extends RecyclerView.ViewHolder {
        public final TextView E;
        public final TextView F;
        public final TextView G;
        public final ImageView H;
        public final ImageView I;
        public final ImageView J;
        public final View K;
        public final ImageView L;
        public final TextView M;

        f(View view) {
            super(view);
            this.I = (ImageView) view.findViewById(R.id.dvo);
            this.H = (ImageView) view.findViewById(R.id.dvu);
            this.E = (TextView) view.findViewById(R.id.tv_name);
            this.G = (TextView) view.findViewById(R.id.k6s);
            this.F = (TextView) view.findViewById(R.id.kbp);
            this.K = view.findViewById(R.id.yeo);
            this.J = (ImageView) view.findViewById(R.id.xk6);
            this.L = (ImageView) view.findViewById(R.id.y6l);
            this.M = (TextView) view.findViewById(R.id.f109766gp);
        }
    }

    public FriendBiaoTaiDialogV2(Context context, List<OnlineStatusLikeInfo$NotifyItem> list) {
        a aVar = new a();
        this.J = aVar;
        this.D = context;
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        this.C = appInterface;
        if (appInterface != null) {
            appInterface.addObserver(aVar);
        }
        this.E = list;
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) this.F.findViewById(R.id.t6o);
        this.H = new c(this.D, this.C, new WeakReference(this));
        Iterator<OnlineStatusLikeInfo$NotifyItem> it = this.E.iterator();
        while (it.hasNext()) {
            this.H.E.add(new d(it.next()));
        }
        int size = this.H.E.size();
        int a16 = com.tencent.mobileqq.utils.x.a(18.0f);
        int a17 = com.tencent.mobileqq.utils.x.a(12.0f);
        int a18 = (com.tencent.mobileqq.utils.x.a(54.0f) * size) + ((size - 1) * a17) + a16;
        int a19 = com.tencent.mobileqq.utils.x.a(584.0f);
        int max = Math.max(Math.min(a18, a19), com.tencent.mobileqq.utils.x.a(234.0f));
        recyclerView.getLayoutParams().height = max;
        recyclerView.setAdapter(this.H);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new e(a17));
        final MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        final String keyWithUin = QMMKVFile.getKeyWithUin("FriendBiaoTaiDialogNew", IOnLineStatueHelperApi.SHOWED_BIAOTAI_ITEM_POP);
        if (!from.decodeBool(keyWithUin, false)) {
            recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.af
                @Override // java.lang.Runnable
                public final void run() {
                    FriendBiaoTaiDialogV2.this.vh(linearLayoutManager, from, keyWithUin);
                }
            });
        }
        View findViewById = this.F.findViewById(R.id.t6p);
        if (max == a19) {
            findViewById.setVisibility(0);
        }
        if (QQTheme.isNowThemeIsNight()) {
            findViewById.setBackgroundResource(R.drawable.jl5);
        }
    }

    private CalloutPopupWindow sh(String str) {
        return new CalloutPopupWindow.DrawableBuilder(CalloutPopupWindow.builder(this.D).setText(str).setTextSize(14.0f).setTextColor(-1).setPosition(49).setLifetime(3)).setBackgroundColor(this.D.getResources().getColor(R.color.c4v)).setBackgroundRadius(4).build().build();
    }

    private String uh(int i3) {
        c cVar = this.H;
        if (cVar != null && i3 >= 0 && i3 < cVar.E.size()) {
            return ((d) this.H.E.get(i3)).f256415a;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vh(LinearLayoutManager linearLayoutManager, MMKVOptionEntity mMKVOptionEntity, String str) {
        int i3;
        View view;
        int childCount = linearLayoutManager.getChildCount();
        int i16 = 0;
        while (true) {
            i3 = i16 + 1;
            View childAt = linearLayoutManager.getChildAt(i16);
            if (childAt == null || ViewUtils.isObscured(childAt, false, true)) {
                break;
            }
            if (!childAt.findViewById(R.id.xk6).isSelected()) {
                view = childAt.findViewById(R.id.yeo);
                break;
            } else if (i3 >= childCount) {
                break;
            } else {
                i16 = i3;
            }
        }
        view = null;
        yh(view, i3);
        mMKVOptionEntity.encodeBool(str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wh() {
        this.G = null;
    }

    public static FriendBiaoTaiDialogV2 xh(QBaseActivity qBaseActivity, List<OnlineStatusLikeInfo$NotifyItem> list) {
        if (com.tencent.mobileqq.utils.bl.b(list)) {
            QLog.d("FriendBiaoTaiDialogNew", 1, "show notifyItems is null or empty");
            return null;
        }
        FriendBiaoTaiDialogV2 friendBiaoTaiDialogV2 = new FriendBiaoTaiDialogV2(qBaseActivity, list);
        Dialog dialog = friendBiaoTaiDialogV2.getDialog();
        if (dialog != null && dialog.isShowing()) {
            return friendBiaoTaiDialogV2;
        }
        friendBiaoTaiDialogV2.show(qBaseActivity.getSupportFragmentManager(), "FriendBiaoTaiDialogNew");
        return friendBiaoTaiDialogV2;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        th();
        super.dismiss();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i3 = configuration.orientation;
        if (i3 == 2 || i3 == 1) {
            dismiss();
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
            this.F = layoutInflater.inflate(R.layout.f167909e63, viewGroup);
            initView();
            view = this.F;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AppInterface appInterface = this.C;
        if (appInterface != null) {
            appInterface.removeObserver(this.J);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.tencent.mobileqq.onlinestatus.utils.v.h("em_bas_notification_list", System.currentTimeMillis() - this.I);
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
        behavior.addBottomSheetCallback(new b());
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        super.show(fragmentManager, str);
        ((OnlineStatusAggregationHandler) this.C.getBusinessHandler(OnlineStatusAggregationHandler.class.getName())).L2();
        com.tencent.mobileqq.onlinestatus.utils.z.o();
        com.tencent.mobileqq.onlinestatus.utils.v.e("em_bas_notification_list");
        this.I = System.currentTimeMillis();
    }

    public void th() {
        CalloutPopupWindow calloutPopupWindow = this.G;
        if (calloutPopupWindow != null && calloutPopupWindow.isShowing()) {
            this.G.dismiss();
            this.G = null;
        }
    }

    public void yh(View view, int i3) {
        if (view != null && view.getVisibility() == 0) {
            try {
                CalloutPopupWindow sh5 = sh(this.D.getResources().getString(R.string.f172372q_));
                if (sh5 == null) {
                    QLog.d("FriendBiaoTaiDialogNew", 1, "[showLikeTipsPop] popupWindow = null");
                    return;
                }
                this.G = sh5;
                sh5.setMarginView(2);
                sh5.setMarginScreen((int) com.tencent.mobileqq.utils.al.a(this.D, 16.0f));
                sh5.showAsPointer(view);
                sh5.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.onlinestatus.view.ag
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public final void onDismiss() {
                        FriendBiaoTaiDialogV2.this.wh();
                    }
                });
                HashMap hashMap = new HashMap();
                hashMap.put("touin", uh(i3));
                com.tencent.mobileqq.onlinestatus.utils.v.f("em_bas_lead_like_toas", hashMap);
            } catch (Exception e16) {
                QLog.e("FriendBiaoTaiDialogNew", 1, "[showLikeTipsPop] exception:", e16);
            }
        }
    }
}
