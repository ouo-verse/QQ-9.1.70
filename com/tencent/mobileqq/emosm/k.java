package com.tencent.mobileqq.emosm;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.MultiEmotionSaveManager;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.report.EmotionFavoritePageReportUtil;
import com.tencent.mobileqq.multimsg.save.a;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class k extends BaseAdapter implements View.OnClickListener, AdapterView.OnItemClickListener, GestureSelectGridView.OnSelectListener, Handler.Callback {
    Button C;
    private ImageView D;
    GestureSelectGridView E;
    private ImageView F;
    public ImageView G;
    public ImageView H;
    private View I;
    RelativeLayout J;
    RelativeLayout K;
    int L;
    int M;
    LayoutInflater Q;
    float R;
    TextView S;
    TextView T;
    TextView U;
    TextView V;
    QIphoneTitleBarActivity W;
    private BaseQQAppInterface X;
    protected BaseEmosmStrategy Y;

    /* renamed from: a0, reason: collision with root package name */
    protected boolean f204371a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f204372b0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f204374d;

    /* renamed from: e0, reason: collision with root package name */
    private final g f204377e0;

    /* renamed from: f0, reason: collision with root package name */
    private final g f204379f0;

    /* renamed from: g0, reason: collision with root package name */
    private EmotionFavoritePageReportUtil f204380g0;

    /* renamed from: m, reason: collision with root package name */
    LinearLayout f204383m;

    /* renamed from: e, reason: collision with root package name */
    private boolean f204376e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f204378f = Integer.MIN_VALUE;

    /* renamed from: h, reason: collision with root package name */
    private int f204381h = Integer.MAX_VALUE;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f204382i = false;
    List<EmoticonInfo> N = null;
    List<EmoticonInfo> P = null;

    /* renamed from: c0, reason: collision with root package name */
    private volatile int f204373c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    private volatile f f204375d0 = null;
    private Handler Z = new WeakReferenceHandler(Looper.getMainLooper(), this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f204384d;

        a(ActionSheet actionSheet) {
            this.f204384d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            k.this.l();
            if (this.f204384d.isShowing()) {
                this.f204384d.dismiss();
            }
            ReportController.o(k.this.X, "CliOper", "", "", "ep_mall", "0X80057D7", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements MultiEmotionSaveManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.multimsg.save.a f204386a;

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class a implements a.b {
            a() {
            }

            @Override // com.tencent.mobileqq.multimsg.save.a.b
            public void cancel() {
                k.this.Y.g().b();
            }
        }

        b(com.tencent.mobileqq.multimsg.save.a aVar) {
            this.f204386a = aVar;
        }

        @Override // com.tencent.mobileqq.emosm.MultiEmotionSaveManager.a
        public void a() {
            if (this.f204386a.isShowing()) {
                this.f204386a.dismiss();
            }
            k.this.g();
            k.this.Y.g().g();
        }

        @Override // com.tencent.mobileqq.emosm.MultiEmotionSaveManager.a
        public void b(int i3) {
            this.f204386a.Q(i3);
        }

        @Override // com.tencent.mobileqq.emosm.MultiEmotionSaveManager.a
        public void c() {
            if (!this.f204386a.isShowing()) {
                this.f204386a.Q(0);
                this.f204386a.P(new a());
                if (QLog.isColorLevel()) {
                    QLog.i("MultiEmotionSaveManager", 2, "onSaveBegin");
                }
                this.f204386a.show();
            }
        }

        @Override // com.tencent.mobileqq.emosm.MultiEmotionSaveManager.a
        public void d(com.tencent.mobileqq.emosm.g gVar) {
            if (gVar != null && !k.this.W.isFinishing()) {
                int i3 = gVar.f204364d;
                if (i3 != -1) {
                    if (i3 == 0) {
                        QQToast.makeText(k.this.W.getApplicationContext(), k.this.W.getString(R.string.f173075h42), 0).show();
                    }
                } else if (gVar.f204365e == 10006) {
                    QQToast.makeText(k.this.W.getApplicationContext(), k.this.W.getString(R.string.vqo), 0).show();
                } else {
                    QQToast.makeText(k.this.W.getApplicationContext(), k.this.W.getString(R.string.h3x), 0).show();
                }
            } else if (QLog.isColorLevel()) {
                QLog.i("MultiEmotionSaveManager", 2, "onSaveComplete " + k.this.W.isFinishing());
            }
            if (this.f204386a.isShowing()) {
                this.f204386a.dismiss();
            }
            k.this.g();
            k.this.Y.g().g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements CustomEmotionRoamingDBManagerBase.a {
        c() {
        }

        @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.a
        public void callbackInMainThread(List<EmoticonInfo> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            if (k.this.Z != null) {
                k.this.Z.obtainMessage(206, list).sendToTarget();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class d implements URLDrawableDownListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EmoticonInfo f204390d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f204391e;

        d(EmoticonInfo emoticonInfo, e eVar) {
            this.f204390d = emoticonInfo;
            this.f204391e = eVar;
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            QLog.e("FavEmosmViewPage", 1, "onLoadFailed: " + this.f204390d.toString());
            k kVar = k.this;
            e eVar = this.f204391e;
            kVar.X(eVar.f204393a, eVar);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            QLog.e("FavEmosmViewPage", 1, "onLoadFailed: " + this.f204390d.toString());
            k kVar = k.this;
            e eVar = this.f204391e;
            kVar.X(eVar.f204393a, eVar);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            QLog.e("FavEmosmViewPage", 1, "onLoadInterrupted: " + this.f204390d.toString());
            k kVar = k.this;
            e eVar = this.f204391e;
            kVar.X(eVar.f204393a, eVar);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
            k kVar = k.this;
            e eVar = this.f204391e;
            kVar.X(eVar.f204393a, eVar);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            if (QLog.isDevelopLevel()) {
                QLog.i("FavEmosmViewPage", 4, "onLoadSuccess: " + this.f204390d.toString());
            }
            k kVar = k.this;
            e eVar = this.f204391e;
            kVar.X(eVar.f204393a, eVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public URLImageView f204393a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f204394b;

        /* renamed from: c, reason: collision with root package name */
        public View f204395c;

        /* renamed from: d, reason: collision with root package name */
        public View f204396d;

        /* renamed from: e, reason: collision with root package name */
        public View f204397e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f204398f;

        /* renamed from: g, reason: collision with root package name */
        public FrameLayout f204399g;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface f {
        void onEditModeChanged(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final Activity f204400a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private final String[] f204401b;

        /* renamed from: c, reason: collision with root package name */
        private QQPermission f204402c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes6.dex */
        public class a extends QQPermission.BasePermissionsListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f204403a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Runnable f204404b;

            a(Runnable runnable, Runnable runnable2) {
                this.f204403a = runnable;
                this.f204404b = runnable2;
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
                Runnable runnable = this.f204403a;
                if (runnable != null) {
                    runnable.run();
                }
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onDenied(List<String> list, List<Integer> list2) {
                super.onDenied(list, list2);
                Runnable runnable = this.f204404b;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        public g(@NonNull Activity activity, @NonNull String[] strArr) {
            this.f204400a = activity;
            this.f204401b = strArr;
        }

        private BusinessConfig a() {
            return new BusinessConfig(QQPermissionConstants.Business.ID.QQ_EMOTICON, QQPermissionConstants.Business.SCENE.EMOTICON_FAV_COLLECTION);
        }

        @Nullable
        public QQPermission b() {
            if (this.f204402c == null) {
                this.f204402c = QQPermissionFactory.getQQPermission(this.f204400a, a());
            }
            return this.f204402c;
        }

        public boolean c() {
            QQPermission b16 = b();
            if (b16 == null) {
                QLog.w("FavEmosmViewPage", 1, "hasGranted, permission is null");
                return true;
            }
            for (String str : this.f204401b) {
                if (b16.hasPermission(str) != 0) {
                    return false;
                }
            }
            return true;
        }

        public void d(Runnable runnable, Runnable runnable2) {
            QQPermission b16 = b();
            if (b16 == null) {
                QLog.w("FavEmosmViewPage", 1, "requestPermission, permission is null");
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            b16.requestPermissions(this.f204401b, 2, new a(runnable, runnable2));
        }
    }

    public k(BaseQQAppInterface baseQQAppInterface, QIphoneTitleBarActivity qIphoneTitleBarActivity) {
        this.X = baseQQAppInterface;
        this.W = qIphoneTitleBarActivity;
        this.Q = qIphoneTitleBarActivity.getLayoutInflater();
        this.R = qIphoneTitleBarActivity.getApplicationContext().getResources().getDisplayMetrics().density;
        this.f204372b0 = EmotionUtils.a(88.0f, qIphoneTitleBarActivity.getResources());
        this.f204377e0 = new g(qIphoneTitleBarActivity, new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE});
        this.f204379f0 = new g(qIphoneTitleBarActivity, new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE});
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        o();
        ReportController.o(this.X, "CliOper", "", "", "0X800A6D6", "0X800A6D6", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        n();
        this.Y.t();
    }

    private boolean D() {
        int count = getCount();
        if (!this.Y.j() && !VasUtil.getSignedService(this.X).getVipStatus().isSVip() && count <= FavEmoConstant.FAV_LOCAL_MAX_COUNT_SVIP && count >= FavEmoConstant.FAV_LOCAL_COUNT_SHOW_SVIP && this.f204373c0 == 0) {
            return true;
        }
        return false;
    }

    private void E() {
        if (this.f204382i) {
            this.f204382i = false;
            ((FavEmoRoamingHandler) this.X.getBusinessHandler(FavEmoRoamingHandler.f194632e)).notifyUI(2, true, null);
        }
    }

    private void R(e eVar) {
        eVar.f204395c.setVisibility(8);
        eVar.f204396d.setVisibility(0);
        eVar.f204397e.setVisibility(0);
        eVar.f204398f.setVisibility(8);
        eVar.f204393a.setVisibility(0);
        if (this.f204373c0 == 1) {
            eVar.f204394b.setVisibility(0);
        } else {
            eVar.f204394b.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void S(e eVar) {
        eVar.f204395c.setVisibility(8);
        eVar.f204396d.setVisibility(0);
        eVar.f204397e.setVisibility(8);
        eVar.f204393a.setVisibility(0);
        Animatable animatable = (Animatable) BaseApplication.getContext().getResources().getDrawable(R.drawable.f160545jt);
        eVar.f204398f.setImageDrawable((Drawable) animatable);
        animatable.start();
        eVar.f204398f.setVisibility(0);
        if (this.f204373c0 == 1) {
            eVar.f204394b.setVisibility(0);
        } else {
            eVar.f204394b.setVisibility(8);
        }
    }

    private void T(e eVar) {
        W(eVar);
        eVar.f204396d.setVisibility(8);
        eVar.f204397e.setVisibility(8);
        eVar.f204398f.setVisibility(8);
        eVar.f204393a.setVisibility(0);
        if (this.f204373c0 == 1) {
            eVar.f204394b.setVisibility(0);
        } else {
            eVar.f204394b.setVisibility(8);
        }
    }

    private void W(e eVar) {
        URLImageView uRLImageView = eVar.f204393a;
        if (uRLImageView == null) {
            return;
        }
        Object tag = uRLImageView.getTag(R.id.kxb);
        if (tag instanceof IFavoriteEmoticonInfo) {
            if (!((IFavoriteEmoticonInfo) tag).isChecked()) {
                eVar.f204395c.setVisibility(8);
            } else {
                eVar.f204395c.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(URLImageView uRLImageView, e eVar) {
        if (uRLImageView.getDrawable() instanceof URLDrawable) {
            URLDrawable uRLDrawable = (URLDrawable) uRLImageView.getDrawable();
            if (uRLDrawable.getStatus() == 0) {
                S(eVar);
            } else if (uRLDrawable.getStatus() != 2 && uRLDrawable.getStatus() != 3) {
                T(eVar);
            } else {
                R(eVar);
            }
        }
    }

    private void Z(int i3) {
        int i16;
        if (this.f204373c0 == 0) {
            if (VasUtil.getSignedService(this.X).getVipStatus().isSVip()) {
                i16 = 1000;
            } else {
                i16 = 500;
            }
            int count = getCount() - 1;
            String str = "\u6211\u6536\u85cf\u7684\u8868\u60c5 (" + count + "/" + i16 + ")";
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            if (count > i16) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), str.indexOf(String.valueOf(count)), str.indexOf(String.valueOf(count)) + String.valueOf(count).length(), 33);
            }
            this.W.setTitle(spannableStringBuilder);
            if (com.tencent.mobileqq.config.business.l.a()) {
                a0();
                return;
            }
            return;
        }
        if (this.f204373c0 == 1) {
            this.W.setTitle(String.format(this.W.getString(R.string.awq), Integer.valueOf(i3)));
        }
    }

    private void a0() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.W.centerView.getLayoutParams();
        marginLayoutParams.leftMargin = ViewUtils.dip2px(80.0f);
        marginLayoutParams.rightMargin = ViewUtils.dip2px(80.0f);
        this.W.centerView.setLayoutParams(marginLayoutParams);
    }

    private void b0(EmoticonInfo emoticonInfo, String str, e eVar) {
        if (!TextUtils.isEmpty(str) && eVar != null) {
            eVar.f204393a.setURLDrawableDownListener(null);
            if (str.equals("needUpload")) {
                S(eVar);
                return;
            }
            if (str.equals("failed")) {
                R(eVar);
                return;
            }
            T(eVar);
            Context baseContext = this.W.getBaseContext();
            int i3 = this.f204372b0;
            if (emoticonInfo.getZoomDrawable(baseContext, 0.0f, i3, i3) instanceof URLDrawable) {
                eVar.f204393a.setURLDrawableDownListener(new d(emoticonInfo, eVar));
                X(eVar.f204393a, eVar);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FavEmosmViewPage", 2, "updateViewStatus holder is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        List<EmoticonInfo> list = this.P;
        if (list == null) {
            return;
        }
        Iterator<EmoticonInfo> it = list.iterator();
        while (it.hasNext()) {
            it.next().isChecked = false;
        }
        notifyDataSetChanged();
        V();
        c0();
    }

    private List<EmoticonInfo> h(List<EmoticonInfo> list) {
        ConcurrentHashMap<Integer, Boolean> q16 = q();
        if (list != null && list.size() > 0 && q16.size() > 0) {
            for (EmoticonInfo emoticonInfo : list) {
                if (q16.containsKey(Integer.valueOf(emoticonInfo.emoId))) {
                    emoticonInfo.isChecked = true;
                }
            }
        }
        return list;
    }

    private void j(View view, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_PANEL");
        }
        e eVar = (e) view.getTag();
        Drawable drawable = eVar.f204393a.getDrawable();
        if (drawable instanceof URLDrawable) {
            URLDrawable uRLDrawable = (URLDrawable) drawable;
            if (uRLDrawable.getStatus() != 3 && uRLDrawable.getStatus() != 2) {
                if (uRLDrawable.getStatus() == 1) {
                    ((IEmosmService) QRoute.api(IEmosmService.class)).enterEmotionPreview(this.W, (EmoticonInfo) getItem(i3), ((IEmosmService) QRoute.api(IEmosmService.class)).getViewRect(eVar.f204393a));
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("FavEmosmViewPage", 2, "onItemClick restartDownload status = " + uRLDrawable.getStatus());
                }
                uRLDrawable.restartDownload();
            }
        }
    }

    private void k() {
        if (!this.f204379f0.c()) {
            this.f204379f0.d(new Runnable() { // from class: com.tencent.mobileqq.emosm.i
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.A();
                }
            }, null);
            return;
        }
        o();
        ReportController.o(this.X, "CliOper", "", "", "0X800A6D6", "0X800A6D6", 0, 0, "", "", "", "");
        this.f204380g0.reportEmojiAddedClick();
    }

    private void m(int i3) {
        EmoticonInfo emoticonInfo;
        List<EmoticonInfo> list = this.P;
        if (list != null && i3 < list.size()) {
            emoticonInfo = this.P.get(i3);
            this.P.remove(i3);
        } else {
            emoticonInfo = null;
        }
        List<EmoticonInfo> list2 = this.N;
        if (list2 != null && emoticonInfo != null) {
            list2.remove(emoticonInfo);
            ((IFavroamingManagerService) this.X.getRuntimeService(IFavroamingManagerService.class)).removeCacheAccessibilityEmotionData(Integer.valueOf(emoticonInfo.emoId));
        }
    }

    private ConcurrentHashMap<Integer, Boolean> q() {
        ConcurrentHashMap<Integer, Boolean> concurrentHashMap = new ConcurrentHashMap<>();
        List<EmoticonInfo> list = this.P;
        if (list != null) {
            for (EmoticonInfo emoticonInfo : list) {
                if (emoticonInfo.isChecked) {
                    concurrentHashMap.put(Integer.valueOf(emoticonInfo.emoId), Boolean.TRUE);
                }
            }
        }
        return concurrentHashMap;
    }

    private int s() {
        List<EmoticonInfo> list = this.P;
        int i3 = 0;
        if (list == null) {
            return 0;
        }
        Iterator<EmoticonInfo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().isChecked) {
                i3++;
            }
        }
        return i3;
    }

    private void v() {
        this.f204380g0 = new EmotionFavoritePageReportUtil(p());
    }

    private boolean y() {
        return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("emotion_download_disable_8980_887036489", Boolean.TRUE).booleanValue();
    }

    private boolean z(EmoticonInfo emoticonInfo) {
        if (emoticonInfo instanceof FavoriteEmoticonInfo) {
            FavoriteEmoticonInfo favoriteEmoticonInfo = (FavoriteEmoticonInfo) emoticonInfo;
            if (!TextUtils.isEmpty(favoriteEmoticonInfo.roamingType) && favoriteEmoticonInfo.roamingType.equals("failed")) {
                return true;
            }
            return false;
        }
        if (!(emoticonInfo instanceof PicEmoticonInfo)) {
            return false;
        }
        PicEmoticonInfo picEmoticonInfo = (PicEmoticonInfo) emoticonInfo;
        if (!TextUtils.isEmpty(picEmoticonInfo.roamingType) && picEmoticonInfo.roamingType.equals("failed")) {
            return true;
        }
        return false;
    }

    public void C(List<EmoticonInfo> list) {
        if (list == null) {
            QLog.e("FavEmosmViewPage", 1, "[loadFavEmotionFinished] error, data is null!");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FavEmosmViewPage", 2, "[loadFavEmotionFinished] data.size=", Integer.valueOf(list.size()));
        }
        List<FavoriteEmoticonInfo> list2 = this.Y.f204073d;
        if (list2 != null && !list2.isEmpty()) {
            list.addAll(this.Y.f204073d);
        }
        if (this.Y.k() && this.f204373c0 == 0) {
            if (list.size() == 0) {
                EmoticonInfo emoticonInfo = new EmoticonInfo();
                emoticonInfo.operateType = 1;
                list.add(0, emoticonInfo);
            } else if (list.get(0).operateType != 1) {
                EmoticonInfo emoticonInfo2 = new EmoticonInfo();
                emoticonInfo2.operateType = 1;
                list.add(0, emoticonInfo2);
            }
        }
        ((IFavroamingManagerService) this.X.getRuntimeService(IFavroamingManagerService.class)).cacheAccessibilityEmotionData();
        if (x()) {
            list = h(list);
        }
        this.N = list;
        this.P = list;
        this.E.setAdapter((ListAdapter) this);
        V();
        c0();
    }

    public void F() {
        E();
        this.f204375d0 = null;
    }

    protected void G() {
        if (s() == 0) {
            U(R.string.zu7);
        } else if (!this.f204377e0.c()) {
            this.f204377e0.d(new Runnable() { // from class: com.tencent.mobileqq.emosm.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.B();
                }
            }, null);
        } else {
            n();
            this.Y.t();
        }
    }

    protected void H() {
        if (s() == 0) {
            QQToast.makeText(this.W.getApplicationContext(), this.W.getString(R.string.zu9), 0).show();
            return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QQToast.makeText(this.W, R.string.cjm, 1).show(this.W.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (EmoticonInfo emoticonInfo : this.P) {
            if (emoticonInfo.isChecked) {
                arrayList.add(emoticonInfo);
            }
        }
        ReportController.o(this.X, "dc00898", "", "", "0X800B8BE", "0X800B8BE", arrayList.size(), 0, "", "", "", "");
        if (arrayList.isEmpty()) {
            ((IEmosmService) QRoute.api(IEmosmService.class)).toastFMDefault(R.string.b8i);
        } else {
            ((IEmosmService) QRoute.api(IEmosmService.class)).launchFriendPicker(this.W, arrayList);
        }
        g();
    }

    public void I() {
        this.f204371a0 = false;
        this.f204380g0.reportPageExit();
    }

    public void J() {
        this.f204371a0 = true;
        if (QLog.isColorLevel()) {
            QLog.d("FavEmosmViewPage", 2, "onResume update svip tips");
        }
        V();
        c0();
        this.f204380g0.reportPageExpose();
    }

    public void K() {
        this.Y.c(new c());
    }

    public void L(List<EmoticonInfo> list) {
        if (!this.Y.k() && list == null) {
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        ((IFavroamingManagerService) this.X.getRuntimeService(IFavroamingManagerService.class)).cacheAccessibilityEmotionData();
        if (this.f204373c0 == 0) {
            if (this.Y.k()) {
                if (list.size() == 0) {
                    EmoticonInfo emoticonInfo = new EmoticonInfo();
                    emoticonInfo.operateType = 1;
                    list.add(0, emoticonInfo);
                } else if (list.get(0).operateType != 1) {
                    EmoticonInfo emoticonInfo2 = new EmoticonInfo();
                    emoticonInfo2.operateType = 1;
                    list.add(0, emoticonInfo2);
                }
            }
            N(list);
            P(list);
        } else {
            if (x()) {
                list = h(list);
            }
            N(list);
            List<EmoticonInfo> e16 = this.Y.e(list);
            if (e16 != null) {
                P(e16);
            } else if (QLog.isColorLevel()) {
                QLog.d("FavEmosmViewPage", 2, "reloadFavEmotionFinished favEmoList is null");
            }
        }
        V();
        c0();
    }

    public void M(String str, String str2) {
        List<EmoticonInfo> list;
        if (!TextUtils.isEmpty(str) && (list = this.N) != null) {
            for (EmoticonInfo emoticonInfo : list) {
                if (emoticonInfo instanceof FavoriteEmoticonInfo) {
                    FavoriteEmoticonInfo favoriteEmoticonInfo = (FavoriteEmoticonInfo) emoticonInfo;
                    if (TextUtils.isEmpty(favoriteEmoticonInfo.path) && favoriteEmoticonInfo.path.equals(str)) {
                        favoriteEmoticonInfo.roamingType = str2;
                        return;
                    }
                }
            }
        }
    }

    public void N(List<EmoticonInfo> list) {
        this.N = list;
    }

    public void O(f fVar) {
        this.f204375d0 = fVar;
    }

    public void P(List<EmoticonInfo> list) {
        this.P = list;
        super.notifyDataSetChanged();
    }

    public void Q(int i3) {
        this.W.setTitle(i3);
    }

    protected void U(int i3) {
        QQToast.makeText(this.W.getApplicationContext(), this.W.getString(i3), 0).show();
    }

    void V() {
        if (this.P == null) {
            return;
        }
        if (getCount() > 0) {
            this.C.setEnabled(true);
            this.C.setTextColor(Color.parseColor("#00a5e0"));
        } else {
            this.C.setEnabled(false);
            this.C.setTextColor(Color.parseColor("#cccccc"));
        }
        int s16 = s();
        if (this.Y.f204074e) {
            if (s16 >= 0) {
                this.D.setEnabled(true);
                return;
            } else {
                this.D.setEnabled(false);
                return;
            }
        }
        this.D.setEnabled(true);
        this.F.setEnabled(true);
        this.H.setEnabled(true);
        this.G.setEnabled(true);
        this.D.setAlpha(1.0f);
        this.F.setAlpha(1.0f);
        this.H.setAlpha(1.0f);
        this.G.setAlpha(1.0f);
        Z(s16);
    }

    public void Y(GridView gridView, int i3) {
        if (gridView != null && i3 >= 0) {
            int firstVisiblePosition = gridView.getFirstVisiblePosition();
            int lastVisiblePosition = gridView.getLastVisiblePosition();
            if (i3 >= firstVisiblePosition && i3 <= lastVisiblePosition) {
                getView(i3, gridView.getChildAt(i3 - firstVisiblePosition), gridView);
            }
        }
    }

    protected void c0() {
        int i3;
        int i16;
        if (D()) {
            int count = getCount() - 1;
            QIphoneTitleBarActivity qIphoneTitleBarActivity = this.W;
            if (count > 500) {
                i3 = R.string.zue;
            } else {
                i3 = R.string.zud;
            }
            String string = qIphoneTitleBarActivity.getString(i3);
            QIphoneTitleBarActivity qIphoneTitleBarActivity2 = this.W;
            if (count > 500) {
                i16 = R.string.zuf;
            } else {
                i16 = R.string.m7s;
            }
            this.U.setText(qIphoneTitleBarActivity2.getString(i16));
            this.V.setText(string);
            this.J.setVisibility(0);
            return;
        }
        this.J.setVisibility(8);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<EmoticonInfo> list = this.P;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.P.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        e eVar;
        if (view == null) {
            view = this.Q.inflate(R.layout.h87, (ViewGroup) null);
            view.setLayoutParams(new AbsListView.LayoutParams(this.L, this.M));
            eVar = new e();
            eVar.f204393a = (URLImageView) view.findViewById(R.id.buq);
            eVar.f204394b = (ImageView) view.findViewById(R.id.bur);
            eVar.f204395c = view.findViewById(R.id.bup);
            eVar.f204396d = view.findViewById(R.id.f165069lg1);
            eVar.f204397e = view.findViewById(R.id.f165070lg2);
            eVar.f204398f = (ImageView) view.findViewById(R.id.f165071lg3);
            eVar.f204399g = (FrameLayout) view.findViewById(R.id.usb);
            view.setTag(eVar);
        } else {
            eVar = (e) view.getTag();
        }
        EmoticonInfo emoticonInfo = this.P.get(i3);
        if (emoticonInfo != eVar.f204393a.getTag(R.id.kxb)) {
            if (emoticonInfo.operateType == 1) {
                eVar.f204393a.setImageResource(R.drawable.f160636hn1);
                if (AppSetting.f99565y) {
                    eVar.f204393a.setContentDescription(this.W.getString(R.string.in5));
                }
            } else {
                URLImageView uRLImageView = eVar.f204393a;
                Context applicationContext = this.W.getApplicationContext();
                float f16 = this.R;
                int i16 = this.f204372b0;
                uRLImageView.setImageDrawable(emoticonInfo.getZoomDrawable(applicationContext, f16, i16, i16));
            }
            eVar.f204393a.setTag(R.id.kxb, emoticonInfo);
        }
        if (emoticonInfo instanceof IFavoriteEmoticonInfo) {
            IFavoriteEmoticonInfo iFavoriteEmoticonInfo = (IFavoriteEmoticonInfo) emoticonInfo;
            b0(emoticonInfo, iFavoriteEmoticonInfo.getRoamingType(), eVar);
            if (!iFavoriteEmoticonInfo.isChecked()) {
                eVar.f204395c.setVisibility(8);
                eVar.f204394b.setImageResource(R.drawable.qq_pic_img_checkbox_deselect2);
            } else {
                eVar.f204395c.setVisibility(0);
                eVar.f204394b.setImageResource(R.drawable.qq_pic_img_checkbox_select2);
            }
            if (this.f204373c0 == 1) {
                eVar.f204394b.setVisibility(0);
            } else {
                eVar.f204394b.setVisibility(8);
            }
            if (emoticonInfo.operateType != 1) {
                String f17 = this.Y.f(emoticonInfo);
                if (AppSetting.f99565y && !TextUtils.isEmpty(f17) && eVar.f204394b.getVisibility() == 0) {
                    if (!iFavoriteEmoticonInfo.isChecked()) {
                        if (AppSetting.f99565y && !TextUtils.isEmpty(f17)) {
                            f17 = f17 + "," + this.X.getApp().getString(R.string.f209485fj);
                        }
                    } else if (AppSetting.f99565y && !TextUtils.isEmpty(f17)) {
                        f17 = f17 + "," + this.X.getApp().getString(R.string.f208935e2);
                    }
                }
                eVar.f204393a.setContentDescription(f17);
            }
        }
        if (emoticonInfo.operateType == 1) {
            eVar.f204395c.setVisibility(8);
            eVar.f204394b.setVisibility(8);
            eVar.f204396d.setVisibility(8);
            eVar.f204397e.setVisibility(8);
            eVar.f204398f.setVisibility(8);
        }
        if (ThemeUtil.isInNightMode(this.X)) {
            view.setBackgroundColor(-16777216);
            eVar.f204399g.setBackgroundColor(MiniChatConstants.COLOR_SELECTED_NIGHT);
        } else {
            view.setBackgroundColor(-657931);
            eVar.f204399g.setBackgroundColor(-1);
        }
        int a16 = EmotionUtils.a(1.0f, this.W.getResources());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) eVar.f204399g.getLayoutParams();
        if (i3 % 4 == 3) {
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.rightMargin = a16;
        }
        if (i3 < 4) {
            layoutParams.topMargin = a16;
        } else {
            layoutParams.topMargin = 0;
        }
        eVar.f204399g.setLayoutParams(layoutParams);
        View h16 = this.Y.h(i3, view, eVar, emoticonInfo);
        EventCollector.getInstance().onListGetView(i3, h16, viewGroup, getItemId(i3));
        return h16;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Integer num;
        int intValue;
        int i3 = message.what;
        if (i3 == 207) {
            m(((Integer) message.obj).intValue());
            notifyDataSetChanged();
            V();
            l();
            c0();
        } else if (i3 == 206) {
            L((List) message.obj);
        } else if (i3 == 208) {
            Object obj = message.obj;
            if ((obj instanceof Integer) && ((intValue = (num = (Integer) obj).intValue()) == 7 || intValue == 8)) {
                int i16 = 1;
                QLog.e("FavEmosmViewPage", 1, "update ui, over limit flag:", Boolean.valueOf(CameraEmoAllSend.S), " ret:", num, " onResumed:", Boolean.valueOf(this.f204371a0));
                if (!this.f204371a0) {
                    return false;
                }
                CameraEmoAllSend.S = true;
                if (num.intValue() != 7) {
                    i16 = 2;
                }
                EmoAddedAuthCallback.j(this.X, this.W, i16);
            }
        }
        return false;
    }

    protected void i() {
        if (this.f204373c0 == 1) {
            this.f204373c0 = 0;
            this.Y.f204072c.set(true);
            this.f204383m.setVisibility(8);
            this.K.setVisibility(8);
            this.T.setText(R.string.inh);
            this.T.setContentDescription(this.W.getString(R.string.ini));
            Iterator<EmoticonInfo> it = this.P.iterator();
            while (it.hasNext()) {
                it.next().isChecked = false;
            }
            this.Y.q();
            V();
            c0();
            if (this.f204382i) {
                E();
                K();
            }
            if (this.f204375d0 != null) {
                this.f204375d0.onEditModeChanged(false);
            }
            ReportController.o(this.X, "CliOper", "", "", "ep_mall", "0X80057D5", 0, 0, "", "", "", "");
            return;
        }
        if (this.f204373c0 == 0) {
            this.f204373c0 = 1;
            this.E.setSelectMode(true);
            this.Y.f204072c.set(false);
            this.f204383m.setVisibility(0);
            Z(0);
            this.T.setText(R.string.b9f);
            this.T.setContentDescription(this.W.getString(R.string.in6));
            this.J.setVisibility(8);
            this.Y.r();
            this.Y.s();
            if (this.f204375d0 != null) {
                this.f204375d0.onEditModeChanged(true);
            }
            ReportController.o(this.X, "dc00898", "", "", "0X800B8BB", "0X800B8BB", 0, 0, "", "", "", "");
            ReportController.o(this.X, "CliOper", "", "", "ep_mall", "0X80057D3", 0, 0, "", "", "", "");
            this.f204380g0.reportEmojiManageClick();
        }
    }

    void l() {
        BaseEmosmStrategy baseEmosmStrategy = this.Y;
        if (baseEmosmStrategy != null) {
            baseEmosmStrategy.b();
        }
    }

    void n() {
        if (this.P == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (EmoticonInfo emoticonInfo : this.P) {
            if (emoticonInfo.isChecked) {
                arrayList.add(emoticonInfo);
            }
        }
        ReportController.o(this.X, "dc00898", "", "", "0X800B8BD", "0X800B8BD", arrayList.size(), 0, "", "", "", "");
        if (arrayList.isEmpty()) {
            ((IEmosmService) QRoute.api(IEmosmService.class)).toastFMDefault(R.string.b8i);
            return;
        }
        this.Y.g().k(new b(new com.tencent.mobileqq.multimsg.save.a(this.W)));
        this.Y.g().j(arrayList);
    }

    protected void o() {
        ((IEmosmService) QRoute.api(IEmosmService.class)).enterNewPhotoList(this.W);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnLeft) {
            ReportController.o(this.X, "dc00898", "", "", "0X800B8BA", "0X800B8BA", 0, 0, "", "", "", "");
            this.W.finish();
        } else if (id5 == R.id.ivTitleBtnRightText) {
            if (this.Y.f204075f) {
                ReportController.o(this.X, "CliOper", "", "", "0X8005C7A", "0X8005C7A", 0, 0, "", "", "", "");
                this.W.finish();
            } else {
                i();
            }
        } else if (id5 == R.id.buo) {
            List<EmoticonInfo> list = this.P;
            if (list != null) {
                for (EmoticonInfo emoticonInfo : list) {
                    if (emoticonInfo instanceof IFavoriteEmoticonInfo) {
                        emoticonInfo.isChecked = true;
                    }
                }
                notifyDataSetChanged();
                V();
                c0();
                ReportController.o(this.X, "CliOper", "", "", "ep_mall", "0X80057D6", 0, 0, "", "", "", "");
            }
        } else if (id5 == R.id.bun) {
            t();
        } else if (id5 == R.id.but) {
            QIphoneTitleBarActivity qIphoneTitleBarActivity = this.W;
            VasH5PayUtil.openClubPay(qIphoneTitleBarActivity, "mvip.n.a.bqsc_edit", 3, "1450000516", "CJCLUBT", qIphoneTitleBarActivity.getString(R.string.f173184hu3), "");
        } else if (id5 == R.id.f165072lg4) {
            G();
        } else if (id5 == R.id.usa) {
            H();
        } else if (id5 == R.id.us_) {
            if (s() == 0) {
                U(R.string.zu8);
            } else {
                u();
                V();
                c0();
                U(R.string.in_);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        List<EmoticonInfo> list;
        if (this.Y.m(adapterView, view, i3, j3)) {
            return;
        }
        if (this.f204373c0 == 0) {
            if (this.Y.k() && i3 == 0 && (list = this.P) != null && list.size() > 0 && list.get(0).operateType == 1) {
                k();
                return;
            }
            Object item = getItem(i3);
            if (item instanceof IFavoriteEmoticonInfo) {
                IFavoriteEmoticonInfo iFavoriteEmoticonInfo = (IFavoriteEmoticonInfo) item;
                String roamingType = iFavoriteEmoticonInfo.getRoamingType();
                if (QLog.isColorLevel()) {
                    QLog.d("FavEmosmViewPage", 2, "onItemClick roamingType = " + roamingType);
                }
                if (!TextUtils.isEmpty(roamingType) && roamingType.equals("needUpload")) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_NEED_UPLOAD");
                    }
                } else if (!TextUtils.isEmpty(roamingType) && roamingType.equals("failed")) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_FAILED");
                    }
                    this.Y.u(this.E, i3, iFavoriteEmoticonInfo);
                } else if (!TextUtils.isEmpty(roamingType) && roamingType.equals(FavEmoConstant.ROAMING_TYPE_PANEL)) {
                    j(view, i3);
                } else {
                    ((IEmosmService) QRoute.api(IEmosmService.class)).enterEmotionPreview(this.W, (EmoticonInfo) getItem(i3), ((IEmosmService) QRoute.api(IEmosmService.class)).getViewRect(((e) view.getTag()).f204393a));
                }
                this.f204380g0.reportEmojiClick(iFavoriteEmoticonInfo.getEid());
                return;
            }
            return;
        }
        Object item2 = getItem(i3);
        if (item2 instanceof EmoticonInfo) {
            ((EmoticonInfo) item2).isChecked = !r7.isChecked;
        }
        Y(this.E, i3);
        V();
        c0();
    }

    @Override // com.tencent.widget.GestureSelectGridView.OnSelectListener
    public void onSelectBegin(int i3) {
        if (this.f204373c0 == 0 || getCount() <= i3) {
            return;
        }
        Object item = getItem(i3);
        if (!IFavoriteEmoticonInfo.class.isInstance(item)) {
            return;
        }
        IFavoriteEmoticonInfo iFavoriteEmoticonInfo = (IFavoriteEmoticonInfo) item;
        boolean isChecked = iFavoriteEmoticonInfo.isChecked();
        this.f204376e = isChecked;
        iFavoriteEmoticonInfo.setIsChecked(!isChecked);
        this.E.invalidateViews();
        this.f204374d = true;
        if (QLog.isColorLevel()) {
            QLog.d("FavEmosmViewPage", 2, "onSelectBegin");
        }
    }

    @Override // com.tencent.widget.GestureSelectGridView.OnSelectListener
    public void onSelectChanged(int i3, int i16) {
        if (this.f204373c0 == 0 || !this.f204374d) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FavEmosmViewPage", 2, "onSelectBegin beginIndex:", Integer.valueOf(i3), "  selectIndex:", Integer.valueOf(i16));
        }
        if (i16 < i3) {
            if (this.f204381h > i16) {
                this.f204381h = i16;
            }
            i16 = i3;
            i3 = i16;
        } else if (this.f204378f < i16) {
            this.f204378f = i16;
        }
        for (int i17 = i3; i17 <= i16; i17++) {
            Object item = getItem(i17);
            if (IFavoriteEmoticonInfo.class.isInstance(item)) {
                ((IFavoriteEmoticonInfo) item).setIsChecked(!this.f204376e);
            }
        }
        for (int i18 = i16 + 1; i18 <= this.f204378f; i18++) {
            Object item2 = getItem(i18);
            if (IFavoriteEmoticonInfo.class.isInstance(item2)) {
                ((IFavoriteEmoticonInfo) item2).setIsChecked(this.f204376e);
            }
        }
        for (int i19 = this.f204381h; i19 < i3; i19++) {
            Object item3 = getItem(i19);
            if (IFavoriteEmoticonInfo.class.isInstance(item3)) {
                ((IFavoriteEmoticonInfo) item3).setIsChecked(this.f204376e);
            }
        }
        this.E.invalidateViews();
        V();
        c0();
    }

    @Override // com.tencent.widget.GestureSelectGridView.OnSelectListener
    public void onSelectEnd() {
        if (this.f204373c0 == 0 || !this.f204374d) {
            return;
        }
        this.f204374d = false;
        this.f204376e = false;
        this.f204378f = Integer.MIN_VALUE;
        this.f204381h = Integer.MAX_VALUE;
        if (QLog.isColorLevel()) {
            QLog.d("FavEmosmViewPage", 2, "onSelectEnd");
        }
        V();
        c0();
    }

    public <T extends QIphoneTitleBarActivity> T p() {
        return (T) this.W;
    }

    public Handler r() {
        return this.Z;
    }

    protected void t() {
        if (s() == 0) {
            QQToast.makeText(this.W.getApplicationContext(), this.W.getString(R.string.zu6), 0).show();
            return;
        }
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.W, null);
        actionSheet.setMainTitle(R.string.in7);
        actionSheet.addButton(this.W.getString(R.string.b5u), 3);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new a(actionSheet));
        actionSheet.show();
        if (this.P == null) {
            return;
        }
        ReportController.o(this.X, "dc00898", "", "", "0X800B8BF", "0X800B8BF", s(), 0, "", "", "", "");
    }

    protected void u() {
        if (this.P != null) {
            boolean z16 = true;
            this.f204382i = true;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            List<CustomEmotionData> emoticonDataList = ((IFavroamingDBManagerService) this.X.getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList();
            for (EmoticonInfo emoticonInfo : this.P) {
                if (emoticonInfo.isChecked) {
                    boolean z17 = false;
                    emoticonInfo.isChecked = false;
                    if (z(emoticonInfo)) {
                        arrayList3.add(emoticonInfo);
                        z17 = z16;
                    } else {
                        arrayList5.add(emoticonInfo);
                    }
                    if (emoticonDataList != null) {
                        Iterator<CustomEmotionData> it = emoticonDataList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                CustomEmotionData next = it.next();
                                if (next.emoId == emoticonInfo.emoId) {
                                    if (!z17 && !TextUtils.isEmpty(next.resid)) {
                                        arrayList.add(next.resid);
                                    }
                                    arrayList2.add(next);
                                }
                            }
                        }
                    }
                } else if (z(emoticonInfo)) {
                    arrayList4.add(emoticonInfo);
                } else {
                    arrayList6.add(emoticonInfo);
                }
                z16 = true;
            }
            if (arrayList5.size() == 0 && arrayList3.size() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("FavEmosmViewPage", 2, "handleEmotionMove selectedList is empty!");
                    return;
                }
                return;
            }
            FavEmoRoamingHandler favEmoRoamingHandler = (FavEmoRoamingHandler) this.X.getBusinessHandler(FavEmoRoamingHandler.f194632e);
            if (favEmoRoamingHandler != null) {
                favEmoRoamingHandler.P2(arrayList);
            }
            List<EmoticonInfo> arrayList7 = new ArrayList<>();
            if (arrayList3.size() > 0) {
                arrayList7.addAll(arrayList3);
            }
            if (arrayList4.size() > 0) {
                arrayList7.addAll(arrayList4);
            }
            if (arrayList5.size() > 0) {
                arrayList7.addAll(arrayList5);
            }
            if (arrayList6.size() > 0) {
                arrayList7.addAll(arrayList6);
            }
            P(arrayList7);
            IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) this.X.getRuntimeService(IFavroamingDBManagerService.class);
            int size = arrayList2.size();
            Iterator<CustomEmotionData> it5 = emoticonDataList.iterator();
            int i3 = 1;
            while (it5.hasNext()) {
                int i16 = it5.next().emoId;
                if (i3 < i16) {
                    i3 = i16;
                }
            }
            if (size > 0) {
                for (int i17 = size - 1; i17 >= 0; i17--) {
                    CustomEmotionData customEmotionData = (CustomEmotionData) arrayList2.get(i17);
                    iFavroamingDBManagerService.deleteCustomEmotion(customEmotionData);
                    CustomEmotionData cloneEmotionData = customEmotionData.cloneEmotionData(customEmotionData);
                    i3++;
                    cloneEmotionData.emoId = i3;
                    iFavroamingDBManagerService.insertCustomEmotion(cloneEmotionData);
                }
                iFavroamingDBManagerService.trimCache();
            }
            int size2 = arrayList5.size() + arrayList3.size();
            ReportController.o(this.X, "dc00898", "", "", "0X800B8BC", "0X800B8BC", size2, 0, String.valueOf(size2), "", "", "");
        }
    }

    public void w(BaseEmosmStrategy baseEmosmStrategy) {
        this.Y = baseEmosmStrategy;
        Resources resources = this.W.getResources();
        int i3 = resources.getDisplayMetrics().widthPixels;
        int a16 = EmotionUtils.a(0.0f, resources);
        int a17 = EmotionUtils.a(0.0f, resources);
        int a18 = EmotionUtils.a(0.0f, resources);
        int i16 = ((i3 - (a16 * 2)) - (a17 * 3)) / 4;
        this.L = i16;
        this.M = i16;
        QIphoneTitleBarActivity qIphoneTitleBarActivity = this.W;
        this.T = qIphoneTitleBarActivity.rightViewText;
        TextView textView = qIphoneTitleBarActivity.leftView;
        this.S = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        this.T.setVisibility(0);
        this.T.setText(R.string.inh);
        this.T.setBackground(null);
        this.T.setContentDescription(this.W.getString(R.string.ini));
        this.T.setOnClickListener(this);
        this.I = this.W.findViewById(R.id.root);
        this.f204383m = (LinearLayout) this.W.findViewById(R.id.bum);
        this.C = (Button) this.W.findViewById(R.id.buo);
        ImageView imageView = (ImageView) this.W.findViewById(R.id.bun);
        this.D = imageView;
        imageView.setContentDescription(this.W.getString(R.string.f170881zu4));
        ImageView imageView2 = (ImageView) this.W.findViewById(R.id.f165072lg4);
        this.F = imageView2;
        imageView2.setContentDescription(this.W.getString(R.string.ina));
        if (y()) {
            this.F.setVisibility(8);
        }
        ImageView imageView3 = (ImageView) this.W.findViewById(R.id.usa);
        this.H = imageView3;
        imageView3.setContentDescription(this.W.getString(R.string.zuc));
        ImageView imageView4 = (ImageView) this.W.findViewById(R.id.us_);
        this.G = imageView4;
        imageView4.setContentDescription(this.W.getString(R.string.zu5));
        GestureSelectGridView gestureSelectGridView = (GestureSelectGridView) this.W.findViewById(R.id.bus);
        this.E = gestureSelectGridView;
        gestureSelectGridView.setSelectMode(false);
        RelativeLayout relativeLayout = (RelativeLayout) this.W.findViewById(R.id.but);
        this.J = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.J.setBackground(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/cc746e41-d390-408c-aa6b-419e38a4432f.png"));
        this.K = (RelativeLayout) this.W.findViewById(R.id.btd);
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.E.setScrollBarStyle(0);
        this.E.setNumColumns(4);
        this.E.setColumnWidth(this.L);
        this.E.setHorizontalSpacing(a17);
        this.E.setVerticalSpacing(a18);
        GestureSelectGridView gestureSelectGridView2 = this.E;
        gestureSelectGridView2.setPadding(a16, gestureSelectGridView2.getPaddingTop(), a16, this.E.getPaddingBottom());
        this.E.setOnItemClickListener(this);
        this.E.setOnIndexChangedListener(this);
        this.E.setMaximumVelocity((int) (this.W.getResources().getDisplayMetrics().density * 2500.0f));
        if (baseEmosmStrategy.i(this.W) && baseEmosmStrategy.f204074e) {
            this.T.setText(R.string.f208945e3);
            TextView textView2 = this.S;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            this.C.setVisibility(8);
        }
        this.U = (TextView) this.W.findViewById(R.id.f164661ah1);
        this.V = (TextView) this.W.findViewById(R.id.tee);
        c0();
        if (ThemeUtil.isInNightMode(this.X)) {
            this.I.setBackgroundColor(-16777216);
            this.J.setBackgroundColor(-16777216);
            this.f204383m.setBackgroundColor(-16777216);
            this.U.setBackgroundColor(-16777216);
            this.V.setBackgroundColor(-16777216);
            this.V.setTextColor(-1);
        }
    }

    public boolean x() {
        if (this.f204373c0 == 1) {
            return true;
        }
        return false;
    }
}
