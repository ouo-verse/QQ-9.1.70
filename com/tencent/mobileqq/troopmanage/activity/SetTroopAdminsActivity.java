package com.tencent.mobileqq.troopmanage.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qui.profileskin.widget.QUIImageView;
import com.tencent.biz.qui.profileskin.widget.QUITextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.dh;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickUIInfo;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopIntelligentManageApi;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.widget.TroopMemberListSlideItem;
import com.tencent.mobileqq.troopmanage.api.ITroopManageService;
import com.tencent.mobileqq.troopmanage.base.TroopManageBaseFragment;
import com.tencent.mobileqq.troopmanage.base.TroopManageRemoteHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.PinnedDividerSwipListView;
import com.tencent.widget.SimpleTextView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipTextViewMenuBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes19.dex */
public class SetTroopAdminsActivity extends TroopManageBaseFragment implements AdapterView.OnItemClickListener {
    static IPatchRedirector $redirector_;
    private PinnedDividerSwipListView E;
    private TextView F;
    private View G;
    private QQProAvatarView H;
    private TextView I;
    private TextView J;
    private View K;
    private QUITextView L;
    private QUIImageView M;
    private f N;
    private String P;
    private TroopInfo Q;
    private final ArrayList<TroopMemberNickUIInfo> R;
    private final HashMap<String, TroopMemberNickUIInfo> S;
    private final Map<String, Boolean> T;
    protected ArrayList<String> U;
    private QQProgressDialog V;
    private int W;
    protected boolean X;
    com.tencent.biz.troop.b Y;
    NewIntent Z;

    /* renamed from: a0, reason: collision with root package name */
    long f302878a0;

    /* renamed from: b0, reason: collision with root package name */
    protected QQAnonymousDialog f302879b0;

    /* renamed from: c0, reason: collision with root package name */
    private final com.tencent.mobileqq.troop.api.observer.e f302880c0;

    /* renamed from: d0, reason: collision with root package name */
    protected HashSet<String> f302881d0;

    /* renamed from: e0, reason: collision with root package name */
    protected View.OnClickListener f302882e0;

    /* renamed from: f0, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    Handler f302883f0;

    /* renamed from: g0, reason: collision with root package name */
    private final TroopManageRemoteHandler.b f302884g0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements com.tencent.qqnt.troopmemberlist.g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f302885a;

        a(String str) {
            this.f302885a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SetTroopAdminsActivity.this, (Object) str);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.g
        public void a(@Nullable TroopMemberInfo troopMemberInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberInfo);
                return;
            }
            QLog.i("SetTroopAdminsActivity", 1, "mTroopUin " + SetTroopAdminsActivity.this.P + ": memberUin=" + this.f302885a + ":" + troopMemberInfo);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SetTroopAdminsActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onSetTroopAdminFail(int i3) {
            String qqStr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            ((TroopManageBaseFragment) SetTroopAdminsActivity.this).D.reportClickEvent("CliOper", "", "", "Grp", "Grant_cancel_admin", 0, 1, SetTroopAdminsActivity.this.P, "", "", "");
            if (SetTroopAdminsActivity.this.V != null) {
                SetTroopAdminsActivity.this.V.dismiss();
            }
            if (i3 != 4) {
                if (i3 != 7) {
                    if (i3 != 17) {
                        qqStr = HardCodeUtil.qqStr(R.string.cpp);
                    } else {
                        qqStr = HardCodeUtil.qqStr(R.string.f235307ba);
                    }
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.cjf);
                }
            } else if (SetTroopAdminsActivity.this.W > 0) {
                qqStr = String.format(HardCodeUtil.qqStr(R.string.i4u), Integer.valueOf(SetTroopAdminsActivity.this.W));
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.i4v);
            }
            QBaseActivity qBaseActivity = SetTroopAdminsActivity.this.getQBaseActivity();
            if (qBaseActivity != null && qBaseActivity.isResume()) {
                SetTroopAdminsActivity.this.showToast(qqStr);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onSetTroopAdminSuccess(String str, String str2, byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, Byte.valueOf(b16));
                return;
            }
            if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
                SetTroopAdminsActivity.this.li(str2, b16);
                if (SetTroopAdminsActivity.this.V != null) {
                    SetTroopAdminsActivity.this.V.dismiss();
                }
                QBaseActivity qBaseActivity = SetTroopAdminsActivity.this.getQBaseActivity();
                if (qBaseActivity != null && qBaseActivity.isResume()) {
                    if (b16 == 0) {
                        SetTroopAdminsActivity.this.rh(qBaseActivity.getString(R.string.akp));
                    } else if (b16 == 1) {
                        SetTroopAdminsActivity.this.rh(qBaseActivity.getString(R.string.f_));
                    }
                    qBaseActivity.setResult(-1);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SetTroopAdminsActivity.this);
            }
        }

        private void a() {
            Iterator<String> it = SetTroopAdminsActivity.this.f302881d0.iterator();
            while (it.hasNext()) {
                g ki5 = SetTroopAdminsActivity.this.ki(it.next());
                if (ki5 != null) {
                    ki5.F.c(true);
                    it.remove();
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int id5 = view.getId();
                Object tag = view.getTag();
                if (id5 == R.id.f167016k03) {
                    tag = view.findViewById(R.id.bf9).getTag();
                }
                if (tag instanceof Integer) {
                    i3 = ((Integer) tag).intValue();
                } else {
                    i3 = -1;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SetTroopAdminsActivity", 2, "mOnKickOutBtnClickListener:" + i3);
                }
                if (i3 >= 0 && i3 < SetTroopAdminsActivity.this.R.size()) {
                    TroopMemberNickUIInfo troopMemberNickUIInfo = (TroopMemberNickUIInfo) SetTroopAdminsActivity.this.R.get(i3);
                    if (id5 == R.id.bf9) {
                        a();
                        g ki5 = SetTroopAdminsActivity.this.ki(troopMemberNickUIInfo.getUin());
                        if (ki5 != null) {
                            ki5.F.b(true);
                            SetTroopAdminsActivity.this.f302881d0.add(troopMemberNickUIInfo.getUin());
                        }
                    } else if (id5 == R.id.f167016k03) {
                        g ki6 = SetTroopAdminsActivity.this.ki(troopMemberNickUIInfo.getUin());
                        if (ki6 != null) {
                            ki6.F.c(true);
                            SetTroopAdminsActivity.this.f302881d0.remove(troopMemberNickUIInfo.getUin());
                        }
                    } else if (id5 == R.id.f164668ai4) {
                        if (SetTroopAdminsActivity.this.mi(troopMemberNickUIInfo.getUin()).booleanValue()) {
                            SetTroopAdminsActivity.this.fi(troopMemberNickUIInfo);
                        } else {
                            SetTroopAdminsActivity.this.gi(troopMemberNickUIInfo);
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d extends Handler {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SetTroopAdminsActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3) {
                    SetTroopAdminsActivity.this.stopTitleProgress();
                    SetTroopAdminsActivity.this.Pi((Map) message.obj);
                    return;
                }
                return;
            }
            SetTroopAdminsActivity.this.R.clear();
            SetTroopAdminsActivity.this.R.addAll((ArrayList) message.obj);
            SetTroopAdminsActivity.this.N.notifyDataSetChanged();
            SetTroopAdminsActivity.this.Mi();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleMessage: what=");
                sb5.append(message.what);
                sb5.append(", admins=");
                SetTroopAdminsActivity setTroopAdminsActivity = SetTroopAdminsActivity.this;
                sb5.append(setTroopAdminsActivity.ei(setTroopAdminsActivity.R));
                QLog.d("SetTroopAdminsActivity", 2, sb5.toString());
            }
            SetTroopAdminsActivity.this.Ii();
            SetTroopAdminsActivity.this.stopTitleProgress();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class e extends TroopManageRemoteHandler.b {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SetTroopAdminsActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troopmanage.base.TroopManageRemoteHandler.b
        public boolean a(List<String> list) {
            View childAt;
            QQProAvatarView qQProAvatarView;
            Bitmap f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list)).booleanValue();
            }
            if (list != null && !list.isEmpty() && SetTroopAdminsActivity.this.N != null && SetTroopAdminsActivity.this.E != null) {
                int count = SetTroopAdminsActivity.this.N.getCount();
                for (String str : list) {
                    if (!TextUtils.isEmpty(str)) {
                        if (SetTroopAdminsActivity.this.Q.isTroopOwner(str)) {
                            if (SetTroopAdminsActivity.this.H != null) {
                                SetTroopAdminsActivity.this.H.setImageBitmap(((TroopManageBaseFragment) SetTroopAdminsActivity.this).D.getTroopManageRemoteHandler().f(str));
                            }
                        } else {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= count) {
                                    break;
                                }
                                TroopMemberNickUIInfo troopMemberNickUIInfo = (TroopMemberNickUIInfo) SetTroopAdminsActivity.this.N.getItem(i3);
                                if (troopMemberNickUIInfo != null) {
                                    if ((troopMemberNickUIInfo.getUin() + "").equals(str)) {
                                        int headerViewsCount = (i3 + SetTroopAdminsActivity.this.E.getHeaderViewsCount()) - SetTroopAdminsActivity.this.E.getFirstVisiblePosition();
                                        if (headerViewsCount >= 0 && headerViewsCount < SetTroopAdminsActivity.this.E.getChildCount() && (childAt = SetTroopAdminsActivity.this.E.getChildAt(headerViewsCount)) != null && (qQProAvatarView = (QQProAvatarView) childAt.findViewById(R.id.dv9)) != null && (f16 = ((TroopManageBaseFragment) SetTroopAdminsActivity.this).D.getTroopManageRemoteHandler().f(str)) != null) {
                                            qQProAvatarView.setImageBitmap(f16);
                                            qQProAvatarView.setVisibility(0);
                                        }
                                    }
                                }
                                i3++;
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class f extends BaseAdapter implements SwipListView.SwipListListener, View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f302891d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f302892e;

        /* renamed from: f, reason: collision with root package name */
        public final int[] f302893f;

        /* renamed from: h, reason: collision with root package name */
        public final int[] f302894h;

        /* renamed from: i, reason: collision with root package name */
        protected SwipRightMenuBuilder f302895i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes19.dex */
        public class a extends SwipTextViewMenuBuilder {
            static IPatchRedirector $redirector_;

            a(int i3, int i16, int[] iArr, int i17, int[] iArr2, int[] iArr3, int[] iArr4) {
                super(i3, i16, iArr, i17, iArr2, iArr3, iArr4);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, f.this, Integer.valueOf(i3), Integer.valueOf(i16), iArr, Integer.valueOf(i17), iArr2, iArr3, iArr4);
                }
            }

            @Override // com.tencent.widget.SwipRightMenuBuilder
            public void getRightMenuItemInfo(int i3, Object obj, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr) {
                int i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                int i17 = 1;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), obj, swipRightMenuItemArr);
                    return;
                }
                if (obj instanceof Object[]) {
                    Object[] objArr = (Object[]) obj;
                    if (objArr.length != 2) {
                        return;
                    }
                    Object obj2 = objArr[0];
                    if (obj2 instanceof Integer[]) {
                        Integer[] numArr = (Integer[]) obj2;
                        if (swipRightMenuItemArr == null || swipRightMenuItemArr.length <= 0 || swipRightMenuItemArr.length != numArr.length) {
                            return;
                        }
                        if (swipRightMenuItemArr.length > 0) {
                            swipRightMenuItemArr[0].menuId = numArr[0].intValue();
                            SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem = swipRightMenuItemArr[0];
                            if (swipRightMenuItemArr.length == 1) {
                                i16 = 1;
                            } else {
                                i16 = 0;
                            }
                            swipRightMenuItem.menuType = i16;
                        } else {
                            i17 = 0;
                        }
                        if (i17 < swipRightMenuItemArr.length) {
                            swipRightMenuItemArr[i17].menuId = numArr[i17].intValue();
                            swipRightMenuItemArr[i17].menuType = 0;
                            i17++;
                        }
                        while (i17 < swipRightMenuItemArr.length) {
                            SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem2 = swipRightMenuItemArr[i17];
                            swipRightMenuItem2.menuId = -1;
                            swipRightMenuItem2.menuType = -1;
                            i17++;
                        }
                    }
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
            @Override // com.tencent.widget.SwipTextViewMenuBuilder, com.tencent.widget.SwipRightMenuBuilder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public View updateRightMenuItem(int i3, Object obj, SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem, View.OnClickListener onClickListener) {
                String[] strArr;
                int i16;
                View view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (View) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), obj, swipRightMenuItem, onClickListener);
                }
                SimpleTextView simpleTextView = null;
                if (obj instanceof Object[]) {
                    Object[] objArr = (Object[]) obj;
                    if (objArr.length == 2) {
                        Object obj2 = objArr[1];
                        if (obj2 instanceof String[]) {
                            strArr = (String[]) obj2;
                            if (swipRightMenuItem != null && swipRightMenuItem.menuType >= 0 && (i16 = swipRightMenuItem.menuId) >= 0) {
                                view = swipRightMenuItem.menuView;
                                if (view instanceof SimpleTextView) {
                                    simpleTextView = (SimpleTextView) view;
                                }
                                if (simpleTextView != null) {
                                    int i17 = this.MENU_STR_IDS[i16];
                                    int i18 = this.MENU_BG_IDS[i16];
                                    int i19 = this.MENU_IDS[i16];
                                    simpleTextView.setVisibility(0);
                                    simpleTextView.setText(simpleTextView.getContext().getResources().getString(i17));
                                    simpleTextView.setBackgroundResource(i18);
                                    simpleTextView.setId(i19);
                                    simpleTextView.setTag(strArr);
                                    simpleTextView.setContentDescription(simpleTextView.getResources().getString(i17));
                                    simpleTextView.setOnClickListener(onClickListener);
                                    swipRightMenuItem.menuWidth = this.MENU_WIDTH[swipRightMenuItem.menuType];
                                    swipRightMenuItem.menuHeight = this.MENU_HEIGHT;
                                }
                            }
                        }
                    }
                    strArr = null;
                    if (swipRightMenuItem != null) {
                        view = swipRightMenuItem.menuView;
                        if (view instanceof SimpleTextView) {
                        }
                        if (simpleTextView != null) {
                        }
                    }
                }
                return simpleTextView;
            }
        }

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SetTroopAdminsActivity.this);
                return;
            }
            this.f302891d = -1;
            this.f302892e = new int[]{R.string.bpy};
            this.f302893f = new int[]{R.drawable.cja};
            this.f302894h = new int[]{R.id.k27};
        }

        private Drawable b(Context context) {
            float dimension = context.getResources().getDimension(R.dimen.d_y);
            float[] fArr = {0.0f, 0.0f, dimension, dimension, dimension, dimension, 0.0f, 0.0f};
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(ie0.a.f().h(context, R.color.qui_common_feedback_error, 1001));
            gradientDrawable.setCornerRadii(fArr);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(ie0.a.f().h(context, R.color.qui_common_overlay_standard_primary, 1001));
            gradientDrawable2.setCornerRadii(fArr);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, gradientDrawable2});
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, layerDrawable);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }

        public SwipRightMenuBuilder a(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (SwipRightMenuBuilder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
            }
            return new a(1, 2, new int[]{context.getResources().getDimensionPixelSize(R.dimen.atw), context.getResources().getDimensionPixelSize(R.dimen.atx)}, -1, this.f302894h, this.f302892e, this.f302893f);
        }

        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            if (SetTroopAdminsActivity.this.E != null) {
                return true;
            }
            return false;
        }

        public void d(Context context, View view, int i3, Object obj, g gVar, View.OnClickListener onClickListener) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, context, view, Integer.valueOf(i3), obj, gVar, onClickListener);
                return;
            }
            if (obj == null) {
                return;
            }
            SwipRightMenuBuilder swipRightMenuBuilder = this.f302895i;
            if (swipRightMenuBuilder != null) {
                i16 = swipRightMenuBuilder.updateRightMenuView(context, view, i3, obj, gVar, onClickListener);
            } else {
                i16 = 0;
            }
            int scrollX = view.getScrollX();
            if (i3 >= 0 && this.f302891d == i3) {
                view.scrollTo(i16, 0);
            } else if (scrollX != 0) {
                view.scrollTo(0, 0);
            }
            if (scrollX != 0 && QLog.isDevelopLevel()) {
                com.tencent.mobileqq.nearby.l.b("updateItemMenuView", Integer.valueOf(i3), Integer.valueOf(scrollX), Integer.valueOf(this.f302891d));
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return SetTroopAdminsActivity.this.R.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return SetTroopAdminsActivity.this.R.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            QUIListItemBackgroundType qUIListItemBackgroundType;
            View view3;
            int i16;
            String qqStr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                view3 = view;
                view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                if (view == null) {
                    View inflate = SetTroopAdminsActivity.this.getLayoutInflater().inflate(R.layout.f169141c11, (ViewGroup) SetTroopAdminsActivity.this.E, false);
                    inflate.setBackground(null);
                    View findViewById = inflate.findViewById(R.id.f83574jx);
                    if (findViewById != null) {
                        findViewById.setBackground(null);
                    }
                    g gVar = new g();
                    gVar.H = inflate.findViewById(R.id.y26);
                    gVar.f302898i = (QQProAvatarView) inflate.findViewById(R.id.dv9);
                    gVar.f302899m = (ImageView) inflate.findViewById(R.id.y8d);
                    gVar.C = (TextView) inflate.findViewById(R.id.tv_name);
                    gVar.D = inflate.findViewById(R.id.bf9);
                    gVar.F = (TroopMemberListSlideItem) inflate;
                    View findViewById2 = inflate.findViewById(R.id.f164668ai4);
                    gVar.E = findViewById2;
                    findViewById2.setBackground(b(inflate.getContext()));
                    gVar.G = (TextView) inflate.findViewById(R.id.k_u);
                    gVar.D.setOnClickListener(SetTroopAdminsActivity.this.f302882e0);
                    gVar.E.setOnClickListener(SetTroopAdminsActivity.this.f302882e0);
                    if (c()) {
                        if (this.f302895i == null) {
                            this.f302895i = a(SetTroopAdminsActivity.this.getQBaseActivity());
                        }
                        inflate = this.f302895i.createView(SetTroopAdminsActivity.this.getQBaseActivity(), inflate, gVar, -1);
                        inflate.setTag(gVar);
                    } else {
                        gVar.leftView = inflate;
                        gVar.rightMenuItems = null;
                    }
                    inflate.setTag(gVar);
                    view2 = inflate;
                } else {
                    view2 = view;
                }
                g gVar2 = (g) view2.getTag();
                TroopMemberNickUIInfo troopMemberNickUIInfo = (TroopMemberNickUIInfo) SetTroopAdminsActivity.this.R.get(i3);
                if (troopMemberNickUIInfo != null) {
                    gVar2.f187210d = troopMemberNickUIInfo.getUin();
                    gVar2.f302898i.setImageBitmap(((TroopManageBaseFragment) SetTroopAdminsActivity.this).D.getTroopManageRemoteHandler().f(troopMemberNickUIInfo.getUin()));
                    gVar2.C.setText(troopMemberNickUIInfo.getShowName());
                    gVar2.E.setTag(Integer.valueOf(i3));
                    gVar2.D.setTag(Integer.valueOf(i3));
                    ImageView imageView = gVar2.f302899m;
                    if (SetTroopAdminsActivity.this.mi(troopMemberNickUIInfo.getUin()).booleanValue()) {
                        i16 = 0;
                    } else {
                        i16 = 8;
                    }
                    imageView.setVisibility(i16);
                    if (SetTroopAdminsActivity.this.X) {
                        gVar2.D.setVisibility(0);
                        gVar2.F.setOnClickListener(SetTroopAdminsActivity.this.f302882e0);
                        gVar2.F.setClickable(true);
                        if (SetTroopAdminsActivity.this.f302881d0.contains(troopMemberNickUIInfo.getUin())) {
                            gVar2.F.b(false);
                        } else {
                            gVar2.F.c(false);
                        }
                    } else {
                        gVar2.D.setVisibility(8);
                        gVar2.F.c(false);
                        gVar2.F.setOnClickListener(null);
                        gVar2.F.setClickable(false);
                    }
                    if (c()) {
                        d(SetTroopAdminsActivity.this.getQBaseActivity(), view2, i3, new Object[]{new Integer[]{0}, new String[]{troopMemberNickUIInfo.getUin(), troopMemberNickUIInfo.getShowName()}}, gVar2, this);
                    }
                    Boolean bool = (Boolean) SetTroopAdminsActivity.this.T.get(troopMemberNickUIInfo.getUin());
                    if (bool == null) {
                        gVar2.G.setVisibility(8);
                    } else {
                        TextView textView = gVar2.G;
                        if (bool.booleanValue()) {
                            qqStr = HardCodeUtil.qqStr(R.string.eti);
                        } else {
                            qqStr = HardCodeUtil.qqStr(R.string.f171407es4);
                        }
                        textView.setText(qqStr);
                        gVar2.G.setVisibility(0);
                    }
                    gVar2.H.setVisibility(0);
                }
                if (i3 == 0) {
                    qUIListItemBackgroundType = QUIListItemBackgroundType.TopRound;
                } else {
                    qUIListItemBackgroundType = QUIListItemBackgroundType.NoneRound;
                }
                view2.setBackground(qUIListItemBackgroundType.getBackground(view2.getContext(), 1000));
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // com.tencent.widget.SwipListView.SwipListListener
        public void hideMenuPop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            }
        }

        @Override // com.tencent.widget.SwipListView.SwipListListener
        public void interceptTouchEvent(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, z16);
            }
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                com.tencent.mobileqq.troopmanage.base.b.f(SetTroopAdminsActivity.this.R);
                super.notifyDataSetChanged();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TroopMemberNickUIInfo ji5;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
            } else {
                Object tag = view.getTag();
                if (tag instanceof String[]) {
                    String[] strArr = (String[]) tag;
                    if (strArr.length == 2) {
                        String str = strArr[0];
                        if (view.getId() == R.id.k27 && (ji5 = SetTroopAdminsActivity.this.ji(str)) != null) {
                            if (SetTroopAdminsActivity.this.mi(ji5.getUin()).booleanValue()) {
                                SetTroopAdminsActivity.this.fi(ji5);
                            } else {
                                SetTroopAdminsActivity.this.gi(ji5);
                            }
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.widget.SwipListView.SwipListListener
        public void updateCurShowRightView(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
                return;
            }
            int i3 = -1;
            if (view != null) {
                Object tag = view.getTag(-1);
                if (tag instanceof Integer) {
                    i3 = ((Integer) tag).intValue();
                }
            }
            this.f302891d = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class g extends com.tencent.mobileqq.adapter.k {
        static IPatchRedirector $redirector_;
        public TextView C;
        public View D;
        public View E;
        public TroopMemberListSlideItem F;
        public TextView G;
        public View H;

        /* renamed from: i, reason: collision with root package name */
        public QQProAvatarView f302898i;

        /* renamed from: m, reason: collision with root package name */
        public ImageView f302899m;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public SetTroopAdminsActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.R = new ArrayList<>();
        this.S = new HashMap<>();
        this.T = new HashMap();
        this.W = 0;
        this.X = false;
        this.f302878a0 = 0L;
        this.f302880c0 = new b();
        this.f302881d0 = new HashSet<>();
        this.f302882e0 = new c();
        this.f302883f0 = new d();
        this.f302884g0 = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
    
        if (r0 != r2) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void Ai(final String str, ActionSheet actionSheet, View view, final int i3) {
        boolean z16;
        boolean z17;
        if (i3 == 0 || i3 == 1) {
            Boolean bool = this.T.get(str);
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                if (i3 == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            ITroopOperationRepoApi iTroopOperationRepoApi = (ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class);
            String str2 = this.P;
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            iTroopOperationRepoApi.setAdminCanRcvJoinMsg(str2, str, z16, this, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troopmanage.activity.o
                @Override // com.tencent.qqnt.troop.e
                public final void onResult(boolean z18, int i16, String str3) {
                    SetTroopAdminsActivity.this.zi(str, i3, z18, i16, str3);
                }
            });
            startTitleProgress();
        }
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bi(String str) {
        qh(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Ci(Boolean bool, final String str, Map map) {
        if (QLog.isColorLevel()) {
            QLog.d("SetTroopAdminsActivity", 2, "onGetRcvJoinMsgMgrs isSuccess = " + bool);
        }
        if (bool.booleanValue()) {
            this.f302883f0.obtainMessage(3, map).sendToTarget();
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SetTroopAdminsActivity", 2, "onGetRcvJoinMsgMgrs error! + mTroopUin = " + this.P);
        }
        this.f302883f0.post(new Runnable() { // from class: com.tencent.mobileqq.troopmanage.activity.d
            @Override // java.lang.Runnable
            public final void run() {
                SetTroopAdminsActivity.this.Bi(str);
            }
        });
        return null;
    }

    private void Di(boolean z16, final List<TroopMemberInfo> list, final boolean z17) {
        if (z16) {
            if (z17) {
                getContext().getSharedPreferences(DeviceProfileManager.KEY_LAST_UPDATE_TIME + this.C.getAccount(), 4).edit().putLong("key_last_update_time" + this.P, System.currentTimeMillis()).commit();
                this.f302883f0.removeMessages(2);
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troopmanage.activity.g
                @Override // java.lang.Runnable
                public final void run() {
                    SetTroopAdminsActivity.this.yi(list, z17);
                }
            }, 16, null, true);
            return;
        }
        if (z17) {
            hi(false);
            return;
        }
        Handler handler = this.f302883f0;
        handler.sendMessage(handler.obtainMessage(2, new ArrayList()));
        Li();
    }

    private void Ei(boolean z16, int i3) {
        if (z16 && i3 > 0) {
            this.W = i3;
            this.J.setText(HardCodeUtil.qqStr(R.string.c7d) + "(" + this.R.size() + "/" + i3 + ")");
        }
    }

    private void Gi(boolean z16, String str, boolean z17) {
        stopTitleProgress();
        if (z16) {
            if (str != null) {
                this.T.put(str, Boolean.valueOf(z17));
                if (str.equals(this.C.getAccount())) {
                    Oi();
                    return;
                } else {
                    this.N.notifyDataSetChanged();
                    return;
                }
            }
            return;
        }
        this.f302879b0.D.setImageResource(R.drawable.bsz);
        this.f302879b0.E.setText(HardCodeUtil.qqStr(R.string.tca));
        this.f302879b0.O();
    }

    private void Hi(byte b16, String str, String str2) {
        this.Z.putExtra("command", 0);
        this.Z.putExtra(QCircleDaTongConstant.ElementParamValue.OPERATION, b16);
        this.Z.putExtra(AppConstants.Key.TROOP_CODE, str);
        this.Z.putExtra("troop_member_uin", str2);
        this.C.startServlet(this.Z);
    }

    private void Ji(final String str) {
        int i3;
        final ActionSheet create = ActionSheet.create(getContext(), -1, null, true);
        if (QQTheme.isNowThemeIsNight()) {
            i3 = 10;
        } else {
            i3 = 0;
        }
        Boolean bool = this.T.get(str);
        if (this.Q.isTroopOwner(str)) {
            create.addRadioButton(R.string.evw, i3, Boolean.TRUE.equals(bool));
            create.addRadioButton(R.string.es5, i3, Boolean.FALSE.equals(bool));
        } else {
            create.addRadioButton(R.string.eti, i3, Boolean.TRUE.equals(bool));
            create.addRadioButton(R.string.f171407es4, i3, Boolean.FALSE.equals(bool));
        }
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.n
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i16) {
                SetTroopAdminsActivity.this.Ai(str, create, view, i16);
            }
        });
        create.show();
    }

    private void Ki(boolean z16) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (z16) {
            this.L.setTextColor(ContextCompat.getColor(context, R.color.qui_common_text_secondary));
            this.M.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.kcl));
        } else {
            this.L.setTextColor(ContextCompat.getColor(context, R.color.qui_common_text_primary));
            this.M.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.qui_add_circle));
        }
    }

    private void Li() {
        ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchTroopAdminFlagEx(this.P, this, new Function3() { // from class: com.tencent.mobileqq.troopmanage.activity.c
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit Ci;
                Ci = SetTroopAdminsActivity.this.Ci((Boolean) obj, (String) obj2, (Map) obj3);
                return Ci;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mi() {
        QUIListItemBackgroundType qUIListItemBackgroundType;
        View view = this.G;
        if (view != null) {
            view.setBackground(QUIListItemBackgroundType.AllRound.getBackground(view.getContext(), 1000));
        }
        if (this.K != null) {
            if (this.R.size() > 0) {
                qUIListItemBackgroundType = QUIListItemBackgroundType.BottomRound;
            } else {
                qUIListItemBackgroundType = QUIListItemBackgroundType.AllRound;
            }
            View view2 = this.K;
            view2.setBackground(qUIListItemBackgroundType.getBackground(view2.getContext(), 1000));
        }
    }

    private void Oi() {
        String qqStr;
        if (this.I != null) {
            Boolean bool = this.T.get(this.C.getAccount());
            if (bool == null) {
                this.I.setVisibility(8);
                return;
            }
            TextView textView = this.I;
            if (bool.booleanValue()) {
                qqStr = HardCodeUtil.qqStr(R.string.evw);
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.es5);
            }
            textView.setText(qqStr);
            this.I.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pi(Map<String, Integer> map) {
        boolean z16;
        Boolean valueOf;
        this.T.clear();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Map<String, Boolean> map2 = this.T;
            String key = entry.getKey();
            if (mi(entry.getKey()).booleanValue()) {
                valueOf = null;
            } else {
                if ((entry.getValue().intValue() & 64) == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                valueOf = Boolean.valueOf(z16);
            }
            map2.put(key, valueOf);
        }
        Oi();
        this.N.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(final TroopMemberNickUIInfo troopMemberNickUIInfo) {
        ((ITroopIntelligentManageApi) QRoute.api(ITroopIntelligentManageApi.class)).getCancelAdminTips(this.P, troopMemberNickUIInfo.getUin(), new ITroopIntelligentManageApi.c() { // from class: com.tencent.mobileqq.troopmanage.activity.l
            @Override // com.tencent.mobileqq.troop.troopmanager.api.ITroopIntelligentManageApi.c
            public final void a(boolean z16, boolean z17, String str) {
                SetTroopAdminsActivity.this.oi(troopMemberNickUIInfo, z16, z17, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi(TroopMemberNickUIInfo troopMemberNickUIInfo) {
        showProgressDialog(R.string.aks);
        this.S.put(troopMemberNickUIInfo.getUin(), troopMemberNickUIInfo);
        Hi((byte) 0, this.P, troopMemberNickUIInfo.getUin());
    }

    private void hi(final boolean z16) {
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(this.P, this, z16, "SetTroopAdminsActivity", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.troopmanage.activity.p
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z17, List list) {
                SetTroopAdminsActivity.this.xi(z16, z17, list);
            }
        });
    }

    private void ii() {
        long j3;
        boolean z16 = true;
        if (TextUtils.isEmpty(this.P)) {
            QLog.i("SetTroopAdminsActivity", 1, "[fillData] mTroopUin is empty");
            return;
        }
        Context context = getContext();
        if (context != null) {
            j3 = context.getSharedPreferences(DeviceProfileManager.KEY_LAST_UPDATE_TIME + this.C.getAccount(), 0).getLong("key_last_update_time" + this.P, 0L);
        } else {
            j3 = 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (j3 != 0 && (j3 <= 0 || Math.abs(currentTimeMillis - j3) <= MiniBoxNoticeInfo.MIN_5)) {
            z16 = false;
        }
        hi(z16);
        if (!z16) {
            Li();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TroopMemberNickUIInfo ji(String str) {
        Iterator<TroopMemberNickUIInfo> it = this.R.iterator();
        while (it.hasNext()) {
            TroopMemberNickUIInfo next = it.next();
            if (next.getUin().endsWith(str)) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean mi(String str) {
        return Boolean.valueOf(((ITroopRobotService) this.C.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ni(boolean z16, boolean z17, String str, final TroopMemberNickUIInfo troopMemberNickUIInfo) {
        if (z16 && z17) {
            DialogUtil.createCustomDialog(getQBaseActivity(), 230).setMessage(str).setNegativeButton(R.string.f170647xd, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    SetTroopAdminsActivity.pi(dialogInterface, i3);
                }
            }).setPositiveButton(R.string.f2328475n, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    SetTroopAdminsActivity.this.qi(troopMemberNickUIInfo, dialogInterface, i3);
                }
            }).show();
        } else {
            gi(troopMemberNickUIInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void oi(final TroopMemberNickUIInfo troopMemberNickUIInfo, final boolean z16, final boolean z17, final String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troopmanage.activity.b
            @Override // java.lang.Runnable
            public final void run() {
                SetTroopAdminsActivity.this.ni(z16, z17, str, troopMemberNickUIInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void qi(TroopMemberNickUIInfo troopMemberNickUIInfo, DialogInterface dialogInterface, int i3) {
        gi(troopMemberNickUIInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ri(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Ji(str);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void showProgressDialog(int i3) {
        if (!ph()) {
            showToast(HardCodeUtil.qqStr(R.string.b3j));
            return;
        }
        if (this.V == null) {
            this.V = new QQProgressDialog(getContext());
        }
        this.V.setMessage(i3);
        this.V.setOffsetY(getTitleBarHeight());
        this.V.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit si(TextView textView, TroopMemberNickInfo troopMemberNickInfo) {
        String currentNickname;
        if (troopMemberNickInfo != null) {
            currentNickname = troopMemberNickInfo.getShowName();
        } else {
            currentNickname = this.C.getCurrentNickname();
        }
        textView.setText(currentNickname);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ti(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Ji(str);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ui(final String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f302881d0.clear();
        boolean z16 = !this.X;
        this.X = z16;
        if (z16) {
            this.rightViewText.setText(R.string.b9f);
            this.K.setEnabled(false);
            View view2 = this.G;
            if (view2 != null) {
                view2.setOnClickListener(null);
            }
        } else {
            this.rightViewText.setText(R.string.f170869aw3);
            this.K.setEnabled(true);
            View view3 = this.G;
            if (view3 != null) {
                view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        SetTroopAdminsActivity.this.ti(str, view4);
                    }
                });
            }
        }
        Ki(this.X);
        f fVar = this.N;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vi(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int i3 = this.W;
        if (i3 > 0 && i3 <= this.R.size()) {
            qh(String.format(getString(R.string.i4u), Integer.valueOf(this.W)));
        } else if (System.currentTimeMillis() - this.f302878a0 >= 1500) {
            this.f302878a0 = System.currentTimeMillis();
            Intent troopMemberListActivityLaunchIntent = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMemberListActivityLaunchIntent(getContext(), this.P, 2);
            troopMemberListActivityLaunchIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
            startActivityForResult(troopMemberListActivityLaunchIntent, 0);
            this.D.reportClickEvent("P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, this.P, "3", "0", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit wi(Boolean bool, TroopInfo troopInfo) {
        Ei(bool.booleanValue(), troopInfo.maxAdminNum);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xi(boolean z16, boolean z17, List list) {
        Di(z17, new ArrayList(list), z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yi(List list, boolean z16) {
        List<TroopMemberNickUIInfo> b16 = com.tencent.mobileqq.troopmanage.base.b.b(list);
        if (z16) {
            Handler handler = this.f302883f0;
            handler.sendMessage(handler.obtainMessage(1, b16));
        } else {
            Handler handler2 = this.f302883f0;
            handler2.sendMessage(handler2.obtainMessage(2, b16));
        }
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TroopMemberInfo troopMemberInfo = (TroopMemberInfo) it.next();
            hashMap.put(troopMemberInfo.memberuin, Integer.valueOf(troopMemberInfo.flagEx));
        }
        this.f302883f0.obtainMessage(3, hashMap).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zi(String str, int i3, boolean z16, int i16, String str2) {
        boolean z17;
        if (i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        Gi(z16, str, z17);
    }

    public void Fi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("deleted_members", this.U);
        ArrayList arrayList = new ArrayList();
        Iterator<TroopMemberNickUIInfo> it = this.R.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getUin());
        }
        intent.putExtra("param_admins", arrayList);
        intent.putExtra("param_admins_count", this.R.size());
        getQBaseActivity().setResult(-1, intent);
        getQBaseActivity().finish();
        getQBaseActivity().overridePendingTransition(0, R.anim.f154423k);
    }

    protected void Ii() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (!isAdded()) {
            QLog.d("SetTroopAdminsActivity", 1, "fragment has been removed");
            return;
        }
        ITroopManageService iTroopManageService = this.D;
        if (iTroopManageService != null) {
            this.W = iTroopManageService.getTroopInfo(this.P).maxAdminNum;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.c7d);
        TextView textView = this.J;
        if (this.W > 0) {
            qqStr = qqStr + "(" + this.R.size() + "/" + this.W + ")";
        }
        textView.setText(qqStr);
    }

    public void Ni(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) str2);
        } else {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(this.P, str, true, this, str2, new a(str));
        }
    }

    public synchronized void Qi(TroopInfo troopInfo, String str, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, troopInfo, str, Byte.valueOf(b16));
        } else {
            com.tencent.mobileqq.troopmanage.base.b.g(this.D, troopInfo, str, this.P, b16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.P = arguments.getString("troop_uin");
        }
        boolean z16 = !TextUtils.isEmpty(this.P);
        ITroopManageService iTroopManageService = this.D;
        if (iTroopManageService == null) {
            z16 = false;
        } else {
            this.Q = iTroopManageService.getTroopInfo(this.P);
        }
        if (!z16) {
            getQBaseActivity().finish();
            return;
        }
        this.f302879b0 = new QQAnonymousDialog(getContext());
        setTitle(HardCodeUtil.qqStr(R.string.tc6));
        this.X = false;
        startTitleProgress();
        this.rightViewText.setText(R.string.f170869aw3);
        this.rightViewText.setVisibility(0);
        this.rightViewText.setEnabled(true);
        this.E = (PinnedDividerSwipListView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.ebs);
        final String account = this.C.getAccount();
        if (this.Q.isTroopOwner(account)) {
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.c0z, (ViewGroup) null);
            this.F = textView;
            textView.setText(getString(R.string.i8r));
            this.E.addHeaderView(this.F);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f169142c12, (ViewGroup) null);
            this.G = inflate;
            inflate.setLayoutParams(new AbsListView.LayoutParams(-1, UIUtils.b(getContext(), 56.0f)));
            this.E.addHeaderView(this.G);
            this.G.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SetTroopAdminsActivity.this.ri(account, view);
                }
            });
            QQProAvatarView qQProAvatarView = (QQProAvatarView) this.G.findViewById(R.id.dv9);
            this.H = qQProAvatarView;
            qQProAvatarView.setImageBitmap(this.D.getTroopManageRemoteHandler().f(account));
            final TextView textView2 = (TextView) this.G.findViewById(R.id.tv_name);
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(this.P, account, "SetTroopAdminsActivity", new Function1() { // from class: com.tencent.mobileqq.troopmanage.activity.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit si5;
                    si5 = SetTroopAdminsActivity.this.si(textView2, (TroopMemberNickInfo) obj);
                    return si5;
                }
            });
            this.I = (TextView) this.G.findViewById(R.id.k_u);
        }
        TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.c0z, (ViewGroup) null);
        this.J = textView3;
        this.E.addHeaderView(textView3);
        View inflate2 = getLayoutInflater().inflate(R.layout.f169140c10, (ViewGroup) this.E, false);
        this.K = inflate2;
        this.L = (QUITextView) inflate2.findViewById(R.id.f164005gt);
        this.M = (QUIImageView) this.K.findViewById(R.id.f164004gs);
        this.E.addFooterView(this.K);
        this.E.setDividerHeight(0);
        this.E.setOnItemClickListener(this);
        this.E.setDragEnable(true);
        f fVar = new f();
        this.N = fVar;
        this.E.setAdapter((ListAdapter) fVar);
        this.rightViewText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetTroopAdminsActivity.this.ui(account, view);
            }
        });
        this.K.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetTroopAdminsActivity.this.vi(view);
            }
        });
        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
        this.Y = A;
        A.p();
        this.Y.f(this.f302880c0);
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), dh.class);
        this.Z = newIntent;
        newIntent.setObserver(this.f302880c0);
        ii();
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            this.W = arguments2.getInt("maxAdminNum", 0);
        }
        if (this.W > 0) {
            this.J.setText(getString(R.string.c7d) + "(" + this.R.size() + "/" + this.W + ")");
        }
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopMaxAdminNum(this.P, true, "SetTroopAdminsActivity", this, new Function2() { // from class: com.tencent.mobileqq.troopmanage.activity.k
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit wi5;
                wi5 = SetTroopAdminsActivity.this.wi((Boolean) obj, (TroopInfo) obj2);
                return wi5;
            }
        });
        this.D.getTroopManageRemoteHandler().e(this.f302884g0);
        Mi();
    }

    public String ei(ArrayList<TroopMemberNickUIInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, (Object) arrayList);
        }
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                sb5.append(arrayList.get(i3).getUin());
                sb5.append("(");
                sb5.append(arrayList.get(i3).getShowName());
                sb5.append(")|");
            }
            return sb5.toString();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.bys;
    }

    protected g ki(String str) {
        g gVar;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (g) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        int childCount = this.E.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.E.getChildAt(i3);
            if (childAt.getTag() != null && (childAt.getTag() instanceof g) && (str2 = (gVar = (g) childAt.getTag()).f187210d) != null && str2.equals(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("SetTroopAdminsActivity", 2, "findListItemHolderByUin:" + i3);
                }
                return gVar;
            }
        }
        return null;
    }

    public void li(String str, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Byte.valueOf(b16));
            return;
        }
        Qi(this.Q, str, b16);
        if (b16 == 0) {
            int size = this.R.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (this.R.get(size).getUin().equals(str)) {
                        this.S.put(str, this.R.get(size));
                        this.R.remove(size);
                        if (QLog.isColorLevel()) {
                            QLog.d("SetTroopAdminsActivity", 2, "handleSetTroopAdminSuccess: unsetAdmin Uin=" + str + ", admins=" + ei(this.R));
                        }
                    } else {
                        size--;
                    }
                } else {
                    str = null;
                    break;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                Ni(str, "unset-admin");
            }
        } else if (b16 == 1 && this.S.get(str) != null) {
            if (!this.R.contains(this.S.get(str))) {
                this.R.add(this.S.get(str));
            }
            this.S.remove(str);
            if (QLog.isColorLevel()) {
                QLog.d("SetTroopAdminsActivity", 2, "handleSetTroopAdminSuccess: setAdmin Uin=" + str + ", admins=" + ei(this.R));
            }
            Li();
            if (!TextUtils.isEmpty(str)) {
                Ni(str, "set-admin");
            }
        } else if (b16 == 2) {
            this.S.remove(str);
            int size2 = this.R.size() - 1;
            while (true) {
                if (size2 < 0) {
                    break;
                }
                if (this.R.get(size2).getUin().equals(str)) {
                    this.R.remove(size2);
                    break;
                }
                size2--;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SetTroopAdminsActivity", 2, "handleSetTroopAdminSuccess: adminDeled=" + str + ", admins=" + ei(this.R));
            }
        }
        this.N.notifyDataSetChanged();
        Mi();
        Ii();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 == -1 && i3 == 0 && intent != null) {
            String stringExtra = intent.getStringExtra("troop_uin");
            String stringExtra2 = intent.getStringExtra("member_uin");
            this.S.put(stringExtra2, (TroopMemberNickUIInfo) intent.getParcelableExtra("member_info"));
            showProgressDialog(R.string.h_);
            Hi((byte) 1, stringExtra, stringExtra2);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        Fi();
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.biz.troop.b bVar = this.Y;
        if (bVar != null) {
            bVar.q();
            this.Y.n0(this.f302880c0);
        }
        NewIntent newIntent = this.Z;
        if (newIntent != null) {
            newIntent.setObserver(null);
            this.Z = null;
        }
        this.D.getTroopManageRemoteHandler().i(this.f302884g0);
        super.onDestroy();
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        int headerViewsCount = i3 - this.E.getHeaderViewsCount();
        if (headerViewsCount >= 0 && headerViewsCount < this.N.getCount()) {
            TroopMemberNickUIInfo troopMemberNickUIInfo = (TroopMemberNickUIInfo) this.N.getItem(headerViewsCount);
            if (troopMemberNickUIInfo != null && troopMemberNickUIInfo.getUin() != null && troopMemberNickUIInfo.getUin().length() > 0) {
                str = troopMemberNickUIInfo.getUin();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0 && !mi(str).booleanValue()) {
                Ji(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void pi(DialogInterface dialogInterface, int i3) {
    }
}
