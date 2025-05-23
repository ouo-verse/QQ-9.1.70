package com.tencent.mobileqq.utils;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendFaceApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cw extends QQCustomDialog {
    RelativeLayout C;
    TextView D;
    RelativeLayout E;
    RelativeLayout F;
    private boolean G;
    ViewGroup H;
    View I;
    int J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f307562d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f307563e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f307564f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f307565h;

        a(QQAppInterface qQAppInterface, String str, String str2, int i3) {
            this.f307562d = qQAppInterface;
            this.f307563e = str;
            this.f307564f = str2;
            this.f307565h = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ReportController.o(this.f307562d, "CliOper", "", "", "0X8009BE7", "0X8009BE7", 1, 0, "", "", "", "");
            cw.this.hideSoftInputFromWindow();
            ForwardPreviewTroopMemberController forwardPreviewTroopMemberController = new ForwardPreviewTroopMemberController(cw.this);
            forwardPreviewTroopMemberController.q(this.f307562d, this.f307563e, this.f307564f, this.f307565h);
            cw.this.addPreviewView(forwardPreviewTroopMemberController.c());
            ReportController.o(this.f307562d, "CliOper", "", "", "0X8009AAD", "0X8009AAD", 0, 0, "", "", "", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f307567d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f307568e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f307569f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f307570h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f307571i;

        b(int i3, QQAppInterface qQAppInterface, Activity activity, String str, String str2) {
            this.f307567d = i3;
            this.f307568e = qQAppInterface;
            this.f307569f = activity;
            this.f307570h = str;
            this.f307571i = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long j3;
            EventCollector.getInstance().onViewClickedBefore(view);
            long currentTimeMillis = System.currentTimeMillis();
            Object tag = view.getTag();
            if (tag instanceof Long) {
                j3 = ((Long) tag).longValue();
            } else {
                j3 = 0;
            }
            if (currentTimeMillis - j3 < 300) {
                QLog.i("QQCustomDialogWithForwardAvatar", 2, "click in 300ms clickTime: " + j3 + " newTime :" + currentTimeMillis);
            } else {
                view.setTag(Long.valueOf(currentTimeMillis));
                int i3 = this.f307567d;
                if (i3 != 1 && i3 != 3000) {
                    ReportController.o(this.f307568e, "CliOper", "", "", "0X8009BE6", "0X8009BE6", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(this.f307568e, "CliOper", "", "", "0X8009BE8", "0X8009BE8", 0, 0, "", "", "", "");
                }
                cw.this.S();
                MiniChatActivity.V2(this.f307569f, this.f307567d, this.f307570h, this.f307571i, cw.this.G);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f307573d;

        c(Activity activity) {
            this.f307573d = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ResultRecord resultRecord = (ResultRecord) view.getTag();
            if (resultRecord.uinType != 10014) {
                cw.this.hideSoftInputFromWindow();
                MiniChatActivity.V2(this.f307573d, resultRecord.getUinType(), resultRecord.uin, resultRecord.name, cw.this.G);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private Context f307576d;

        /* renamed from: e, reason: collision with root package name */
        private QQAppInterface f307577e;

        /* renamed from: f, reason: collision with root package name */
        private List<ResultRecord> f307578f;

        /* renamed from: h, reason: collision with root package name */
        private View.OnClickListener f307579h;

        public e(QQAppInterface qQAppInterface, Context context, List<ResultRecord> list, View.OnClickListener onClickListener) {
            this.f307577e = qQAppInterface;
            this.f307576d = context;
            this.f307579h = onClickListener;
            this.f307578f = list;
        }

        private int a(int i3) {
            if (i3 == 1) {
                return 4;
            }
            if (i3 == 3000) {
                return 101;
            }
            if (i3 == 1006) {
                return 11;
            }
            if (i3 == 10014) {
                return 117;
            }
            if (i3 != 1046) {
                return 1;
            }
            return 202;
        }

        private View.OnClickListener b(ResultRecord resultRecord) {
            if (resultRecord.getUinType() == 10008) {
                return null;
            }
            return this.f307579h;
        }

        private void d(ImageView imageView, ResultRecord resultRecord) {
            Drawable avatarDrawable;
            AccessibilityUtil.c(imageView, resultRecord.name, null);
            if (AppConstants.DATALINE_PC_UIN.equals(resultRecord.uin)) {
                imageView.setImageResource(R.drawable.qfile_dataline_pc_recent);
                return;
            }
            if (AppConstants.DATALINE_IPAD_UIN.equals(resultRecord.uin)) {
                imageView.setImageResource(R.drawable.qfile_dataline_ipad_recent);
                return;
            }
            if (AppConstants.DATALINE_PHONE_UIN.equals(resultRecord.uin)) {
                imageView.setImageResource(R.drawable.qfile_dataline_user_aio);
                return;
            }
            if (AppConstants.DATALINE_PRINTER_UIN.equals(resultRecord.uin)) {
                imageView.setImageResource(R.drawable.qfile_dataline_printer_recent);
                return;
            }
            if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(resultRecord.uin)) {
                imageView.setImageResource(R.drawable.device_search_icon);
                return;
            }
            int a16 = a(resultRecord.getUinType());
            if (a16 == 117) {
                if (!TextUtils.isEmpty(resultRecord.guildAvatarUrl)) {
                    avatarDrawable = ((IQQGuildAvatarApi) this.f307577e.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(resultRecord.guildAvatarUrl, 100, 100, (String) null);
                } else {
                    avatarDrawable = ((IQQGuildService) this.f307577e.getRuntimeService(IQQGuildService.class, "")).getAvatarDrawable(resultRecord.guildId, 100, null, true);
                }
                imageView.setImageDrawable(avatarDrawable);
                return;
            }
            if (a16 == 202) {
                imageView.setImageDrawable(((IMatchFriendFaceApi) QRoute.api(IMatchFriendFaceApi.class)).getMatchFriendFaceDrawable(this.f307577e, Long.parseLong(resultRecord.uin)));
            } else {
                imageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.f307577e, a16, resultRecord.uin));
            }
        }

        @Override // android.widget.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public ResultRecord getItem(int i3) {
            if (i3 >= getCount()) {
                return new ResultRecord();
            }
            return this.f307578f.get(i3);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<ResultRecord> list = this.f307578f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            ImageView imageView;
            if (view == null) {
                imageView = new ImageView(this.f307576d);
                int i16 = cw.this.J;
                imageView.setLayoutParams(new AbsListView.LayoutParams(i16, i16));
            } else {
                imageView = (ImageView) view;
            }
            d(imageView, getItem(i3));
            imageView.setTag(getItem(i3));
            imageView.setOnClickListener(b(getItem(i3)));
            imageView.setFocusable(false);
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return imageView;
        }
    }

    public cw(Context context, int i3) {
        super(context, i3);
        this.J = BaseAIOUtils.f(35.0f, context.getResources());
    }

    private void Q() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.type = 1000;
        layoutParams.flags = 1544;
        layoutParams.token = this.rootView.getWindowToken();
        View view = this.I;
        if (view == null) {
            View view2 = new View(getContext());
            this.I = view2;
            view2.setBackgroundColor(Color.parseColor("#80000000"));
        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.I);
            }
        }
        ViewGroup viewGroup2 = this.H;
        if (viewGroup2 != null) {
            viewGroup2.addView(this.I, layoutParams);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.utils.cv
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                cw.this.U(valueAnimator);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.I;
        if (view != null) {
            view.setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.I;
        if (view != null) {
            view.setAlpha(floatValue);
        }
    }

    private void Y() {
        if (this.I != null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.utils.cu
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    cw.this.W(valueAnimator);
                }
            });
            ofFloat.addListener(new d());
            ofFloat.start();
        }
    }

    public void R() {
        RelativeLayout relativeLayout = this.F;
        if (relativeLayout == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) relativeLayout.getLayoutParams();
        marginLayoutParams.topMargin = BaseAIOUtils.f(2.0f, getContext().getResources());
        this.F.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S() {
        hideSoftInputFromWindow();
    }

    public boolean X() {
        return this.G;
    }

    public void Z(String str) {
        this.title.setVisibility(8);
        this.C.setVisibility(0);
        ((TextView) this.C.findViewById(R.id.kfr)).setText(str);
    }

    public void a0(QQAppInterface qQAppInterface, Activity activity, String str, int i3, String str2, boolean z16) {
        FaceDrawable faceDrawable;
        QLog.i("Forward.Dialog", 1, "uin: " + str + " uinType: " + i3);
        this.C.setVisibility(0);
        this.title.setVisibility(8);
        this.F.setVisibility(8);
        this.E.setVisibility(0);
        this.D.setText(str2);
        ImageView imageView = (ImageView) this.C.findViewById(R.id.dic);
        AccessibilityUtil.c(imageView, HardCodeUtil.qqStr(R.string.f13570026), null);
        RelativeLayout relativeLayout = (RelativeLayout) this.C.findViewById(R.id.jou);
        ImageView imageView2 = (ImageView) this.C.findViewById(R.id.dia);
        a aVar = new a(qQAppInterface, str2, str, i3);
        b bVar = new b(i3, qQAppInterface, activity, str, str2);
        if (i3 != 0 && i3 != 1000) {
            if (i3 == 1) {
                if (z16) {
                    faceDrawable = FaceDrawable.getFaceDrawable(qQAppInterface, 113, str);
                } else {
                    faceDrawable = FaceDrawable.getFaceDrawable(qQAppInterface, 4, str);
                }
                imageView.setImageDrawable(faceDrawable);
                imageView.setOnClickListener(aVar);
                relativeLayout.setOnClickListener(bVar);
                SimpleModeHelper.q(relativeLayout);
                return;
            }
            if (i3 == 3000) {
                imageView.setImageDrawable(FaceDrawable.getFaceDrawable(qQAppInterface, 101, str));
                imageView.setOnClickListener(aVar);
                relativeLayout.setOnClickListener(bVar);
                SimpleModeHelper.q(relativeLayout);
                return;
            }
            if (i3 == 1006) {
                imageView.setImageDrawable(FaceDrawable.getFaceDrawable(qQAppInterface, 11, str));
                this.E.setOnClickListener(bVar);
                SimpleModeHelper.q(this.E);
                return;
            }
            if (i3 == 10014) {
                imageView.setImageDrawable(((IQQGuildService) qQAppInterface.getRuntimeService(IQQGuildService.class, "")).getAvatarDrawable(str, 100, null, true));
                imageView2.setVisibility(8);
                this.E.setBackgroundResource(R.color.ajr);
                return;
            }
            if (AppConstants.DATALINE_PC_UIN.equals(str)) {
                imageView.setImageResource(R.drawable.qfile_dataline_pc_recent);
                imageView.setOnClickListener(aVar);
                this.E.setOnClickListener(bVar);
                SimpleModeHelper.q(this.E);
                return;
            }
            if (AppConstants.DATALINE_PHONE_UIN.equals(str)) {
                imageView.setImageResource(R.drawable.qfile_dataline_user_aio);
                imageView.setOnClickListener(aVar);
                this.E.setOnClickListener(bVar);
                SimpleModeHelper.q(this.E);
                return;
            }
            if (AppConstants.DATALINE_IPAD_UIN.equals(str)) {
                imageView.setImageResource(R.drawable.qfile_dataline_ipad_recent);
                imageView.setOnClickListener(aVar);
                this.E.setOnClickListener(bVar);
                SimpleModeHelper.q(this.E);
                return;
            }
            if (i3 == 1046) {
                imageView.setImageDrawable(((IMatchFriendFaceApi) QRoute.api(IMatchFriendFaceApi.class)).getMatchFriendFaceDrawable(qQAppInterface, Long.parseLong(str)));
                imageView2.setVisibility(8);
                this.E.setBackgroundResource(R.color.ajr);
                return;
            } else if (i3 == 10008) {
                imageView.setImageDrawable(HostFaceUtils.getHeadDrawable(str));
                imageView2.setVisibility(8);
                this.E.setBackgroundResource(R.color.ajr);
                return;
            } else {
                imageView2.setVisibility(8);
                imageView.setImageDrawable(FaceDrawable.getDefaultDrawable(1, 3));
                return;
            }
        }
        imageView.setImageDrawable(FaceDrawable.getFaceDrawable(qQAppInterface, 1, str));
        this.E.setOnClickListener(bVar);
        SimpleModeHelper.q(this.E);
    }

    @TargetApi(16)
    public void b0(QQAppInterface qQAppInterface, Activity activity, List<ResultRecord> list, boolean z16) {
        c cVar;
        this.C.setVisibility(0);
        this.F.setVisibility(0);
        this.title.setVisibility(8);
        this.E.setVisibility(8);
        ((TextView) this.C.findViewById(R.id.kfr)).setText(HardCodeUtil.qqStr(R.string.l5w));
        GridView gridView = (GridView) this.C.findViewById(R.id.d06);
        gridView.setNumColumns(5);
        gridView.setHorizontalSpacing((BaseAIOUtils.f(236.0f, getContext().getResources()) - (this.J * 5)) / 5);
        gridView.setVerticalSpacing(BaseAIOUtils.f(10.0f, getContext().getResources()));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) gridView.getLayoutParams();
        int verticalSpacing = gridView.getVerticalSpacing();
        if (list.size() <= 5) {
            layoutParams.height = this.J;
        } else {
            layoutParams.height = (this.J * 2) + verticalSpacing;
        }
        gridView.setLayoutParams(layoutParams);
        gridView.setFocusable(false);
        if (z16) {
            cVar = new c(activity);
        } else {
            cVar = null;
        }
        gridView.setAdapter((ListAdapter) new e(qQAppInterface, getContext(), list, cVar));
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (hasPreViewInDialog()) {
            removePreviewView();
            return;
        }
        super.dismiss();
        if (this.G) {
            Y();
        }
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog, android.app.Dialog
    @TargetApi(11)
    public void setContentView(int i3) {
        Activity activity;
        super.setContentView(i3);
        this.G = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("dialog_with_forward_avatar_mask_view_bugfix", true);
        QLog.i("QQCustomDialogWithForwardAvatar", 1, "maskViewBugfix: " + this.G);
        if (Foreground.getTopActivity() != null) {
            activity = Foreground.getTopActivity();
        } else {
            activity = QBaseActivity.sTopActivity;
        }
        if (activity == null || activity.getClass() != ForwardRecentActivity.class) {
            this.G = false;
            QLog.i("QQCustomDialogWithForwardAvatar", 1, "is not ForwardRecentActivity, maskViewBugfix: false");
        }
        if (this.G && getWindow() != null) {
            if (activity != null) {
                this.H = (ViewGroup) activity.getWindow().getDecorView();
            }
            getWindow().setDimAmount(0.0f);
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.idy);
        this.C = relativeLayout;
        this.D = (TextView) relativeLayout.findViewById(R.id.kfu);
        this.E = (RelativeLayout) this.C.findViewById(R.id.d3x);
        this.F = (RelativeLayout) this.C.findViewById(R.id.d3y);
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        if (this.G) {
            Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d extends com.tencent.mobileqq.widget.f {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            ViewGroup viewGroup;
            super.onAnimationEnd(animator, z16);
            cw cwVar = cw.this;
            View view = cwVar.I;
            if (view != null && (viewGroup = cwVar.H) != null) {
                viewGroup.removeView(view);
                cw.this.I = null;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
