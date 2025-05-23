package com.tencent.av.ui.part.invite;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.m;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.ad;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import mw.m;

/* loaded from: classes32.dex */
public class VideoRefuseMsgReplyPart extends Part {
    int C;

    /* renamed from: d, reason: collision with root package name */
    private Button f76401d = null;

    /* renamed from: e, reason: collision with root package name */
    private boolean f76402e;

    /* renamed from: f, reason: collision with root package name */
    m f76403f;

    /* renamed from: h, reason: collision with root package name */
    int f76404h;

    /* renamed from: i, reason: collision with root package name */
    boolean f76405i;

    /* renamed from: m, reason: collision with root package name */
    int f76406m;

    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            VideoRefuseMsgReplyPart videoRefuseMsgReplyPart = VideoRefuseMsgReplyPart.this;
            videoRefuseMsgReplyPart.f76404h = ad.f(videoRefuseMsgReplyPart.getContext());
            VideoRefuseMsgReplyPart videoRefuseMsgReplyPart2 = VideoRefuseMsgReplyPart.this;
            videoRefuseMsgReplyPart2.f76405i = videoRefuseMsgReplyPart2.F9();
            VideoRefuseMsgReplyPart videoRefuseMsgReplyPart3 = VideoRefuseMsgReplyPart.this;
            m mVar = videoRefuseMsgReplyPart3.f76403f;
            if (mVar == null) {
                QLog.e("AVInviteVipFunVideoPart", 1, "[onClick] get ioc error.");
                return;
            }
            videoRefuseMsgReplyPart3.f76406m = mVar.getOnlineStatus();
            VideoRefuseMsgReplyPart videoRefuseMsgReplyPart4 = VideoRefuseMsgReplyPart.this;
            videoRefuseMsgReplyPart4.C = videoRefuseMsgReplyPart4.f76403f.a();
            VideoRefuseMsgReplyPart.this.H9(QQAudioHelper.b(), VideoRefuseMsgReplyPart.this.getContext(), VideoRefuseMsgReplyPart.this.f76402e);
            if (!VideoRefuseMsgReplyPart.this.f76403f.c()) {
                if (VideoRefuseMsgReplyPart.this.F9()) {
                    if (VideoRefuseMsgReplyPart.this.f76402e) {
                        str = "0X800439F";
                    } else {
                        str = "0X80043A5";
                    }
                } else if (VideoRefuseMsgReplyPart.this.f76402e) {
                    str = "0X80043B1";
                } else {
                    str = "0X80043AB";
                }
            } else {
                str = "0X8005200";
            }
            String str2 = str;
            ReportController.o(null, "CliOper", "", "", str2, str2, 0, 0, Integer.toString(VideoRefuseMsgReplyPart.this.f76406m), Integer.toString(VideoRefuseMsgReplyPart.this.f76404h), Integer.toString(VideoRefuseMsgReplyPart.this.C), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements ActionSheet.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f76413d;

        b(boolean z16) {
            this.f76413d = z16;
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            String str;
            boolean F9 = VideoRefuseMsgReplyPart.this.F9();
            if (this.f76413d) {
                if (F9) {
                    str = "0X80043A4";
                } else {
                    str = "0X80043B6";
                }
            } else if (F9) {
                str = "0X80043AA";
            } else {
                str = "0X80043B0";
            }
            String str2 = str;
            DataReport.T(null, "CliOper", "", "", str2, str2, 0, 0, Integer.toString(VideoRefuseMsgReplyPart.this.f76403f.getOnlineStatus()), Integer.toString(VideoRefuseMsgReplyPart.this.f76404h), "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements Observer<Boolean> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (VideoRefuseMsgReplyPart.this.f76401d != null) {
                VideoRefuseMsgReplyPart.this.f76401d.setEnabled(!bool.booleanValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public static class d extends ActionSheet {
        public d(Context context) {
            super(context);
            super.getWindow().addFlags(524288);
            super.getWindow().addFlags(128);
            super.getWindow().addFlags(1024);
            super.getWindow().addFlags(2097152);
        }
    }

    public VideoRefuseMsgReplyPart(boolean z16) {
        this.f76402e = z16;
    }

    private boolean D9() {
        QQUtils.k(getContext());
        return true;
    }

    private ActionSheet E9(Context context) {
        d dVar = new d(context);
        if (dVar.getWindow() != null) {
            dVar.getWindow().setWindowAnimations(R.style.MenuDialogAnimation);
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F9() {
        return this.f76403f.f();
    }

    private void G9() {
        sw.a aVar = (sw.a) getViewModel(sw.a.class);
        if (aVar == null) {
            QLog.e("AVInviteVipFunVideoPart", 1, "get viewModel error.");
        } else {
            aVar.N1().observe(getPartHost().getLifecycleOwner(), new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I9() {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) getActivity().getSystemService("keyguard");
            if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
                if (keyguardManager.isKeyguardSecure()) {
                    return;
                }
            }
            getActivity().startActivity(new Intent(getActivity().getApplicationContext(), (Class<?>) QQLSUnlockActivity.class));
        } catch (SecurityException unused) {
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        if (view == null) {
            QLog.e("AVInviteVipFunVideoPart", 1, "onInitView rootView is null");
            return;
        }
        this.f76403f = (m) RFWIocAbilityProvider.g().getIocInterface(m.class, getPartRootView(), null);
        this.f76405i = F9();
        Button button = (Button) view.findViewById(m.l.f76068n);
        this.f76401d = button;
        if (button != null) {
            if (view.getResources() != null) {
                com.tencent.av.utils.e.a(view.getResources(), this.f76401d, R.drawable.d_k, R.color.f157463q4, R.color.f157463q4);
            }
            this.f76401d.setOnClickListener(new a());
            if ((this.f76403f.getSessionInfo() != null ? this.f76403f.getSessionInfo().f73067q : -1) == 9500) {
                this.f76401d.setVisibility(8);
            } else if (this.f76405i) {
                this.f76401d.setVisibility(0);
                if (this.f76402e) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f76401d.getLayoutParams();
                    layoutParams.addRule(11, -1);
                    this.f76401d.setLayoutParams(layoutParams);
                }
            }
            if (this.f76402e) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f76401d.getLayoutParams();
                layoutParams2.rightMargin = getContext().getResources().getDimensionPixelSize(R.dimen.a67);
                this.f76401d.setLayoutParams(layoutParams2);
            }
        }
        G9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        Button button = this.f76401d;
        if (button != null) {
            button.setCompoundDrawables(null, null, null, null);
            this.f76401d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H9(final long j3, Context context, final boolean z16) {
        ActionSheet create;
        if (z16) {
            create = E9(context);
        } else {
            create = ActionSheet.create(context);
        }
        create.addButton(R.string.dex);
        create.addButton(R.string.dez);
        create.addButton(R.string.dey);
        if (D9()) {
            create.addButton(R.string.dew);
        }
        create.addCancelButton(R.string.cancel);
        create.setOnDismissListener(new b(z16));
        final ActionSheet actionSheet = create;
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.av.ui.part.invite.VideoRefuseMsgReplyPart.3
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                String str;
                String string;
                VideoAppInterface b16;
                String str2;
                String str3;
                String str4;
                ActionSheet actionSheet2 = actionSheet;
                if (actionSheet2 != null) {
                    actionSheet2.dismiss();
                }
                boolean F9 = VideoRefuseMsgReplyPart.this.F9();
                int onlineStatus = VideoRefuseMsgReplyPart.this.f76403f.getOnlineStatus();
                boolean z17 = false;
                if (i3 == 0) {
                    if (z16) {
                        if (F9) {
                            str = "0X80043A0";
                        } else {
                            str = "0X80043B2";
                        }
                    } else if (F9) {
                        str = "0X80043A6";
                    } else {
                        str = "0X80043AC";
                    }
                    String str5 = str;
                    DataReport.T(null, "CliOper", "", "", str5, str5, 0, 0, Integer.toString(onlineStatus), Integer.toString(VideoRefuseMsgReplyPart.this.f76404h), Integer.toString(VideoRefuseMsgReplyPart.this.C), "");
                    string = VideoRefuseMsgReplyPart.this.getActivity().getApplicationContext().getString(R.string.dex);
                } else if (i3 == 1) {
                    if (z16) {
                        if (F9) {
                            str2 = "0X80043A1";
                        } else {
                            str2 = "0X80043B3";
                        }
                    } else if (F9) {
                        str2 = "0X80043A7";
                    } else {
                        str2 = "0X80043AD";
                    }
                    String str6 = str2;
                    DataReport.T(null, "CliOper", "", "", str6, str6, 0, 0, Integer.toString(onlineStatus), Integer.toString(VideoRefuseMsgReplyPart.this.f76404h), "", "");
                    string = VideoRefuseMsgReplyPart.this.getActivity().getApplicationContext().getString(R.string.dez);
                } else if (i3 != 2) {
                    string = null;
                    if (i3 == 3) {
                        if (z16) {
                            if (F9) {
                                str4 = "0X80043A3";
                            } else {
                                str4 = "0X80043B5";
                            }
                        } else if (F9) {
                            str4 = "0X80043A9";
                        } else {
                            str4 = "0X80043AF";
                        }
                        String str7 = str4;
                        DataReport.T(null, "CliOper", "", "", str7, str7, 0, 0, Integer.toString(onlineStatus), Integer.toString(VideoRefuseMsgReplyPart.this.f76404h), "", "");
                        z17 = true;
                    }
                } else {
                    if (z16) {
                        if (F9) {
                            str3 = "0X80043A2";
                        } else {
                            str3 = "0X80043B4";
                        }
                    } else if (F9) {
                        str3 = "0X80043A8";
                    } else {
                        str3 = "0X80043AE";
                    }
                    String str8 = str3;
                    DataReport.T(null, "CliOper", "", "", str8, str8, 0, 0, Integer.toString(onlineStatus), Integer.toString(VideoRefuseMsgReplyPart.this.f76404h), "", "");
                    string = VideoRefuseMsgReplyPart.this.getActivity().getApplicationContext().getString(R.string.dey);
                }
                VideoRefuseMsgReplyPart.this.f76403f.i(j3, string);
                if (!z17 || !QQUtils.k(VideoRefuseMsgReplyPart.this.getActivity().getApplicationContext()) || (b16 = nw.b.b()) == null || b16.M() == null) {
                    return;
                }
                b16.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.part.invite.VideoRefuseMsgReplyPart.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoRefuseMsgReplyPart.this.I9();
                    }
                }, BaseGesturePWDUtil.getJumpLock(VideoRefuseMsgReplyPart.this.getActivity().getApplicationContext(), b16.getCurrentAccountUin()) ? 500L : 0L);
            }
        });
        create.show();
    }
}
