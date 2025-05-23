package com.tencent.mobileqq.startup.task;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.multilanguage.MultiLanguageEngine;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u00018B\u0007\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/startup/task/VersionUpdateTask;", "Lcom/tencent/qqnt/startup/task/NtTask;", "Landroid/os/Handler$Callback;", "Landroid/content/Context;", "context", "", "d", "c", "", "b", TencentLocation.RUN_MODE, "Landroid/os/Message;", "msg", "", "handleMessage", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandler", "", "e", "J", "mStartTime", "f", "I", "mStartProgress", tl.h.F, "mTargetProgress", "", "i", "D", "mFakeProgress", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "mLoadingText", "Lcom/tencent/mobileqq/fragment/overview/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/fragment/overview/b;", "loadingTextAnimator", "mUpdateTime", "Landroid/view/ViewGroup;", "E", "Landroid/view/ViewGroup;", "decorView", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "loadingTv", "H", "progressTv", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class VersionUpdateTask extends NtTask implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.fragment.overview.b loadingTextAnimator;

    /* renamed from: D, reason: from kotlin metadata */
    private int mUpdateTime;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ViewGroup decorView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private LinearLayout container;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView loadingTv;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView progressTv;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Handler mHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mStartTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mStartProgress;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mTargetProgress;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private double mFakeProgress;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mLoadingText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/startup/task/VersionUpdateTask$a;", "", "", "KEY_PROC_FIRST_LAUNCH", "Ljava/lang/String;", "", "MSG_DONE", "I", "MSG_INIT", "MSG_PROGRESS", "SP_NAME", "UPDATE_TIME", "sNeedUpdateFlag", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.task.VersionUpdateTask$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61713);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public VersionUpdateTask() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int b() {
        int i3 = this.mTargetProgress;
        int i16 = this.mStartProgress;
        double currentTimeMillis = ((((System.currentTimeMillis() - this.mStartTime) * 1.0d) / this.mUpdateTime) * (i3 - i16)) + i16;
        if (currentTimeMillis < i16) {
            currentTimeMillis = i16;
        } else if (currentTimeMillis > i3 - 10) {
            double d16 = this.mFakeProgress;
            if (d16 < i3 - 10) {
                this.mFakeProgress = i3 - 10;
            } else {
                this.mFakeProgress = d16 + ((i3 - d16) / 10.0d);
            }
            currentTimeMillis = this.mFakeProgress;
        }
        return (int) currentTimeMillis;
    }

    private final void c() {
        ViewGroup viewGroup = this.decorView;
        if (viewGroup != null && this.container != null) {
            Intrinsics.checkNotNull(viewGroup);
            viewGroup.removeView(this.container);
        }
        com.tencent.mobileqq.fragment.overview.b bVar = this.loadingTextAnimator;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            bVar.d();
            this.loadingTextAnimator = null;
        }
        this.decorView = null;
        this.container = null;
        this.loadingTv = null;
        this.progressTv = null;
    }

    private final void d(Context context) {
        Object obj;
        Iterator<T> it = com.tencent.qqnt.startup.parse.d.a(new com.tencent.mobileqq.startup.update.c()).iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((com.tencent.qqnt.startup.parse.a) obj).b(), "updateStage")) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.qqnt.startup.parse.a aVar = (com.tencent.qqnt.startup.parse.a) obj;
        if (aVar != null) {
            List<com.tencent.qqnt.startup.parse.b> c16 = aVar.c();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it5 = c16.iterator();
            while (it5.hasNext()) {
                com.tencent.mobileqq.startup.update.j.f289878a.createTask(((com.tencent.qqnt.startup.parse.b) it5.next()).c()).run(context);
                arrayList.add(Unit.INSTANCE);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        AppActivity o16;
        LinearLayout linearLayout;
        TextView textView;
        ViewGroup.LayoutParams layoutParams;
        int i3;
        TextView textView2;
        int i16;
        TextPaint paint;
        TextPaint paint2;
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.i("AutoMonitor", 1, "updateMessage " + msg2);
        int i17 = msg2.what;
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 == 3) {
                    c();
                    Handler handler2 = this.mHandler;
                    if (handler2 != null) {
                        handler2.removeMessages(2);
                    }
                }
            } else {
                int b16 = b();
                TextView textView3 = this.loadingTv;
                if (textView3 != null) {
                    textView3.setText(this.mLoadingText);
                }
                TextView textView4 = this.progressTv;
                if (textView4 != null) {
                    textView4.setText(b16 + "%");
                }
                if (b16 < 99 && (handler = this.mHandler) != null) {
                    handler.sendEmptyMessageDelayed(2, 100L);
                }
            }
        } else {
            com.tencent.mobileqq.startup.director.a a16 = com.tencent.mobileqq.startup.director.a.INSTANCE.a();
            if (a16 != null && (o16 = a16.o()) != null) {
                try {
                    ViewGroup viewGroup = (ViewGroup) o16.findViewById(R.id.j0l);
                    this.decorView = viewGroup;
                    if (viewGroup != null) {
                        LayoutInflater.from(o16).inflate(R.layout.i2w, this.decorView);
                        ViewGroup viewGroup2 = this.decorView;
                        ViewGroup.LayoutParams layoutParams2 = null;
                        if (viewGroup2 != null) {
                            linearLayout = (LinearLayout) viewGroup2.findViewById(R.id.ef_);
                        } else {
                            linearLayout = null;
                        }
                        this.container = linearLayout;
                        ViewGroup viewGroup3 = this.decorView;
                        if (viewGroup3 != null) {
                            textView = (TextView) viewGroup3.findViewById(R.id.efr);
                        } else {
                            textView = null;
                        }
                        this.loadingTv = textView;
                        if (textView != null) {
                            layoutParams = textView.getLayoutParams();
                        } else {
                            layoutParams = null;
                        }
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
                        TextView textView5 = this.loadingTv;
                        if (textView5 != null && (paint2 = textView5.getPaint()) != null) {
                            i3 = (int) paint2.measureText(o16.getString(R.string.f13494004));
                        } else {
                            i3 = 0;
                        }
                        layoutParams3.width = i3;
                        TextView textView6 = this.loadingTv;
                        if (textView6 != null) {
                            textView6.setLayoutParams(layoutParams3);
                        }
                        ViewGroup viewGroup4 = this.decorView;
                        if (viewGroup4 != null) {
                            textView2 = (TextView) viewGroup4.findViewById(R.id.g2c);
                        } else {
                            textView2 = null;
                        }
                        this.progressTv = textView2;
                        if (textView2 != null) {
                            layoutParams2 = textView2.getLayoutParams();
                        }
                        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams2;
                        TextView textView7 = this.progressTv;
                        if (textView7 != null && (paint = textView7.getPaint()) != null) {
                            i16 = (int) paint.measureText(o16.getString(R.string.f13493003));
                        } else {
                            i16 = 0;
                        }
                        layoutParams4.width = i16;
                        TextView textView8 = this.progressTv;
                        if (textView8 != null) {
                            textView8.setLayoutParams(layoutParams4);
                        }
                    }
                } catch (Throwable th5) {
                    QLog.d("AutoMonitor", 1, "", th5);
                    c();
                }
                com.tencent.mobileqq.fragment.overview.b bVar = new com.tencent.mobileqq.fragment.overview.b();
                String text = o16.getString(R.string.b9i);
                Intrinsics.checkNotNullExpressionValue(text, "text");
                bVar.b(text, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.startup.task.VersionUpdateTask$handleMessage$1$1$1$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VersionUpdateTask.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull String s16) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) s16);
                        } else {
                            Intrinsics.checkNotNullParameter(s16, "s");
                            VersionUpdateTask.this.mLoadingText = s16;
                        }
                    }
                });
                this.mLoadingText = text;
                this.loadingTextAnimator = bVar;
                Handler handler3 = this.mHandler;
                if (handler3 != null) {
                    handler3.sendEmptyMessage(2);
                }
                this.mStartTime = System.currentTimeMillis();
                this.mStartProgress = 0;
                this.mTargetProgress = 99;
            }
        }
        return true;
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.mUpdateTime = 3000;
        SharedPreferences sharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("StepUpdate", 4);
        String str = "ProcFirstLaunch " + MobileQQ.processName;
        String string = sharedPreferences.getString(str, "null");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("updateVersion %s %s %s", Arrays.copyOf(new Object[]{str, string, AppSetting.l()}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.i("AutoMonitor", 1, format);
        if (!TextUtils.equals(AppSetting.l(), string)) {
            com.tencent.mobileqq.automator.a.f199911b = true;
            if (1 == MobileQQ.sProcessId) {
                com.tencent.mobileqq.perf.startup.f.d();
            }
            com.tencent.mobileqq.startup.a.f289662c = 0L;
            com.tencent.mobileqq.startup.a.f289663d = 0L;
            if (TextUtils.isEmpty(string) || Intrinsics.areEqual("null", string)) {
                com.tencent.mobileqq.automator.a.f199910a = true;
                vy3.a.f443749r = true;
            }
            Handler handler = new Handler(Looper.getMainLooper(), this);
            handler.sendEmptyMessage(1);
            this.mHandler = handler;
            d(context);
            QLog.e("AutoMonitor", 1, "UPDATE_STEPS finish");
            sharedPreferences.edit().putString(str, AppSetting.l()).commit();
            if (!com.tencent.mobileqq.automator.a.f199910a) {
                MultiLanguageEngine.getInstance().updateLangPkg(BaseApplication.getContext());
            }
        }
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.removeMessages(2);
            handler2.sendEmptyMessage(3);
        }
        AVSoUtils.e();
        AVSoUtils.g(-1046L);
    }
}
