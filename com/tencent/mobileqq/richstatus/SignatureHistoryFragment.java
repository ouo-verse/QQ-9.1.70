package com.tencent.mobileqq.richstatus;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.api.ETFontUtil;
import com.tencent.av.utils.ba;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.da;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.comment.bean.CommentItem;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;
import com.tencent.mobileqq.richstatus.comment.widget.LikesView;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.richstatus.sign.b;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.font.api.FontLoadCallback;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SignatureHistoryFragment extends IphoneTitleBarFragment implements Handler.Callback, View.OnClickListener, ITopic.OnTopicClickListener, b.a, SoftInputDetectView.a, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;
    private HashSet<com.tencent.mobileqq.richstatus.sign.b> A0;
    private ActionSheet B0;
    private String C;
    View.OnTouchListener C0;
    private String D;
    View.OnClickListener D0;
    private String E;
    FontLoadCallback E0;
    protected XListView F;
    View.OnLayoutChangeListener F0;
    private View G;
    private View H;
    private ImageView I;
    private TextView J;
    private TextView K;
    private int L;
    protected int M;
    private View N;
    private TextView P;
    private ImageView Q;
    private Drawable R;
    private QUIButton S;
    private View T;
    private TextView U;
    private TextView V;
    private TextView W;
    private boolean X;
    private boolean Y;
    private IEmoticonMainPanel Z;

    /* renamed from: a0, reason: collision with root package name */
    private EditText f282172a0;

    /* renamed from: b0, reason: collision with root package name */
    private Button f282173b0;

    /* renamed from: c0, reason: collision with root package name */
    private ImageView f282174c0;

    /* renamed from: d0, reason: collision with root package name */
    private ViewGroup f282175d0;

    /* renamed from: e0, reason: collision with root package name */
    private RelativeLayout f282176e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f282177f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f282178g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f282179h0;

    /* renamed from: i0, reason: collision with root package name */
    private t f282180i0;

    /* renamed from: j0, reason: collision with root package name */
    private Handler f282181j0;

    /* renamed from: k0, reason: collision with root package name */
    private HashMap<String, ArrayList<String>> f282182k0;

    /* renamed from: l0, reason: collision with root package name */
    private HashMap<String, Boolean> f282183l0;

    /* renamed from: m0, reason: collision with root package name */
    private ArrayList<String> f282184m0;

    /* renamed from: n0, reason: collision with root package name */
    View f282185n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f282186o0;

    /* renamed from: p0, reason: collision with root package name */
    private CommentItem f282187p0;

    /* renamed from: q0, reason: collision with root package name */
    private ArrayList<HistorySignItem> f282188q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f282189r0;

    /* renamed from: s0, reason: collision with root package name */
    private QQProgressDialog f282190s0;

    /* renamed from: t0, reason: collision with root package name */
    protected SignatureHandler f282191t0;

    /* renamed from: u0, reason: collision with root package name */
    protected SignatureManager f282192u0;

    /* renamed from: v0, reason: collision with root package name */
    protected StatusManager f282193v0;

    /* renamed from: w0, reason: collision with root package name */
    protected com.tencent.mobileqq.richstatus.m f282194w0;

    /* renamed from: x0, reason: collision with root package name */
    protected da f282195x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f282196y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f282197z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements LikesView.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.comment.widget.LikesView.c
        public void onClick(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else if (!SignatureHistoryFragment.this.f282196y0) {
                SignatureHistoryFragment.this.Ai(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements CommentsView.f {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.comment.widget.CommentsView.f
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else if (!SignatureHistoryFragment.this.f282196y0) {
                SignatureHistoryFragment.this.Ai(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements CommentsView.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HistorySignItem f282211a;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements BubblePopupWindow.OnDismissListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f282213d;

            a(View view) {
                this.f282213d = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) view);
                }
            }

            @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
            public void onDismiss() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    this.f282213d.setSelected(false);
                }
            }
        }

        c(HistorySignItem historySignItem) {
            this.f282211a = historySignItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this, (Object) historySignItem);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.comment.widget.CommentsView.e
        public void a(int i3, View view) {
            List<CommentItem> list;
            CommentItem commentItem;
            com.tencent.mobileqq.richstatus.comment.bean.b bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) view);
                return;
            }
            if (!SignatureHistoryFragment.this.f282196y0 && (list = this.f282211a.commentItemList) != null && list.size() > i3 && (bVar = (commentItem = list.get(i3)).user) != null && !TextUtils.isEmpty(bVar.f282322a)) {
                view.setSelected(true);
                com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
                SignatureHistoryFragment.this.f282187p0 = commentItem;
                aVar.b(R.id.bbi, SignatureHistoryFragment.this.getString(R.string.aet), 0);
                if (bVar.f282322a.equals(SignatureHistoryFragment.this.D) || Utils.p(SignatureHistoryFragment.this.D, SignatureHistoryFragment.this.C)) {
                    aVar.b(R.id.bfa, SignatureHistoryFragment.this.getString(R.string.bbl), 0);
                }
                com.tencent.mobileqq.utils.s.d(view, aVar, SignatureHistoryFragment.this, new a(view));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 1) {
                if (motionEvent.getY() < view.findViewById(R.id.e9z).getHeight() + BaseAIOUtils.f(30.0f, view.getResources())) {
                    SignatureHistoryFragment.this.f282197z0 = true;
                } else {
                    SignatureHistoryFragment.this.f282197z0 = false;
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                String str = (String) view.getTag();
                if (SignatureHistoryFragment.this.f282184m0.contains(str)) {
                    SignatureHistoryFragment.this.f282184m0.remove(str);
                    ((CheckBox) view).setChecked(false);
                } else if (SignatureHistoryFragment.this.f282184m0.size() >= 200) {
                    SignatureHistoryFragment.this.Xi(1, R.string.hmr);
                    ((CheckBox) view).setChecked(false);
                } else {
                    SignatureHistoryFragment.this.f282184m0.add(str);
                    ((CheckBox) view).setChecked(true);
                }
                SignatureHistoryFragment.this.qi(false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class f implements FontLoadCallback {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.font.api.FontLoadCallback
        public void onFontLoaded() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                SignatureHistoryFragment.this.f282181j0.sendMessage(SignatureHistoryFragment.this.f282181j0.obtainMessage(1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g implements EmoticonCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f282218d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f282219e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ BaseActivity f282220f;

        g(EditText editText, QQAppInterface qQAppInterface, BaseActivity baseActivity) {
            this.f282218d = editText;
            this.f282219e = qQAppInterface;
            this.f282220f = baseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, editText, qQAppInterface, baseActivity);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.mobileqq.text.TextUtils.backspace(this.f282218d);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) emoticonInfo);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoticonInfo)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, emoticonInfo, emoticonInfo2, drawable);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo emoticonInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) emoticonInfo);
            } else if (emoticonInfo != null) {
                try {
                    emoticonInfo.send(this.f282219e, this.f282220f, this.f282218d, null);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class h implements EmoticonListProvider {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonListProvider
        public List<EmotionPanelInfo> getEmotionPanelInfo(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new EmotionPanelInfo(7, EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI, null));
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class i implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800A98A", "0X800A98A", 1, 0, "0", "0", "", "");
                SignatureHistoryFragment.this.Mi(true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class j implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return SignatureHistoryFragment.this.Bi(view, false);
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class k implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800A98A", "0X800A98A", 2, 0, "0", "0", "", "");
                SignatureHistoryFragment.this.Ni(true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class l implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CommentItem f282224d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f282225e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f282226f;

        l(CommentItem commentItem, String str, ActionSheet actionSheet) {
            this.f282224d = commentItem;
            this.f282225e = str;
            this.f282226f = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SignatureHistoryFragment.this, commentItem, str, actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 0) {
                if (!NetworkUtil.isNetSupport(SignatureHistoryFragment.this.getBaseActivity())) {
                    QQToast.makeText(SignatureHistoryFragment.this.getBaseActivity(), R.string.bqf, 0).show();
                } else {
                    SignatureHistoryFragment.this.f282187p0 = this.f282224d;
                    if (this.f282224d != null && !TextUtils.isEmpty(SignatureHistoryFragment.this.C) && !TextUtils.isEmpty(this.f282225e)) {
                        if (SignatureHistoryFragment.this.f282190s0 == null) {
                            SignatureHistoryFragment.this.f282190s0 = new QQProgressDialog(SignatureHistoryFragment.this.getBaseActivity(), SignatureHistoryFragment.this.getBaseActivity().getTitleBarHeight());
                        }
                        SignatureHistoryFragment.this.f282190s0.setMessage((String) null);
                        SignatureHistoryFragment.this.f282190s0.show();
                        SignatureHistoryFragment signatureHistoryFragment = SignatureHistoryFragment.this;
                        signatureHistoryFragment.f282191t0.E2(Long.valueOf(signatureHistoryFragment.C).longValue(), this.f282224d.feedId, Long.valueOf(this.f282225e).longValue(), this.f282224d.f282319id);
                    }
                }
            }
            this.f282226f.superDismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class m implements View.OnLayoutChangeListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            SignatureHistoryFragment signatureHistoryFragment;
            View view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
                return;
            }
            if (i16 < i26 && (view2 = (signatureHistoryFragment = SignatureHistoryFragment.this).f282185n0) != null) {
                int yi5 = signatureHistoryFragment.yi(view2);
                int height = SignatureHistoryFragment.this.f282185n0.getHeight();
                if (yi5 + height > i16) {
                    SignatureHistoryFragment.this.Qi(yi5, height, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class n extends Editable.Factory {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // android.text.Editable.Factory
        public Editable newEditable(CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Editable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence);
            }
            if (charSequence instanceof QQTextBuilder) {
                return (Editable) charSequence;
            }
            return new QQTextBuilder(charSequence, 3, (int) (SignatureHistoryFragment.this.f282172a0.getTextSize() / SignatureHistoryFragment.this.f282172a0.getPaint().density));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class o implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private CharSequence f282230d;

        /* renamed from: e, reason: collision with root package name */
        private int f282231e;

        /* renamed from: f, reason: collision with root package name */
        private int f282232f;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            CharSequence charSequence = this.f282230d;
            if (charSequence != null && com.tencent.mobileqq.text.TextUtils.getQQTextCharCount(String.valueOf(charSequence), 3) > 50) {
                QQToast.makeText(SignatureHistoryFragment.this.getBaseActivity(), 1, R.string.f170518tl, 0).show();
                if (editable != null) {
                    editable.delete(this.f282231e, this.f282232f);
                }
            }
            if (editable != null && editable.length() != 0) {
                SignatureHistoryFragment.this.f282173b0.setEnabled(true);
            } else {
                SignatureHistoryFragment.this.f282173b0.setEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            this.f282230d = charSequence;
            this.f282231e = i3;
            this.f282232f = i3 + i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class p implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800A98D", "0X800A98D", 2, 0, "0", "0", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class q implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            boolean bj5 = SignatureHistoryFragment.this.bj(arrayList, false);
            if (SignatureHistoryFragment.this.f282190s0 == null) {
                SignatureHistoryFragment.this.f282190s0 = new QQProgressDialog(SignatureHistoryFragment.this.getBaseActivity(), SignatureHistoryFragment.this.getBaseActivity().getTitleBarHeight());
            }
            SignatureHistoryFragment.this.f282190s0.setMessage(HardCodeUtil.qqStr(R.string.tj8));
            SignatureHistoryFragment.this.f282190s0.show();
            if (SignatureHistoryFragment.this.f282189r0 && SignatureHistoryFragment.this.f282188q0.size() == 1) {
                NewIntent newIntent = new NewIntent(SignatureHistoryFragment.this.getBaseActivity().app.getApp(), StatusServlet.class);
                newIntent.putExtra("k_cmd", 8);
                SignatureHistoryFragment.this.getBaseActivity().app.startServlet(newIntent);
            } else if (!arrayList.isEmpty()) {
                NewIntent newIntent2 = new NewIntent(SignatureHistoryFragment.this.getBaseActivity().app.getApp(), StatusServlet.class);
                newIntent2.putExtra("k_cmd", 5);
                newIntent2.putStringArrayListExtra("k_status_key", arrayList);
                newIntent2.putExtra("k_status_flag", bj5 ? 1 : 0);
                SignatureHistoryFragment.this.getBaseActivity().app.startServlet(newIntent2);
            }
            ReportController.o(null, "dc00898", "", "", "0X800A98D", "0X800A98D", 1, 0, "0", "0", "", "");
            VasWebviewUtil.reportCommercialDrainage(SignatureHistoryFragment.this.getBaseActivity().app.getCurrentUin(), "signature", "signature_10", "", 1, 0, 0, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class r implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f282236d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f282237e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f282238f;

        r(int i3, int i16, int i17) {
            this.f282236d = i3;
            this.f282237e = i16;
            this.f282238f = i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SignatureHistoryFragment.this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 0) {
                VasWebviewUtil.reportCommercialDrainage("signature_history", "sheet", "", 0, 0, 0, "", "", "" + this.f282236d, "", "", "", "", 0, 0, 0, 0);
                if (SignatureHistoryFragment.this.C.equals(SignatureHistoryFragment.this.D)) {
                    i16 = 49;
                } else {
                    i16 = 50;
                }
                a33.b.g(SignatureHistoryFragment.this.getBaseActivity(), SignatureHistoryFragment.this.getBaseActivity().app, 0, "signature_history", -1, this.f282237e, this.f282238f, null, i16);
            }
            if (SignatureHistoryFragment.this.B0 != null) {
                SignatureHistoryFragment.this.B0.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class s implements ActionSheet.OnDismissListener {
        static IPatchRedirector $redirector_;

        s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SignatureHistoryFragment.this.B0 = null;
                VasWebviewUtil.reportCommercialDrainage("signature_history", "sheet", "", 0, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class t extends BaseAdapter {
        static IPatchRedirector $redirector_;

        t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            int size = SignatureHistoryFragment.this.f282188q0.size();
            if (size == 0) {
                return 1;
            }
            return size + 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            if (i3 >= SignatureHistoryFragment.this.f282188q0.size()) {
                return null;
            }
            return SignatureHistoryFragment.this.f282188q0.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
            }
            return getItemViewType(i3);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
            }
            int size = SignatureHistoryFragment.this.f282188q0.size();
            if (size == 0) {
                return 2;
            }
            if (i3 < size) {
                return 0;
            }
            return 1;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View ui5;
            View view2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                view2 = view;
                ui5 = (View) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                int itemViewType = getItemViewType(i3);
                if (itemViewType == 2) {
                    SignatureHistoryFragment.this.N.setLayoutParams(new AbsListView.LayoutParams(SignatureHistoryFragment.this.F.getWidth(), SignatureHistoryFragment.this.F.getHeight()));
                    ui5 = SignatureHistoryFragment.this.N;
                } else {
                    ui5 = itemViewType == 0 ? SignatureHistoryFragment.this.ui(i3, view) : SignatureHistoryFragment.this.wi(view);
                }
                view2 = ui5;
            }
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return ui5;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return 3;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
            }
            if (2 != getItemViewType(i3)) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class u {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ProgressBar f282242a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f282243b;

        public u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class v extends da {
        static IPatchRedirector $redirector_;

        v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.da
        protected void a(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (SignatureHistoryFragment.this.f282190s0 != null && SignatureHistoryFragment.this.f282190s0.isShowing()) {
                SignatureHistoryFragment.this.f282190s0.dismiss();
            }
            if (z16) {
                long longValue = ((Long) obj).longValue();
                if (SignatureHistoryFragment.this.f282187p0 != null) {
                    SignatureHistoryFragment.this.f282187p0.f282319id = longValue;
                    SignatureHistoryFragment.this.f282187p0.timeStamp = NetConnInfoCenter.getServerTimeMillis() / 1000;
                    SignatureHistoryFragment signatureHistoryFragment = SignatureHistoryFragment.this;
                    signatureHistoryFragment.gi(signatureHistoryFragment.f282187p0);
                    SignatureHistoryFragment.this.f282187p0 = null;
                    if (SignatureHistoryFragment.this.f282180i0 != null) {
                        SignatureHistoryFragment.this.f282180i0.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                return;
            }
            Message obtainMessage = SignatureHistoryFragment.this.f282181j0.obtainMessage();
            obtainMessage.what = 4;
            obtainMessage.arg1 = 1;
            SignatureHistoryFragment.this.f282181j0.sendMessage(obtainMessage);
        }

        @Override // com.tencent.mobileqq.app.da
        protected void b(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (SignatureHistoryFragment.this.f282190s0 != null && SignatureHistoryFragment.this.f282190s0.isShowing()) {
                SignatureHistoryFragment.this.f282190s0.dismiss();
            }
            if (z16) {
                SignatureHistoryFragment signatureHistoryFragment = SignatureHistoryFragment.this;
                boolean ri5 = signatureHistoryFragment.ri(signatureHistoryFragment.f282187p0);
                SignatureHistoryFragment.this.f282187p0 = null;
                if (SignatureHistoryFragment.this.f282180i0 != null && ri5) {
                    SignatureHistoryFragment.this.f282180i0.notifyDataSetChanged();
                    return;
                }
                return;
            }
            Message obtainMessage = SignatureHistoryFragment.this.f282181j0.obtainMessage();
            obtainMessage.what = 4;
            obtainMessage.arg1 = 2;
            SignatureHistoryFragment.this.f282181j0.sendMessage(obtainMessage);
        }

        @Override // com.tencent.mobileqq.app.da
        protected void d(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), obj);
                return;
            }
            SignatureHandler.RspGetHistorySig rspGetHistorySig = (SignatureHandler.RspGetHistorySig) obj;
            SignatureHistoryFragment.this.Vi(z16, rspGetHistorySig);
            if (z16) {
                SignatureHistoryFragment.this.Ki(rspGetHistorySig);
            } else if (SignatureHistoryFragment.this.f282186o0) {
                SignatureHistoryFragment.this.f282179h0 = 3;
            }
            if (SignatureHistoryFragment.this.f282188q0.size() == 0) {
                SignatureHistoryFragment signatureHistoryFragment = SignatureHistoryFragment.this;
                if (z16) {
                    i3 = 3;
                }
                signatureHistoryFragment.Ui(i3);
            } else {
                SignatureHistoryFragment.this.R.setVisible(false, false);
            }
            if (SignatureHistoryFragment.this.f282180i0 != null) {
                SignatureHistoryFragment.this.f282180i0.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.app.da
        protected void e(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
                return;
            }
            int intValue = ((Integer) obj).intValue();
            if (SignatureHistoryFragment.this.f282181j0 != null) {
                SignatureHistoryFragment.this.f282181j0.removeMessages(3);
                Message obtainMessage = SignatureHistoryFragment.this.f282181j0.obtainMessage(3);
                obtainMessage.arg1 = intValue;
                SignatureHistoryFragment.this.f282181j0.sendMessageDelayed(obtainMessage, 500L);
            }
        }

        @Override // com.tencent.mobileqq.app.da
        protected void i(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (z16) {
                Bundle bundle = (Bundle) obj;
                boolean z17 = bundle.getBoolean("firstFlag", false);
                String string = bundle.getString("feedid");
                boolean z18 = bundle.getBoolean("overFlag", true);
                ArrayList<String> stringArrayList = bundle.getStringArrayList("uins");
                SignatureHistoryFragment.this.f282183l0.put(string, Boolean.valueOf(z18));
                ArrayList arrayList = (ArrayList) SignatureHistoryFragment.this.f282182k0.get(string);
                if (stringArrayList == null) {
                    return;
                }
                SignatureHistoryFragment.this.f282182k0.put(string, arrayList);
                synchronized (SignatureHistoryFragment.this.f282188q0) {
                    while (true) {
                        if (i3 >= SignatureHistoryFragment.this.f282188q0.size()) {
                            break;
                        }
                        RichStatus richStatus = ((HistorySignItem) SignatureHistoryFragment.this.f282188q0.get(i3)).richStatus;
                        if (richStatus.feedsId.equals(string)) {
                            if (z17) {
                                richStatus.mUins = null;
                            }
                            if (richStatus.mUins != null) {
                                Iterator<String> it = stringArrayList.iterator();
                                while (it.hasNext()) {
                                    String next = it.next();
                                    if (!richStatus.mUins.contains(next)) {
                                        richStatus.mUins.add(next);
                                    }
                                }
                            } else {
                                richStatus.mUins = stringArrayList;
                            }
                        } else {
                            i3++;
                        }
                    }
                    if (SignatureHistoryFragment.this.f282181j0 != null) {
                        SignatureHistoryFragment.this.f282181j0.removeMessages(1);
                        SignatureHistoryFragment.this.f282181j0.sendMessageDelayed(SignatureHistoryFragment.this.f282181j0.obtainMessage(1), 500L);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class w extends com.tencent.mobileqq.richstatus.m {
        static IPatchRedirector $redirector_;

        w() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.m
        protected void c(boolean z16, List<byte[]> list, List<Integer> list2) {
            Object valueOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list, list2);
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onDeleteStatus. isSuccess=");
                sb5.append(z16);
                sb5.append(", keyListSize=");
                sb5.append(list.size());
                sb5.append(", errorCodeSize=");
                if (list2 == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(list2.size());
                }
                sb5.append(valueOf);
                QLog.d("SignatureHistoryFragment", 2, sb5.toString());
            }
            SignatureHistoryFragment.this.Si(z16, list);
            if (z16 && SignatureHistoryFragment.this.getBaseActivity() != null) {
                BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putBoolean(SignatureHistoryFragment.this.D + "_has_history_sig_del_key", true).apply();
                SignatureHistoryFragment signatureHistoryFragment = SignatureHistoryFragment.this;
                SignatureHandler signatureHandler = signatureHistoryFragment.f282191t0;
                if (signatureHandler != null) {
                    signatureHandler.H2(Long.parseLong(signatureHistoryFragment.C));
                }
            }
        }
    }

    public SignatureHistoryFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f282177f0 = 0;
        this.f282179h0 = 0;
        this.f282182k0 = new HashMap<>();
        this.f282183l0 = new HashMap<>();
        this.f282184m0 = new ArrayList<>();
        this.f282189r0 = false;
        this.f282196y0 = false;
        this.f282197z0 = false;
        this.A0 = new HashSet<>();
        this.C0 = new d();
        this.D0 = new e();
        this.E0 = new f();
        this.F0 = new m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ai(String str) {
        AllInOne allInOne;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (getActivity() != null && !TextUtils.isEmpty(getBaseActivity().getCurrentAccountUin()) && getBaseActivity().getCurrentAccountUin().equals(str)) {
            allInOne = new AllInOne(str, 0);
        } else if (Hi(str)) {
            allInOne = new AllInOne(str, 1);
        } else {
            allInOne = new AllInOne(str, 19);
        }
        ProfileUtils.openProfileCard(getActivity(), allInOne);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Bi(View view, boolean z16) {
        if (!this.X && !this.Y && this.f282175d0.getVisibility() != 0) {
            return false;
        }
        EditText editText = this.f282172a0;
        if (editText != null && z16) {
            editText.setText("");
        }
        this.Y = false;
        this.X = false;
        InputMethodUtil.hide(view);
        this.f282175d0.setVisibility(8);
        this.f282176e0.setVisibility(8);
        this.f282176e0.setVisibility(8);
        this.f282176e0.removeOnLayoutChangeListener(this.F0);
        return true;
    }

    private void Ci() {
        RelativeLayout relativeLayout = (RelativeLayout) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f166807do2);
        this.f282176e0 = relativeLayout;
        relativeLayout.setVisibility(8);
        EditText editText = (EditText) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.byq);
        this.f282172a0 = editText;
        editText.setEditableFactory(new n());
        this.f282172a0.addTextChangedListener(new o());
        Button button = (Button) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.ajw);
        this.f282173b0 = button;
        button.setOnClickListener(this);
        this.f282173b0.setEnabled(!TextUtils.isEmpty(r0.getText()));
    }

    private void Di(View view, HistorySignItem historySignItem, com.tencent.mobileqq.richstatus.sign.a aVar) {
        CommentsView commentsView = (CommentsView) view.findViewById(R.id.a3s);
        aVar.f282414k0 = commentsView;
        commentsView.setOnSpanItemClick(new b());
        aVar.f282414k0.setOnItemClickListener(new CommentsView.d(historySignItem) { // from class: com.tencent.mobileqq.richstatus.SignatureHistoryFragment.12
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ HistorySignItem f282198a;

            {
                this.f282198a = historySignItem;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this, (Object) historySignItem);
                }
            }

            @Override // com.tencent.mobileqq.richstatus.comment.widget.CommentsView.d
            public void a(int i3, View view2) {
                List<CommentItem> list;
                CommentItem commentItem;
                com.tencent.mobileqq.richstatus.comment.bean.b bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) view2);
                    return;
                }
                if (!SignatureHistoryFragment.this.f282196y0 && (list = this.f282198a.commentItemList) != null && list.size() > i3 && (bVar = (commentItem = list.get(i3)).user) != null && !TextUtils.isEmpty(bVar.f282322a)) {
                    if (bVar.f282322a.equals(SignatureHistoryFragment.this.D)) {
                        SignatureHistoryFragment signatureHistoryFragment = SignatureHistoryFragment.this;
                        signatureHistoryFragment.Ri(commentItem, signatureHistoryFragment.D);
                        return;
                    }
                    SignatureHistoryFragment.this.f282175d0.setVisibility(0);
                    SignatureHistoryFragment.this.f282176e0.setVisibility(0);
                    SignatureHistoryFragment.this.f282172a0.requestFocus();
                    SignatureHistoryFragment.this.f282172a0.setHint(String.format(SignatureHistoryFragment.this.getString(R.string.f170243k2), SignatureHistoryFragment.this.vi(bVar.f282322a)));
                    SignatureHistoryFragment.this.Ni(true);
                    int yi5 = SignatureHistoryFragment.this.yi(view2);
                    int height = view2.getHeight();
                    SignatureHistoryFragment signatureHistoryFragment2 = SignatureHistoryFragment.this;
                    signatureHistoryFragment2.f282185n0 = view2;
                    signatureHistoryFragment2.f282181j0.postDelayed(new Runnable(yi5, height) { // from class: com.tencent.mobileqq.richstatus.SignatureHistoryFragment.12.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f282200d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ int f282201e;

                        {
                            this.f282200d = yi5;
                            this.f282201e = height;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass12.this, Integer.valueOf(yi5), Integer.valueOf(height));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                SignatureHistoryFragment.this.Qi(this.f282200d, this.f282201e, true);
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    }, 200L);
                    SignatureHistoryFragment.this.f282187p0 = new CommentItem();
                    SignatureHistoryFragment.this.f282187p0.targetId = commentItem.f282319id;
                    SignatureHistoryFragment.this.f282187p0.feedId = commentItem.feedId;
                    SignatureHistoryFragment.this.f282187p0.toReplyUser = commentItem.user;
                    CommentItem commentItem2 = SignatureHistoryFragment.this.f282187p0;
                    String str = SignatureHistoryFragment.this.D;
                    SignatureHistoryFragment signatureHistoryFragment3 = SignatureHistoryFragment.this;
                    commentItem2.user = new com.tencent.mobileqq.richstatus.comment.bean.b(str, signatureHistoryFragment3.f282191t0.K2(Long.valueOf(signatureHistoryFragment3.D).longValue()));
                }
            }
        });
        aVar.f282414k0.setOnItemLongClickListener(new c(historySignItem));
    }

    private void Ei(HistorySignItem historySignItem, com.tencent.mobileqq.richstatus.sign.a aVar) {
        RichStatus richStatus;
        String str;
        RichStatus richStatus2;
        String str2;
        if (historySignItem != null && (richStatus2 = historySignItem.richStatus) != null && (str2 = richStatus2.feedsId) != null) {
            aVar.f282413j0.setTag(str2);
        } else {
            aVar.f282413j0.setTag("");
        }
        if (this.f282196y0) {
            aVar.f282413j0.setVisibility(0);
            aVar.f282413j0.setOnClickListener(this.D0);
        } else {
            aVar.f282413j0.setVisibility(8);
        }
        if (historySignItem != null && (richStatus = historySignItem.richStatus) != null && (str = richStatus.feedsId) != null) {
            if (this.f282184m0.contains(str)) {
                aVar.f282413j0.setChecked(true);
                return;
            } else {
                aVar.f282413j0.setChecked(false);
                return;
            }
        }
        aVar.f282413j0.setChecked(false);
    }

    private void Fi(Integer num, int i3, int i16, boolean z16) {
        this.B0 = ActionSheet.create(getBaseActivity());
        int i17 = 1;
        if (num.intValue() == 2) {
            this.B0.addRadioButton(R.string.f170870cl3, false);
        } else if (z16) {
            if (i3 > 1) {
                this.B0.addRadioButton(R.string.ckq, false);
                i17 = 3;
            } else {
                this.B0.addRadioButton(R.string.cks, false);
                i17 = 2;
            }
        } else {
            this.B0.addRadioButton(R.string.cj_, false);
            i17 = 4;
        }
        this.B0.addCancelButton(R.string.cancel);
        this.B0.show();
        this.B0.setOnButtonClickListener(new r(i17, i3, i16));
        this.B0.setOnDismissListener(new s());
    }

    private void Gi() {
        this.X = false;
        this.Y = false;
        if (getTitleBarView() != null) {
            getTitleBarView().setVisibility(8);
        }
        if (getBaseActivity() != null && getBaseActivity().getWindow() != null) {
            getBaseActivity().getWindow().setSoftInputMode(16);
            getBaseActivity().getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.f162143yn));
            if (ImmersiveUtils.isSupporImmersive() != 0) {
                SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp((PublicFragmentActivity) getBaseActivity());
                systemBarComp.init();
                if (ImmersiveUtils.couldSetStatusTextColor()) {
                    ImmersiveUtils.setStatusTextColor(true, getBaseActivity().getWindow());
                    systemBarComp.setStatusBarColor(getResources().getColor(R.color.ajr));
                } else {
                    systemBarComp.setStatusBarColor(SimpleUIUtil.SIMPLE_UI_STATUS_BAR_COLOR_PRE_M);
                }
            }
        }
    }

    private void Ii(SignatureHandler.RspGetHistorySig rspGetHistorySig) {
        boolean z16 = rspGetHistorySig.over;
        List<HistorySignItem> list = rspGetHistorySig.historySignItems;
        if (this.f282186o0 && this.f282188q0.size() > 0) {
            this.f282188q0.clear();
        }
        if (this.f282188q0.size() > 0) {
            Iterator<HistorySignItem> it = list.iterator();
            RichStatus richStatus = this.f282188q0.get(r2.size() - 1).richStatus;
            if (richStatus != null) {
                while (it.hasNext()) {
                    RichStatus richStatus2 = it.next().richStatus;
                    long j3 = richStatus2.time;
                    long j16 = richStatus.time;
                    if (j3 <= j16 && (j3 != j16 || !Arrays.equals(richStatus2.encode(), richStatus.encode()))) {
                        break;
                    } else {
                        it.remove();
                    }
                }
            }
        }
        ArrayList<HistorySignItem> arrayList = this.f282188q0;
        arrayList.addAll(arrayList.size(), list);
        this.f282179h0 = !z16 ? 1 : 0;
    }

    private void Ji(Message message) {
        stopTitleProgress();
        this.F.springBackOverScrollHeaderView();
        if (message.arg1 == 1) {
            if (this.f282188q0.size() == 0) {
                Ui(2);
            }
            Xi(1, R.string.hqe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ki(SignatureHandler.RspGetHistorySig rspGetHistorySig) {
        if (getBaseActivity() != null && getBaseActivity().app != null) {
            getBaseActivity().app.setVisibilityForStatus(true, true);
        }
        if (rspGetHistorySig != null && rspGetHistorySig.historySignItems != null) {
            Ii(rspGetHistorySig);
        }
    }

    private void Li() {
        boolean z16 = !this.f282196y0;
        this.f282196y0 = z16;
        if (z16) {
            ReportController.o(null, "dc00898", "", "", "0X800A98B", "0X800A98B", 0, 0, "0", "0", "", "");
            qi(false);
            this.W.setText(R.string.b9f);
        } else {
            qi(false);
            this.W.setText(R.string.hmn);
            this.f282184m0.clear();
        }
        this.f282180i0.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mi(boolean z16) {
        if (z16) {
            if (this.X) {
                this.f282177f0 = 1;
                Ni(false);
                return;
            } else {
                hi();
                return;
            }
        }
        this.Y = false;
        this.f282174c0.setImageResource(R.drawable.skin_aio_panel_emotion_nor);
        this.f282174c0.setContentDescription(getBaseActivity().getString(R.string.f170519tm));
        this.f282174c0.setOnClickListener(new i());
        this.Z.getView().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ni(boolean z16) {
        if (z16) {
            Mi(false);
            InputMethodUtil.show(this.f282172a0);
        } else {
            InputMethodUtil.hide(this.f282172a0);
        }
    }

    private void Pi(boolean z16) {
        int firstVisiblePosition = this.F.getFirstVisiblePosition();
        int lastVisiblePosition = this.F.getLastVisiblePosition();
        int headerViewsCount = this.F.getHeaderViewsCount();
        for (int i3 = firstVisiblePosition - 1; i3 <= lastVisiblePosition; i3++) {
            View childAt = this.F.getChildAt((headerViewsCount + i3) - firstVisiblePosition);
            if (childAt != null && (childAt.getTag() instanceof com.tencent.mobileqq.richstatus.sign.a)) {
                com.tencent.mobileqq.richstatus.sign.a aVar = (com.tencent.mobileqq.richstatus.sign.a) childAt.getTag();
                aVar.w(z16);
                ETTextView eTTextView = aVar.D;
                if (eTTextView != null) {
                    if (z16) {
                        eTTextView.T();
                    } else {
                        eTTextView.f32619o0 = true;
                        eTTextView.X(false, false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qi(int i3, int i16, boolean z16) {
        this.f282181j0.post(new Runnable(i3, yi(this.f282176e0), i16, z16) { // from class: com.tencent.mobileqq.richstatus.SignatureHistoryFragment.21
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f282203d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f282204e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f282205f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ boolean f282206h;

            {
                this.f282203d = i3;
                this.f282204e = r7;
                this.f282205f = i16;
                this.f282206h = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SignatureHistoryFragment.this, Integer.valueOf(i3), Integer.valueOf(r7), Integer.valueOf(i16), Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                SignatureHistoryFragment.this.F.smoothScrollBy(this.f282203d - (this.f282204e - this.f282205f), 100);
                if (this.f282206h) {
                    SignatureHistoryFragment.this.f282176e0.addOnLayoutChangeListener(SignatureHistoryFragment.this.F0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ri(CommentItem commentItem, String str) {
        ActionSheet create = ActionSheet.create(getBaseActivity());
        create.addButton(R.string.bbl, 3);
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new l(commentItem, str, create));
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Si(boolean z16, List<byte[]> list) {
        QQProgressDialog qQProgressDialog = this.f282190s0;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.f282190s0.dismiss();
        }
        if (z16 && list != null) {
            if (getBaseActivity() != null) {
                Xi(2, R.string.ak7);
            }
            pi(list);
            if (this.f282188q0.size() == 0) {
                Ui(3);
            }
            this.f282184m0.clear();
            this.f282196y0 = false;
            this.W.setText(R.string.hmn);
            qi(false);
            t tVar = this.f282180i0;
            if (tVar != null) {
                tVar.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (getBaseActivity() != null) {
            Xi(1, R.string.f171515fr2);
        }
    }

    private void Ti(View view) {
        boolean z16;
        int i3;
        int i16 = 0;
        this.f282197z0 = false;
        Object tag = view.getTag(R.id.dwv);
        if (tag == null) {
            try {
                tag = 0;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        boolean z17 = true;
        if (view.getTag(R.id.ivt) != null) {
            i3 = ((Integer) view.getTag(R.id.ivt)).intValue();
            if (i3 > 1) {
                z16 = true;
            } else {
                z16 = false;
            }
        } else {
            z16 = false;
            i3 = 1;
        }
        if (view.getTag(R.id.ivp) == null || (i16 = ((Integer) view.getTag(R.id.ivp)).intValue()) <= 0) {
            z17 = z16;
        }
        ActionSheet actionSheet = this.B0;
        if (actionSheet != null && actionSheet.isShowing()) {
            return;
        }
        Fi((Integer) tag, i3, i16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ui(int i3) {
        if (i3 == 1) {
            this.P.setText(HardCodeUtil.qqStr(R.string.tji));
            this.Q.setImageDrawable(this.R);
            this.R.setVisible(true, true);
        } else {
            this.R.setVisible(false, false);
            this.Q.setImageResource(R.drawable.h2c);
            if (i3 == 3) {
                this.P.setText(HardCodeUtil.qqStr(R.string.tj_));
            } else {
                this.P.setText(HardCodeUtil.qqStr(R.string.tje));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vi(boolean z16, SignatureHandler.RspGetHistorySig rspGetHistorySig) {
        stopTitleProgress();
        int i3 = 0;
        if (z16) {
            this.f282181j0.sendEmptyMessageDelayed(0, 1000L);
            return;
        }
        if (rspGetHistorySig != null) {
            i3 = rspGetHistorySig.resultFieldNumber;
        }
        if (i3 != 2) {
            Xi(1, R.string.hqe);
        } else {
            Xi(1, R.string.f229466wi);
        }
        this.F.springBackOverScrollHeaderView();
    }

    private void Yi() {
        if (!TextUtils.isEmpty(this.C) && !this.f282196y0) {
            Ai(this.C);
        }
    }

    private void Zi(Message message) {
        int i3 = message.arg1;
        if (i3 == 1) {
            Xi(1, R.string.f171966mf2);
        } else if (i3 == 2) {
            Xi(1, R.string.dxc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bj(ArrayList<String> arrayList, boolean z16) {
        ArrayList<HistorySignItem> arrayList2;
        Iterator<String> it = this.f282184m0.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && (arrayList2 = this.f282188q0) != null && !arrayList2.isEmpty() && this.f282188q0.get(0).richStatus != null && this.f282188q0.get(0).richStatus.feedsId != null) {
                if (next.equals(new String(this.f282188q0.get(0).richStatus.feedsId))) {
                    z16 = true;
                }
                arrayList.add(next);
            }
        }
        return z16;
    }

    private void cj() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richstatus.SignatureHistoryFragment.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SignatureHistoryFragment.this);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x00ab  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x00b8  */
            /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                QQAppInterface qQAppInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.DEL_MSG, 2, "get ower head is called,time is:" + System.currentTimeMillis());
                }
                if (SignatureHistoryFragment.this.getBaseActivity() == null || (qQAppInterface = SignatureHistoryFragment.this.getBaseActivity().app) == null) {
                    return;
                }
                int dimensionPixelSize = SignatureHistoryFragment.this.getResources().getDimensionPixelSize(R.dimen.f159025u8);
                Bitmap bitmap = null;
                if (qQAppInterface.getCurrentAccountUin().equals(SignatureHistoryFragment.this.C)) {
                    try {
                        String tempAvatarFilePath = FaceUtil.getTempAvatarFilePath();
                        File file = new File(tempAvatarFilePath);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        FileInputStream fileInputStream = new FileInputStream(file);
                        options.inSampleSize = (int) BaseImageUtil.getOptRatio(fileInputStream, dimensionPixelSize, dimensionPixelSize);
                        fileInputStream.close();
                        Bitmap d16 = com.tencent.mobileqq.util.j.d(tempAvatarFilePath, options);
                        if (d16 != null) {
                            try {
                                d16 = QQAppInterface.getCircleFaceBitmap(d16, d16.getWidth(), d16.getHeight());
                            } catch (Exception e16) {
                                e = e16;
                                bitmap = d16;
                                if (QLog.isColorLevel()) {
                                    QLog.d("SignatureHistoryFragment", 2, e.toString());
                                }
                                if (bitmap == null) {
                                }
                                if (bitmap == null) {
                                }
                            }
                        }
                        bitmap = d16;
                    } catch (Exception e17) {
                        e = e17;
                    }
                }
                if (bitmap == null) {
                    bitmap = qQAppInterface.getFaceBitmap(SignatureHistoryFragment.this.C, true);
                }
                if (bitmap == null) {
                    Message obtainMessage = SignatureHistoryFragment.this.f282181j0.obtainMessage(2);
                    obtainMessage.obj = bitmap;
                    SignatureHistoryFragment.this.f282181j0.sendMessage(obtainMessage);
                }
            }
        });
    }

    private void dj(Message message) {
        if (isAdded()) {
            if (message.arg1 >= 0) {
                this.K.setVisibility(0);
                this.K.setText(String.format(getString(R.string.vrw), Integer.valueOf(message.arg1)));
            } else {
                this.K.setVisibility(8);
            }
        }
    }

    private boolean ej(String str, int i3, HistorySignItem historySignItem, List<com.tencent.mobileqq.richstatus.comment.bean.a> list) {
        if (i3 == 1 && list == null) {
            list = new ArrayList<>();
        }
        if (list != null && !TextUtils.isEmpty(str)) {
            if (i3 == 0) {
                Iterator<com.tencent.mobileqq.richstatus.comment.bean.a> it = list.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.richstatus.comment.bean.b bVar = it.next().f282321b;
                    if (bVar != null && str.equals(bVar.f282322a)) {
                        it.remove();
                        historySignItem.totalLikeNum--;
                        return true;
                    }
                }
                return false;
            }
            list.add(0, new com.tencent.mobileqq.richstatus.comment.bean.a(NetConnInfoCenter.getServerTime() / 1000, new com.tencent.mobileqq.richstatus.comment.bean.b(str, vi(str))));
            historySignItem.totalLikeNum++;
        }
        return true;
    }

    private void fj(String str, String str2, int i3) {
        ArrayList<HistorySignItem> arrayList;
        if (str != null && !TextUtils.isEmpty(str) && (arrayList = this.f282188q0) != null && arrayList.size() > 0) {
            Iterator<HistorySignItem> it = this.f282188q0.iterator();
            while (it.hasNext()) {
                HistorySignItem next = it.next();
                RichStatus richStatus = next.richStatus;
                if (richStatus != null && str.equals(richStatus.feedsId) && ej(str2, i3, next, next.likeItemList)) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi(CommentItem commentItem) {
        ArrayList<HistorySignItem> arrayList;
        if (commentItem != null && !TextUtils.isEmpty(commentItem.feedId) && (arrayList = this.f282188q0) != null && arrayList.size() > 0) {
            Iterator<HistorySignItem> it = this.f282188q0.iterator();
            while (it.hasNext()) {
                HistorySignItem next = it.next();
                RichStatus richStatus = next.richStatus;
                if (richStatus != null && commentItem.feedId.equals(richStatus.feedsId)) {
                    if (next.commentItemList == null) {
                        next.commentItemList = new ArrayList();
                    }
                    next.commentItemList.add(commentItem);
                }
            }
        }
    }

    private void gj() {
        String str = this.E;
        if (str == null) {
            return;
        }
        if (str.length() == 0) {
            str = String.valueOf(this.C);
        }
        this.J.setText(str);
        this.J.invalidate();
        String str2 = getBaseActivity().getString(R.string.ab7) + ":";
        this.J.setContentDescription(str2 + str);
    }

    private void hi() {
        this.Y = true;
        this.f282174c0.setImageResource(R.drawable.f160027bz1);
        this.f282174c0.setContentDescription(getBaseActivity().getString(R.string.f170520tn));
        this.f282174c0.setOnClickListener(new k());
        this.Z.getView().setVisibility(0);
        int i3 = this.f282178g0;
        int i16 = ScreenUtil.SCREEN_HIGHT;
        if (i3 <= i16 / 4) {
            i3 = i16 / 3;
        }
        ViewGroup.LayoutParams layoutParams = this.Z.getView().getLayoutParams();
        layoutParams.height = i3;
        this.Z.getView().setMinimumHeight(layoutParams.height);
        this.Z.getView().setLayoutParams(layoutParams);
        ((RelativeLayout.LayoutParams) this.f282176e0.getLayoutParams()).bottomMargin = i3;
        this.f282177f0 = 0;
    }

    private void ii(View view, com.tencent.mobileqq.richstatus.sign.b bVar) {
        RichStatus richStatus;
        if (this.f282196y0) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A989", "0X800A989", 0, 0, "0", "0", "", "");
        this.f282175d0.setVisibility(0);
        this.f282176e0.setVisibility(0);
        this.f282172a0.requestFocus();
        this.f282172a0.setHint(R.string.fda);
        Ni(true);
        int yi5 = yi(view);
        int height = view.getHeight();
        this.f282185n0 = view;
        this.f282181j0.postDelayed(new Runnable(yi5, height) { // from class: com.tencent.mobileqq.richstatus.SignatureHistoryFragment.9
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f282207d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f282208e;

            {
                this.f282207d = yi5;
                this.f282208e = height;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SignatureHistoryFragment.this, Integer.valueOf(yi5), Integer.valueOf(height));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    SignatureHistoryFragment.this.Qi(this.f282207d, this.f282208e, true);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 200L);
        if ((bVar instanceof com.tencent.mobileqq.richstatus.sign.a) && (richStatus = ((com.tencent.mobileqq.richstatus.sign.a) bVar).f282412i0) != null && getBaseActivity() != null && getBaseActivity().app != null) {
            CommentItem commentItem = new CommentItem();
            this.f282187p0 = commentItem;
            commentItem.targetId = 0L;
            commentItem.feedId = richStatus.feedsId;
            commentItem.toReplyUser = null;
            String str = this.D;
            commentItem.user = new com.tencent.mobileqq.richstatus.comment.bean.b(str, this.f282191t0.K2(Long.valueOf(str).longValue()));
        }
    }

    private void ji() {
        if (this.f282187p0 != null && getBaseActivity() != null) {
            ((ClipboardManager) getBaseActivity().getSystemService("clipboard")).setText(this.f282187p0.content);
            this.f282187p0 = null;
        }
    }

    private void ki() {
        if (!NetworkUtil.isNetSupport(getBaseActivity())) {
            QQToast.makeText(getBaseActivity(), R.string.bqf, 0).show();
            return;
        }
        if (this.f282187p0 != null && !TextUtils.isEmpty(this.C) && !TextUtils.isEmpty(this.D)) {
            if (this.f282190s0 == null) {
                this.f282190s0 = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
            }
            this.f282190s0.setMessage((String) null);
            this.f282190s0.show();
            this.f282191t0.E2(Long.valueOf(this.C).longValue(), this.f282187p0.feedId, Long.valueOf(this.D).longValue(), this.f282187p0.f282319id);
        }
    }

    private void li() {
        if (this.f282196y0) {
            synchronized (this.f282184m0) {
                if (this.f282184m0.isEmpty()) {
                    return;
                }
                if (!NetworkUtil.isNetSupport(getBaseActivity())) {
                    QQToast.makeText(getBaseActivity(), getString(R.string.b3j), 0).show();
                    return;
                } else {
                    ReportController.o(null, "dc00898", "", "", "0X800A98C", "0X800A98C", 0, 0, "0", "0", "", "");
                    xi().show();
                    return;
                }
            }
        }
        VasWebviewUtil.reportCommercialDrainage("signature_history", "edit_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        if ("history-geqian".equals(getBaseActivity().getIntent().getStringExtra("key_open_via"))) {
            getBaseActivity().finish();
        } else {
            a33.b.d(getBaseActivity(), getBaseActivity().app, 0, "signature_history");
        }
    }

    private void mi(View view) {
        EditText editText = this.f282172a0;
        if (editText != null) {
            String obj = editText.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                if (!NetworkUtil.isNetSupport(getBaseActivity())) {
                    QQToast.makeText(getBaseActivity(), getString(R.string.b3j), 0).show();
                    return;
                }
                CommentItem commentItem = this.f282187p0;
                if (commentItem != null) {
                    commentItem.content = obj;
                    if (this.f282191t0 != null) {
                        if (this.f282190s0 == null) {
                            this.f282190s0 = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
                        }
                        this.f282190s0.setMessage((String) null);
                        this.f282190s0.show();
                        SignatureHandler signatureHandler = this.f282191t0;
                        long longValue = Long.valueOf(this.C).longValue();
                        CommentItem commentItem2 = this.f282187p0;
                        signatureHandler.D2(longValue, commentItem2.feedId, commentItem2.targetId, Long.valueOf(this.D).longValue(), this.f282187p0.content);
                    }
                    Bi(view, true);
                }
            }
        }
    }

    private void ni(com.tencent.mobileqq.richstatus.sign.b bVar) {
        if (this.f282196y0) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A988", "0X800A988", 0, 0, "0", "0", "", "");
        int i3 = 0;
        if (!NetworkUtil.isNetSupport(getBaseActivity())) {
            QQToast.makeText(getBaseActivity(), R.string.bqf, 0).show();
            return;
        }
        if (bVar instanceof com.tencent.mobileqq.richstatus.sign.a) {
            com.tencent.mobileqq.richstatus.sign.a aVar = (com.tencent.mobileqq.richstatus.sign.a) bVar;
            if (aVar.M == 0) {
                i3 = 1;
                aVar.M = 1;
            } else {
                aVar.M = 0;
            }
            RichStatus richStatus = aVar.f282412i0;
            if (richStatus != null && !TextUtils.isEmpty(richStatus.feedsId)) {
                fj(aVar.f282412i0.feedsId, this.D, aVar.M);
                t tVar = this.f282180i0;
                if (tVar != null) {
                    tVar.notifyDataSetChanged();
                }
                SignatureHandler signatureHandler = this.f282191t0;
                if (signatureHandler != null) {
                    signatureHandler.d3(this.C, aVar.f282412i0.feedsId, 255, i3);
                }
            }
        }
    }

    private void pi(List<byte[]> list) {
        RichStatus richStatus;
        for (byte[] bArr : list) {
            Iterator<HistorySignItem> it = this.f282188q0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                HistorySignItem next = it.next();
                if (next != null && (richStatus = next.richStatus) != null && richStatus.feedsId.equals(new String(bArr))) {
                    it.remove();
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qi(boolean z16) {
        if (z16) {
            this.T.setVisibility(8);
            return;
        }
        if (this.f282196y0) {
            this.T.setVisibility(0);
            this.S.setType(3);
            ArrayList<String> arrayList = this.f282184m0;
            if (arrayList != null && !arrayList.isEmpty()) {
                this.S.setText(String.format(getBaseActivity().getResources().getString(R.string.vy8), Integer.valueOf(this.f282184m0.size())));
                this.S.setOnTouchListener(ba.f77070d);
                return;
            } else {
                this.S.setTextColor(getBaseActivity().getResources().getColor(R.color.qui_common_text_secondary));
                this.S.setText(getString(R.string.hml));
                this.S.setOnTouchListener(null);
                return;
            }
        }
        if (this.C.equals(this.D)) {
            this.T.setVisibility(0);
            this.S.setText(getString(R.string.h2n));
            this.S.setType(0);
            return;
        }
        this.T.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ri(CommentItem commentItem) {
        ArrayList<HistorySignItem> arrayList;
        if (commentItem != null && !TextUtils.isEmpty(commentItem.feedId) && (arrayList = this.f282188q0) != null && arrayList.size() > 0) {
            Iterator<HistorySignItem> it = this.f282188q0.iterator();
            while (it.hasNext()) {
                if (si(commentItem, it.next())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean si(CommentItem commentItem, HistorySignItem historySignItem) {
        List<CommentItem> list;
        RichStatus richStatus = historySignItem.richStatus;
        if (richStatus != null && commentItem.feedId.equals(richStatus.feedsId) && (list = historySignItem.commentItemList) != null && list.size() > 0) {
            Iterator<CommentItem> it = historySignItem.commentItemList.iterator();
            while (it.hasNext()) {
                if (it.next().f282319id == commentItem.f282319id) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static IEmoticonMainPanel ti(QQAppInterface qQAppInterface, BaseActivity baseActivity, View view, int i3, EditText editText) {
        IEmoticonMainPanel iEmoticonMainPanel = (IEmoticonMainPanel) view.findViewById(i3);
        iEmoticonMainPanel.setCallBack(new g(editText, qQAppInterface, baseActivity));
        iEmoticonMainPanel.setDisableGuide(true);
        iEmoticonMainPanel.setDisableMoreEmotionButton(true);
        iEmoticonMainPanel.setHasBigEmotion(false);
        iEmoticonMainPanel.setOnlySysAndEmoji(true);
        iEmoticonMainPanel.setDisableAutoDownload(true);
        iEmoticonMainPanel.init(qQAppInterface, 100002, baseActivity, baseActivity.getTitleBarHeight(), null, null, false, new h());
        iEmoticonMainPanel.setTabListOverScrollMode(2);
        return iEmoticonMainPanel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public View ui(int i3, View view) {
        com.tencent.mobileqq.richstatus.sign.a aVar;
        List<CommentItem> list;
        HistorySignItem historySignItem = this.f282188q0.get(i3);
        if (view == null) {
            View boxShadowLayout = new BoxShadowLayout(getBaseActivity());
            View oi5 = oi(boxShadowLayout);
            aVar = new com.tencent.mobileqq.richstatus.sign.a(getBaseActivity(), getBaseActivity().app, boxShadowLayout, this.C);
            this.A0.add(aVar);
            aVar.u(this);
            aVar.v(this);
            LinearLayout linearLayout = (LinearLayout) aVar.g();
            aVar.h().setOnTouchListener(this.C0);
            aVar.h().setOnClickListener(this);
            LayoutInflater.from(getBaseActivity()).inflate(R.layout.ae9, linearLayout);
            oi5.setTag(aVar);
            view = oi5;
        } else {
            aVar = (com.tencent.mobileqq.richstatus.sign.a) view.getTag();
        }
        aVar.f282413j0 = (CheckBox) view.findViewById(R.id.f164753as3);
        Di(view, historySignItem, aVar);
        LikesView likesView = (LikesView) view.findViewById(R.id.bmw);
        aVar.f282415l0 = likesView;
        likesView.setOnItemClickListener(new a());
        view.setTag(aVar);
        view.setClickable(true);
        Ei(historySignItem, aVar);
        aVar.f282411h0 = i3;
        aVar.P = this.C;
        RichStatus richStatus = historySignItem.richStatus;
        aVar.f282412i0 = richStatus;
        aVar.c(richStatus);
        List<com.tencent.mobileqq.richstatus.comment.bean.a> list2 = historySignItem.likeItemList;
        if ((list2 != null && list2.size() > 0) || ((list = historySignItem.commentItemList) != null && list.size() > 0)) {
            if (aVar.g() != null) {
                aVar.g().setVisibility(0);
                aVar.f282415l0.e(historySignItem.likeItemList, historySignItem.totalLikeNum);
                aVar.f282414k0.h(historySignItem.commentItemList);
            }
        } else if (aVar.g() != null) {
            aVar.g().setVisibility(8);
        }
        aVar.M = zi(historySignItem.likeItemList, this.D);
        aVar.G();
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public View wi(View view) {
        if (view == null) {
            view = getBaseActivity().getLayoutInflater().inflate(R.layout.f168308si, (ViewGroup) null);
            view.setBackgroundColor(getResources().getColor(R.color.ajr));
            view.setOnClickListener(null);
            u uVar = new u();
            view.setTag(uVar);
            uVar.f282242a = (ProgressBar) view.findViewById(R.id.i5n);
            view.findViewById(R.id.eex).setVisibility(8);
            TextView textView = (TextView) view.findViewById(R.id.f0v);
            uVar.f282243b = textView;
            textView.setTextColor(getResources().getColor(R.color.black));
        }
        if (this.f282179h0 == 1) {
            this.f282179h0 = 2;
            aj(false, false);
        }
        u uVar2 = (u) view.getTag();
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
        int i3 = this.f282179h0;
        if (i3 == 3) {
            view.setVisibility(0);
            uVar2.f282242a.setVisibility(8);
            uVar2.f282243b.setText(HardCodeUtil.qqStr(R.string.tj6));
            ((ViewGroup.LayoutParams) layoutParams).height = BaseAIOUtils.f(60.0f, getResources());
            view.setLayoutParams(layoutParams);
        } else if (i3 == 2) {
            view.setVisibility(0);
            uVar2.f282242a.setVisibility(0);
            uVar2.f282243b.setText(HardCodeUtil.qqStr(R.string.tis));
            ((ViewGroup.LayoutParams) layoutParams).height = BaseAIOUtils.f(60.0f, getResources());
            view.setLayoutParams(layoutParams);
        } else if (i3 == 0) {
            view.setVisibility(4);
            uVar2.f282242a.setVisibility(8);
            uVar2.f282243b.setVisibility(8);
            ((ViewGroup.LayoutParams) layoutParams).height = ScreenUtil.SCREEN_HIGHT / 4;
            view.setLayoutParams(layoutParams);
        }
        return view;
    }

    private QQCustomDialog xi() {
        return DialogUtil.createCustomDialog(getBaseActivity(), 230).setTitle(getString(R.string.vy7)).setPositiveButton(getString(R.string.a0s), new q()).setNegativeButton(getString(R.string.cancel), new p());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yi(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1];
    }

    private int zi(List<com.tencent.mobileqq.richstatus.comment.bean.a> list, String str) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<com.tencent.mobileqq.richstatus.comment.bean.a> it = list.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.richstatus.comment.bean.b bVar = it.next().f282321b;
                if (bVar != null && str.equals(bVar.f282322a)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.richstatus.sign.b.a
    public void He(View view, int i3, com.tencent.mobileqq.richstatus.sign.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, view, Integer.valueOf(i3), bVar);
            return;
        }
        QLog.d("SignatureHistoryFragment", 1, "onClick viewType=", view);
        if (i3 == 3) {
            ii(view, bVar);
            return;
        }
        if (i3 == 4) {
            ni(bVar);
        } else if (i3 == 2 && (bVar instanceof com.tencent.mobileqq.richstatus.sign.a) && this.B0 == null) {
            this.f282197z0 = true;
            Wi(((com.tencent.mobileqq.richstatus.sign.a) bVar).h());
        }
    }

    public boolean Hi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str)).booleanValue();
        }
        if (getBaseActivity() != null && getBaseActivity().app != null) {
            return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "SignatureHistoryFragment");
        }
        return false;
    }

    public void Oi(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
            return;
        }
        BaseActivity baseActivity = getBaseActivity();
        View findViewById = baseActivity.findViewById(R.id.f_1);
        if (z16) {
            if (findViewById == null) {
                View view = new View(getBaseActivity());
                view.setBackgroundColor(1996488704);
                view.setId(R.id.f_1);
                baseActivity.addContentView(view, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            findViewById.setVisibility(0);
            return;
        }
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public void Wi(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            if (this.C.equals(this.D)) {
                return;
            }
            VasWebviewUtil.reportCommercialDrainage("signature_history", "cove_click", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
            if (!this.f282197z0) {
                return;
            }
            Ti(view);
        }
    }

    protected void Xi(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (getBaseActivity() != null && getBaseActivity().isResume()) {
            QQToast.makeText(getBaseActivity(), i3, getResources().getString(i16), 0).show(getBaseActivity().getTitleBarHeight());
        }
    }

    protected void aj(boolean z16, boolean z17) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        QLog.d("SignatureHistoryFragment", 2, "updateData: refresh=" + z16 + " user=" + z17);
        if (NetworkUtil.isNetSupport(getBaseActivity())) {
            this.f282186o0 = z16;
            if (z16) {
                j3 = TTL.MAX_VALUE;
            } else {
                ArrayList<HistorySignItem> arrayList = this.f282188q0;
                j3 = arrayList.get(arrayList.size() - 1).richStatus.time - 1;
            }
            this.f282191t0.G2(Long.valueOf(this.C).longValue(), 0, (int) j3);
        } else {
            this.f282181j0.sendMessageDelayed(this.f282181j0.obtainMessage(0, 1, 0), 1000L);
            if (!z16) {
                this.f282179h0 = 3;
                t tVar = this.f282180i0;
                if (tVar != null) {
                    tVar.notifyDataSetChanged();
                }
            }
        }
        if (this.f282188q0.size() == 0) {
            Ui(1);
        }
        if (z17) {
            stopTitleProgress();
        } else if (z16) {
            startTitleProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.f282181j0 = new Handler(this);
        if (getBaseActivity() != null && getBaseActivity().app != null) {
            ((IFontManagerService) getBaseActivity().app.getRuntimeService(IFontManagerService.class, "")).addFontLoadCallback(this.E0);
            this.f282188q0 = new ArrayList<>();
            this.E = getBaseActivity().getIntent().getStringExtra("key_uin_name");
            this.C = getBaseActivity().getIntent().getStringExtra("key_uin");
            this.D = getBaseActivity().app.getCurrentUin();
            VasWebviewUtil.reportCommercialDrainage(getBaseActivity().app.getCurrentUin(), "signature", "signature_8", getBaseActivity().getIntent().getStringExtra("key_open_via"), 1, 0, 0, "", "", "");
            int i16 = 2;
            if (this.D.equalsIgnoreCase(this.C)) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            ReportController.o(getBaseActivity().app, "dc00898", "", "", "0X800A987", "0X800A987", i3, 0, "0", "0", "", "");
            this.leftView.setTextColor(getResources().getColor(R.color.black));
            this.leftView.setBackgroundDrawable(getResources().getDrawable(R.drawable.f160834no));
            this.centerView.setTextColor(getResources().getColor(R.color.black));
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getBaseActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int min = Math.min(x.c(getBaseActivity(), 260.0f), displayMetrics.widthPixels - x.c(getBaseActivity(), 69.0f));
            this.L = min;
            this.M = (min - x.c(getBaseActivity(), 70.0f)) / x.c(getBaseActivity(), 28.0f);
            this.f282192u0 = (SignatureManager) getBaseActivity().app.getManager(QQManagerFactory.SIGNATURE_MANAGER);
            this.f282193v0 = (StatusManager) getBaseActivity().app.getManager(QQManagerFactory.STATUS_MANAGER);
            this.f282191t0 = (SignatureHandler) getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
            this.f282194w0 = new w();
            getBaseActivity().app.registObserver(this.f282194w0);
            this.f282195x0 = new v();
            getBaseActivity().app.addObserver(this.f282195x0);
            TextView textView = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.e9y);
            this.V = textView;
            textView.setText(R.string.vy9);
            TextView textView2 = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.e9x);
            this.W = textView2;
            textView2.setOnClickListener(this);
            TextView textView3 = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.e9w);
            this.U = textView3;
            textView3.setOnClickListener(this);
            this.U.setContentDescription(getText(R.string.button_back));
            int b16 = UIUtils.b(getBaseActivity(), 3.0f);
            int b17 = UIUtils.b(getBaseActivity(), 10.0f);
            UIUtils.c(this.U, b16, b16, b17, b17);
            if (this.C.equals(this.D)) {
                this.W.setVisibility(0);
                this.W.setText(R.string.hmn);
            } else {
                this.W.setVisibility(8);
            }
            View inflate = LayoutInflater.from(getBaseActivity()).inflate(R.layout.bz6, (ViewGroup) this.F, false);
            this.N = inflate;
            TextView textView4 = (TextView) inflate.findViewById(R.id.bwo);
            this.P = textView4;
            textView4.setCompoundDrawables(null, null, null, null);
            this.Q = (ImageView) this.N.findViewById(R.id.bwg);
            Drawable drawable = getResources().getDrawable(R.drawable.common_loading6);
            this.R = drawable;
            this.Q.setImageDrawable(drawable);
            this.R.setVisible(true, true);
            QUIButton qUIButton = (QUIButton) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.dwm);
            this.S = qUIButton;
            qUIButton.setOnClickListener(this);
            this.T = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.dwk);
            qi(false);
            View inflate2 = LayoutInflater.from(getBaseActivity()).inflate(R.layout.bz7, (ViewGroup) null);
            this.H = inflate2;
            ImageView imageView = (ImageView) inflate2.findViewById(R.id.f166883iv4);
            this.I = imageView;
            imageView.setOnClickListener(this);
            this.J = (TextView) this.H.findViewById(R.id.iv5);
            this.K = (TextView) this.H.findViewById(R.id.m8u);
            XListView xListView = (XListView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.b9y);
            this.F = xListView;
            xListView.addHeaderView(this.H, null, false);
            t tVar = new t();
            this.f282180i0 = tVar;
            this.F.setAdapter((ListAdapter) tVar);
            this.F.setOnScrollListener(this);
            View findViewById = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f167005e51);
            this.G = findViewById;
            findViewById.setOnTouchListener(new j());
            Ci();
            ViewGroup viewGroup2 = (ViewGroup) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.bvc);
            this.f282175d0 = viewGroup2;
            viewGroup2.setVisibility(8);
            ImageView imageView2 = (ImageView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.bvo);
            this.f282174c0 = imageView2;
            imageView2.setOnTouchListener(ba.f77070d);
            SoftInputDetectView softInputDetectView = (SoftInputDetectView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.dmq);
            softInputDetectView.setExcludeStatusBar(false);
            softInputDetectView.setOnImStateChangedListener(this);
            IEmoticonMainPanel ti5 = ti(getBaseActivity().app, getBaseActivity(), ((IphoneTitleBarFragment) this).mContentView, R.id.bve, this.f282172a0);
            this.Z = ti5;
            ti5.getView().setVisibility(8);
            Gi();
            cj();
            String str = this.E;
            if (str == null || str.equals("")) {
                this.E = ac.y(getBaseActivity().app, this.C);
            }
            gj();
            SignatureHandler signatureHandler = this.f282191t0;
            if (signatureHandler != null) {
                signatureHandler.H2(Long.parseLong(this.C));
            }
            if (this.C.equals(this.D)) {
                i16 = 1;
            }
            ReportController.o(null, "dc00898", "", "", "0X800A4ED", "0X800A4ED", i16, 0, "" + i16, "0", "", "");
            VasWebviewUtil.reportCommercialDrainage("signature_history", "pv", "", 0, 0, 0, "", "", "" + i16, "", "", "", "", 0, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.bz_;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            Zi(message);
                        }
                    } else {
                        dj(message);
                    }
                } else {
                    this.I.setImageBitmap((Bitmap) message.obj);
                }
            } else {
                this.f282180i0.notifyDataSetChanged();
            }
        } else {
            Ji(message);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.initWindowStyleAndAnimation(activity);
            activity.getWindow().addFlags(256);
        }
    }

    public LinearLayout oi(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 20, (Object) this, (Object) view);
        }
        LinearLayout linearLayout = new LinearLayout(getBaseActivity());
        linearLayout.setOrientation(0);
        CheckBox checkBox = (CheckBox) LayoutInflater.from(getBaseActivity()).inflate(R.layout.adu, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.leftMargin = BaseAIOUtils.f(16.0f, getResources());
        linearLayout.addView(checkBox, layoutParams);
        int f16 = BaseAIOUtils.f(10.0f, getResources());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewUtils.getScreenWidth() - (f16 * 2), -2);
        layoutParams2.leftMargin = f16;
        layoutParams2.rightMargin = f16;
        linearLayout.addView(view, layoutParams2);
        return linearLayout;
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (!getBaseActivity().isFinishing() && this.Z.getView().getVisibility() == 0) {
            Mi(false);
            return true;
        }
        if ("history-msglist".equalsIgnoreCase(getBaseActivity().getIntent().getStringExtra("key_open_via")) && getBaseActivity() != null && (str = this.C) != null && str.equalsIgnoreCase(this.D)) {
            AllInOne allInOne = new AllInOne(this.C, 0);
            Bundle bundle = new Bundle();
            bundle.putBoolean("single_top", true);
            ProfileActivity.J2(getBaseActivity(), allInOne, bundle);
            getBaseActivity().overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            int id5 = view.getId();
            if (id5 == R.id.e9w) {
                onBackEvent();
            } else if (id5 == R.id.e9x) {
                Li();
            } else if (id5 == R.id.dwm) {
                li();
            } else if (id5 == R.id.ajw) {
                mi(view);
            } else if (id5 == R.id.bbi) {
                ji();
            } else if (id5 == R.id.bfa) {
                ki();
            } else if (id5 == R.id.dwv) {
                Wi(view);
            } else if (id5 == R.id.f166883iv4) {
                Yi();
            }
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<com.tencent.mobileqq.richstatus.sign.b> it = this.A0.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        getBaseActivity().app.unRegistObserver(this.f282194w0);
        getBaseActivity().app.removeObserver(this.f282195x0);
        ((IFontManagerService) getBaseActivity().app.getRuntimeService(IFontManagerService.class, "")).removeFontLoadCallback(this.E0);
        Handler handler = this.f282181j0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        aj(true, false);
        if (getBaseActivity() != null && getBaseActivity().app != null) {
            Oi(ThemeUtil.isInNightMode(getBaseActivity().app));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) absListView, i3);
            return;
        }
        if (i3 == 0) {
            URLDrawable.resume();
            VasFaceManager.t();
            ETFontUtil.enableAnimation = true;
            Pi(false);
            return;
        }
        URLDrawable.pause();
        VasFaceManager.m();
        ETFontUtil.enableAnimation = false;
        Pi(true);
    }

    @Override // com.tencent.mobileqq.profile.view.SoftInputDetectView.a
    public void s6(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (z16) {
            ((RelativeLayout.LayoutParams) this.f282176e0.getLayoutParams()).bottomMargin = 0;
            this.f282178g0 = i3;
            Mi(false);
            qi(true);
        } else {
            if (this.f282177f0 == 1) {
                hi();
            } else {
                this.f282176e0.setVisibility(8);
            }
            qi(false);
        }
        this.X = z16;
    }

    public String vi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        }
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        aVar.d(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str));
        return ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.text.ITopic.OnTopicClickListener
    public void onClick(ITopic iTopic, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) iTopic, (Object) view);
            return;
        }
        if (this.f282196y0) {
            return;
        }
        QLog.d("SignatureHistoryFragment", 1, "onClick topic=", iTopic);
        Object data = iTopic.getData();
        if (data instanceof Pair) {
            Pair pair = (Pair) data;
            if (QLog.isColorLevel()) {
                QLog.i("SignatureHistoryFragment", 2, String.format("history onTopicClick [%d,%s]", pair.first, pair.second));
            }
            com.tencent.mobileqq.richstatus.topic.c.d(getBaseActivity(), com.tencent.mobileqq.richstatus.topic.c.b(((Integer) pair.first).intValue(), (String) pair.second), -1);
        }
    }
}
