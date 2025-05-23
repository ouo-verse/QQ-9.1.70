package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class StatusVisibleFragment extends QIphoneTitleBarFragment implements View.OnClickListener, OnlineStatusPermissionManager.b {
    private static b P;
    private Activity C;
    private AppRuntime D;
    private View E;
    private View F;
    private TextView G;
    private View H;
    private TextView I;
    private OnlineStatusPermissionChecker.OnlineStatusPermissionItem J;
    private OnlineStatusPermissionChecker.OnlineStatusPermissionItem K;
    private int L;
    private boolean M = false;
    private b N;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements Function2<View, BaseAction, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            if (baseAction == BaseAction.ACTION_RIGHT_TEXT) {
                StatusVisibleFragment.this.uh();
                return null;
            }
            if (baseAction == BaseAction.ACTION_LEFT_TEXT) {
                StatusVisibleFragment.this.onBackEvent();
                return null;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void Zb(OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem);
    }

    private void initViews() {
        this.E = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f85024nu);
        this.F = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f85144o6);
        this.G = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.s8a);
        this.H = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f85154o7);
        this.I = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.s8b);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.s8c).setOnClickListener(this);
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.xvr).setOnClickListener(this);
        setTitle(this.D.getApp().getString(R.string.f172616sl0));
        this.quiSecNavBar.setLeftText(this.D.getApp().getString(R.string.cancel));
        this.quiSecNavBar.setLeftType(1);
        this.quiSecNavBar.setRightText(this.D.getApp().getString(R.string.b9f));
        this.quiSecNavBar.setRightType(1);
        this.quiSecNavBar.setOnBaseTitleBarClickListener(new a());
        xh();
        wh();
        this.L = getQBaseActivity().getIntent().getIntExtra("key_launch_scene", -1);
    }

    private void qh() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i3 = 0; i3 < this.K.getPermissionUins().size(); i3++) {
            spannableStringBuilder.append((CharSequence) ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getFriendShowName(String.valueOf(this.K.getPermissionUins().get(i3))));
            if (i3 != this.K.getPermissionUins().size() - 1) {
                spannableStringBuilder.append((CharSequence) "\u3001");
            }
        }
        this.G.setText(spannableStringBuilder.toString());
        Drawable drawable = getResources().getDrawable(R.drawable.common_arrow_right_selector);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.I.setCompoundDrawables(null, null, drawable, null);
        if (this.K.getPermissionUins().size() > 0) {
            this.I.setText("\uff08" + this.K.getPermissionUins().size() + "\u4eba\uff09");
            return;
        }
        this.I.setText("");
    }

    private void rh() {
        if (this.K == null) {
            OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem) getQBaseActivity().getIntent().getSerializableExtra("online_status_permission_item");
            this.K = onlineStatusPermissionItem;
            if (onlineStatusPermissionItem == null) {
                OnlineStatusFriendsPermissionItem D = ((OnlineStatusPermissionManager) ((IOnlineStatusManagerService) this.D.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.i.class)).D(40001L, true, this);
                if (D != null) {
                    this.M = false;
                    this.K = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, D.allHasPermission, D.permissionUins);
                } else {
                    this.M = true;
                    this.K = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, true, null);
                }
            } else {
                this.M = false;
            }
        } else {
            this.M = false;
        }
        OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem2 = this.K;
        if (onlineStatusPermissionItem2 != null) {
            onlineStatusPermissionItem2.filterNotFriend();
        }
    }

    public static void sh(Activity activity, OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem, int i3, int i16, b bVar) {
        P = bVar;
        Intent intent = new Intent(activity, (Class<?>) StatusVisibleFragment.class);
        if (onlineStatusPermissionItem != null) {
            intent.putExtra("online_status_permission_item", onlineStatusPermissionItem);
        }
        intent.putExtra("key_launch_scene", i3);
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) StatusVisibleFragment.class, i16);
    }

    private void th() {
        if (this.E.getVisibility() != 0) {
            OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem = this.K;
            if (onlineStatusPermissionItem != null && !onlineStatusPermissionItem.isAllHasPermission()) {
                if (QLog.isColorLevel()) {
                    QLog.d("StatusVisibleFragment", 2, "account_online_status_show_all! mOnlinePermission is part");
                }
                this.J = this.K;
            }
            this.K = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, true, null);
            xh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh() {
        Intent intent = new Intent();
        intent.putExtra("online_status_permission_item", this.K);
        this.C.setResult(-1, intent);
        this.C.finish();
        b bVar = this.N;
        if (bVar != null) {
            bVar.Zb(this.K);
        }
        int i3 = this.L;
        if (i3 == 2) {
            bv.c("0X800AF96", 2, "1");
        } else if (i3 == 1) {
            bv.c("0X800AF96", 1, "1");
        } else if (i3 == 3) {
            bv.c("0X800AF96", 1, "2");
        }
    }

    private void vh() {
        String str;
        if (this.F.getVisibility() != 0) {
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[2];
                objArr[0] = "account_online_status_show_part! mLastPartPermission:";
                if (this.J == null) {
                    str = "null";
                } else {
                    str = " not null";
                }
                objArr[1] = str;
                QLog.d("StatusVisibleFragment", 2, objArr);
            }
            OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem = this.J;
            if (onlineStatusPermissionItem == null) {
                OnlineStatusPermissionChecker.d(this.D, this.C, this.K, false);
                return;
            } else {
                this.K = onlineStatusPermissionItem;
                xh();
                return;
            }
        }
        OnlineStatusPermissionChecker.d(this.D, this.C, this.K, false);
    }

    private void wh() {
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.xvq);
        if (findViewById instanceof FormItemRelativeLayout) {
            ((FormItemRelativeLayout) findViewById).setBGType(1);
        }
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.xvr);
        if (findViewById2 instanceof FormItemRelativeLayout) {
            ((FormItemRelativeLayout) findViewById2).setBGType(3);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager.b
    public void G6(OnlineStatusFriendsPermissionItem onlineStatusFriendsPermissionItem, List<Integer> list) {
        if (this.M) {
            this.K = OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, onlineStatusFriendsPermissionItem.allHasPermission, onlineStatusFriendsPermissionItem.permissionUins);
            xh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dqy;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 100) {
            OnlineStatusPermissionChecker.OnlineStatusPermissionItem b16 = OnlineStatusPermissionChecker.b(intent, i16, this.C, this.D, false);
            if (b16 != null) {
                this.K = b16;
                xh();
            }
            if (i16 == 0) {
                bv.b("0X800AF4B", 1);
            } else if (i16 == -1) {
                bv.b("0X800AF4A", 1);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        int i3 = this.L;
        if (i3 == 2) {
            bv.c("0X800AF95", 2, "1");
        } else if (i3 == 1) {
            bv.c("0X800AF95", 1, "1");
        } else if (i3 == 3) {
            bv.c("0X800AF95", 1, "2");
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.s8c) {
            if (QLog.isColorLevel()) {
                QLog.d("StatusVisibleFragment", 2, "account_online_status_show_all!");
            }
            th();
        } else if (id5 == R.id.xvr) {
            if (QLog.isColorLevel()) {
                QLog.d("StatusVisibleFragment", 2, "account_online_status_show_part!");
            }
            vh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.D = MobileQQ.getMobileQQ().waitAppRuntime(null);
        this.C = getQBaseActivity();
        this.N = P;
        P = null;
        initViews();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }

    public void xh() {
        rh();
        int i3 = 0;
        if (this.K.isAllHasPermission()) {
            this.E.setVisibility(0);
            this.F.setVisibility(8);
            this.H.setVisibility(8);
        } else {
            this.E.setVisibility(8);
            this.F.setVisibility(0);
            this.H.setVisibility(0);
            if (this.K.getPermissionUins() == null) {
                return;
            } else {
                qh();
            }
        }
        View view = this.F;
        if (this.K.isAllHasPermission()) {
            i3 = 8;
        }
        view.setVisibility(i3);
    }
}
