package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentTransaction;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.adapter.h;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.GestureActivityModule;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ContactBindedActivity extends IphoneTitleBarActivity implements nb2.a, IndexView.b, View.OnClickListener, Handler.Callback, AdapterView.OnItemClickListener, TextWatcher, View.OnKeyListener, h.b, ViewStub.OnInflateListener, com.tencent.mobileqq.search.view.d, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;
    public static final String[] N0;
    public static final String[] O0;
    public int A0;
    public Handler B0;
    public Handler C0;
    public ArrayList<PhoneContact> D0;
    private d E0;
    private ArrayList<PhoneContact> F0;
    protected boolean G0;
    private boolean H0;
    private f I0;
    private int J0;
    private boolean K0;
    private int L0;
    private boolean M0;

    /* renamed from: a0, reason: collision with root package name */
    private PinnedDividerListView f175434a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f175435b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f175436c0;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.mobileqq.adapter.h f175437d0;

    /* renamed from: e0, reason: collision with root package name */
    private INewFriendService f175438e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f175439f0;

    /* renamed from: g0, reason: collision with root package name */
    private CustomHorizontalScrollView f175440g0;

    /* renamed from: h0, reason: collision with root package name */
    private View f175441h0;

    /* renamed from: i0, reason: collision with root package name */
    private View f175442i0;

    /* renamed from: j0, reason: collision with root package name */
    private GridView f175443j0;

    /* renamed from: k0, reason: collision with root package name */
    private EditText f175444k0;

    /* renamed from: l0, reason: collision with root package name */
    private View f175445l0;

    /* renamed from: m0, reason: collision with root package name */
    private Button f175446m0;

    /* renamed from: n0, reason: collision with root package name */
    private View f175447n0;

    /* renamed from: o0, reason: collision with root package name */
    private EditText f175448o0;

    /* renamed from: p0, reason: collision with root package name */
    IndexView f175449p0;

    /* renamed from: q0, reason: collision with root package name */
    LinearLayout f175450q0;

    /* renamed from: r0, reason: collision with root package name */
    QUIEmptyState f175451r0;

    /* renamed from: s0, reason: collision with root package name */
    TextView f175452s0;

    /* renamed from: t0, reason: collision with root package name */
    private QQCustomDialog f175453t0;

    /* renamed from: u0, reason: collision with root package name */
    IPhoneContactService f175454u0;

    /* renamed from: v0, reason: collision with root package name */
    private IFaceDecoder f175455v0;

    /* renamed from: w0, reason: collision with root package name */
    private Bitmap f175456w0;

    /* renamed from: x0, reason: collision with root package name */
    private ContactSearchFragment f175457x0;

    /* renamed from: y0, reason: collision with root package name */
    boolean f175458y0;

    /* renamed from: z0, reason: collision with root package name */
    public PhoneContact f175459z0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactBindedActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ContactBindedActivity.this.f175453t0 = null;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends ScaleAnimation {
        static IPatchRedirector $redirector_;

        b(float f16, float f17, float f18, float f19, int i3, float f26, int i16, float f27) {
            super(f16, f17, f18, f19, i3, f26, i16, f27);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ContactBindedActivity.this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Integer.valueOf(i3), Float.valueOf(f26), Integer.valueOf(i16), Float.valueOf(f27));
            }
        }

        @Override // android.view.animation.ScaleAnimation, android.view.animation.Animation
        protected void applyTransformation(float f16, Transformation transformation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), transformation);
            } else {
                if (transformation == null) {
                    return;
                }
                super.applyTransformation(f16, transformation);
                transformation.setAlpha((f16 * 1.0f) + 0.0f);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactBindedActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else if (QLog.isColorLevel()) {
                QLog.d("IMCore.PhoneContact.ContactBindedActivity", 2, "doMultiAddTipsAnim end");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else if (QLog.isColorLevel()) {
                QLog.d("IMCore.PhoneContact.ContactBindedActivity", 2, "doMultiAddTipsAnim start");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d extends BaseAdapter implements DecodeTaskCompletionListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f175463d;

        /* renamed from: e, reason: collision with root package name */
        private final Drawable f175464e;

        /* renamed from: f, reason: collision with root package name */
        private Context f175465f;

        public d(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactBindedActivity.this, (Object) context);
                return;
            }
            this.f175463d = false;
            this.f175464e = context.getResources().getDrawable(R.drawable.abc);
            this.f175465f = context;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PhoneContact getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PhoneContact) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return (PhoneContact) ContactBindedActivity.this.F0.get(i3);
        }

        void b() {
            if (this.f175463d) {
                if (ContactBindedActivity.this.F0 != null && ContactBindedActivity.this.F0.size() > 0) {
                    ContactBindedActivity.this.Y2((PhoneContact) ContactBindedActivity.this.F0.get(ContactBindedActivity.this.F0.size() - 1), false);
                }
                this.f175463d = false;
                return;
            }
            this.f175463d = true;
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return ContactBindedActivity.this.F0.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                PhoneContact item = getItem(i3);
                Drawable drawable = null;
                if (view == null) {
                    view = ContactBindedActivity.this.getLayoutInflater().inflate(R.layout.f168221pn, (ViewGroup) null);
                }
                view.setTag(item);
                ImageView imageView = (ImageView) view.findViewById(R.id.c0o);
                if (i3 == getCount() - 1 && this.f175463d) {
                    drawable = this.f175464e;
                }
                imageView.setImageDrawable(drawable);
                Bitmap bitmapFromCache = ContactBindedActivity.this.f175455v0.getBitmapFromCache(11, item.unifiedCode);
                if (bitmapFromCache == null) {
                    ContactBindedActivity.this.f175455v0.requestDecodeFace(item.unifiedCode, 11, true, (byte) 0);
                    bitmapFromCache = ContactBindedActivity.this.f175456w0;
                }
                imageView.setBackgroundDrawable(new BitmapDrawable(this.f175465f.getResources(), bitmapFromCache));
                if (AppSetting.f99565y) {
                    imageView.setContentDescription(item.name);
                }
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                this.f175463d = false;
                super.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
                return;
            }
            if (ContactBindedActivity.this.f175443j0 == null) {
                return;
            }
            for (int i17 = 0; i17 < ContactBindedActivity.this.f175443j0.getChildCount(); i17++) {
                View childAt = ContactBindedActivity.this.f175443j0.getChildAt(i17);
                Object tag = childAt.getTag();
                if (tag != null && (tag instanceof PhoneContact) && str.equals(((PhoneContact) tag).unifiedCode)) {
                    ((ImageView) childAt.findViewById(R.id.c0o)).setBackgroundDrawable(new BitmapDrawable(this.f175465f.getResources(), bitmap));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private class e extends FlingGestureHandler {
        static IPatchRedirector $redirector_;

        public e(Activity activity) {
            super(activity);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactBindedActivity.this, (Object) activity);
            }
        }

        @Override // com.tencent.mobileqq.activity.fling.FlingGestureHandler, com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener
        public void flingLToR() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (!ContactBindedActivity.this.f175458y0) {
                super.flingLToR();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static final class f implements Comparator<PhoneContact> {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PhoneContact phoneContact, PhoneContact phoneContact2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) phoneContact, (Object) phoneContact2)).intValue();
            }
            boolean isEmpty = TextUtils.isEmpty(phoneContact.pinyinFirst);
            boolean isEmpty2 = TextUtils.isEmpty(phoneContact2.pinyinFirst);
            if (!isEmpty && !isEmpty2) {
                return phoneContact.pinyinFirst.toLowerCase().charAt(0) - phoneContact2.pinyinFirst.toLowerCase().charAt(0);
            }
            if (isEmpty && isEmpty2) {
                return 0;
            }
            if (isEmpty2) {
                return -1;
            }
            return 1;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66835);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            N0 = new String[]{"$", "\u2605", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"};
            O0 = new String[]{"$", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"};
        }
    }

    public ContactBindedActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f175452s0 = null;
        this.f175453t0 = null;
        this.f175457x0 = null;
        this.f175458y0 = false;
        this.f175459z0 = null;
        this.A0 = -1;
        this.D0 = null;
        this.F0 = new ArrayList<>();
        this.G0 = true;
        this.H0 = false;
        this.I0 = new f();
        this.J0 = 1;
        this.K0 = false;
        this.L0 = -1;
        this.M0 = false;
    }

    private void P2() {
        if (this.f175451r0 != null) {
            return;
        }
        QUIEmptyState build = new QUIEmptyState.Builder(this).setImageType(7).setTitle(HardCodeUtil.qqStr(R.string.qnq)).setBackgroundColorType(0).build();
        this.f175451r0 = build;
        build.setVisibility(0);
        this.f175450q0.addView(this.f175451r0);
    }

    private void Q2() {
        int i3;
        int i16;
        int i17;
        if (!this.F0.isEmpty()) {
            if (this.F0.size() == 1) {
                if (!((IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()) {
                    i16 = 3075;
                    i17 = 1;
                } else {
                    i16 = 3006;
                    i17 = 13;
                }
                PhoneContact phoneContact = this.F0.get(0);
                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(this, 2, phoneContact.unifiedCode, null, i16, i17, phoneContact.name, null, null, HardCodeUtil.qqStr(R.string.j6l), null), 102);
                return;
            }
            if (this.F0.size() <= 100) {
                if (!((IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()) {
                    i3 = 3079;
                } else {
                    i3 = 3078;
                }
                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startMultiAddContact(this, this.F0, i3, null, HardCodeUtil.qqStr(R.string.j6l), null, this.J0), 101);
            }
        }
    }

    private void R2(boolean z16) {
        this.C0.removeMessages(2);
        Handler handler = this.C0;
        handler.sendMessageDelayed(handler.obtainMessage(2, Boolean.valueOf(z16)), 100L);
    }

    public static void T2(Activity activity, QQAppInterface qQAppInterface, int i3, ArrayList<PhoneContact> arrayList) {
        if (activity == null) {
            QLog.e("IMCore.PhoneContact.ContactBindedActivity", 1, "startFromOther activity is null requestCode: " + i3 + "  starList:" + arrayList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.ContactBindedActivity", 2, "startFromOther requestCode: " + i3 + "  starList:" + arrayList);
        }
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X8007971", "0X8007971", 0, 0, "", "", "", "");
        Intent intent = new Intent(activity, (Class<?>) ContactBindedActivity.class);
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            Iterator<PhoneContact> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().mobileNo);
            }
            intent.putExtra("isBindAction", arrayList2);
        }
        intent.putExtra("from_type", 1);
        activity.startActivityForResult(intent, i3);
    }

    public static void U2(QQAppInterface qQAppInterface, int i3, int i16, Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getStringExtra("check_permission_result");
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.ContactBindedActivity", 2, String.format("startFromOther [%s, %s, %s]", Integer.valueOf(i3), Integer.valueOf(i16), str));
        }
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null) {
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X80077CF", "0X80077CF", 0, 0, "", "", "", "");
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800796B", "0X800796B", 0, 0, "", "", "", "");
            Intent intent2 = new Intent(baseActivity, (Class<?>) ContactBindedActivity.class);
            intent2.putExtra("from_type", 0);
            intent2.putExtra("kSrouce", i3);
            intent2.putExtra("fromKeyForContactBind", i16);
            baseActivity.startActivityForResult(intent2, 222);
        }
    }

    public static void V2(QQAppInterface qQAppInterface, int i3, ArrayList<PhoneContact> arrayList) {
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.PhoneContact.ContactBindedActivity", 2, "startFromOther requestCode: " + i3 + "  starList:" + arrayList);
        }
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null) {
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8007971", "0X8007971", 0, 0, "", "", "", "");
            Intent intent = new Intent(baseActivity, (Class<?>) ContactBindedActivity.class);
            if (arrayList != null && !arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                Iterator<PhoneContact> it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next().mobileNo);
                }
                intent.putExtra("isBindAction", arrayList2);
            }
            intent.putExtra("from_type", 1);
            baseActivity.startActivityForResult(intent, i3);
        }
    }

    private void W2(boolean z16) {
        int i3;
        String string;
        boolean z17 = !this.f175458y0;
        this.f175458y0 = z17;
        if (z17) {
            this.leftView.setVisibility(8);
            this.f175439f0.setVisibility(0);
            this.f175445l0.setVisibility(0);
            if (this.F0.isEmpty()) {
                string = getString(R.string.a97);
            } else {
                string = getString(R.string.a98, Integer.valueOf(this.F0.size()));
            }
            this.f175446m0.setText(string);
            this.f175434a0.removeHeaderView(this.f175447n0);
            if (this.f175457x0 == null) {
                this.f175457x0 = (ContactSearchFragment) ContactSearchFragment.yh(19, 524288, null, null, this, 0, -1L, true, false, null);
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                beginTransaction.add(R.id.iji, this.f175457x0);
                beginTransaction.commitAllowingStateLoss();
            }
        } else {
            this.leftView.setVisibility(0);
            this.f175442i0.setVisibility(8);
            this.f175439f0.setVisibility(8);
            this.f175434a0.addHeaderView(this.f175447n0);
            this.f175445l0.setVisibility(8);
            ((InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.f175434a0.getWindowToken(), 0);
        }
        if (z16) {
            this.F0.clear();
            this.f175437d0.L.clear();
        }
        ContactSearchFragment contactSearchFragment = this.f175457x0;
        if (contactSearchFragment != null) {
            contactSearchFragment.Ch(this.F0);
        }
        this.f175446m0.setEnabled(!this.F0.isEmpty());
        TextView textView = this.rightViewText;
        if (this.f175458y0) {
            i3 = R.string.cancel;
        } else {
            i3 = R.string.a9b;
        }
        textView.setText(i3);
        this.E0.notifyDataSetChanged();
        this.f175437d0.g(this.f175458y0);
        this.f175444k0.setText("");
        adjustGridView(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y2(PhoneContact phoneContact, boolean z16) {
        String string;
        if (z16) {
            if (this.F0.size() >= 100) {
                QQToast.makeText(this, 1, R.string.a99, 0).show(getTitleBarHeight());
                z16 = false;
            } else {
                this.F0.add(phoneContact);
            }
            this.f175444k0.setText("");
        } else {
            int i3 = 0;
            while (true) {
                if (i3 < this.F0.size()) {
                    if (TextUtils.equals(this.F0.get(i3).unifiedCode, phoneContact.unifiedCode)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            this.F0.remove(i3);
        }
        this.f175437d0.l(phoneContact, z16);
        ContactSearchFragment contactSearchFragment = this.f175457x0;
        if (contactSearchFragment != null) {
            contactSearchFragment.Ch(this.F0);
        }
        if (this.F0.isEmpty()) {
            string = getString(R.string.a97);
        } else {
            string = getString(R.string.a98, Integer.valueOf(this.F0.size()));
        }
        this.f175446m0.setText(string);
        this.f175446m0.setEnabled(!this.F0.isEmpty());
        adjustGridView(true);
    }

    protected void M2() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (this.mDensity * 40.0f));
        int i16 = (int) (this.mDensity * 10.0f);
        if (this.F0.size() > 0) {
            if (this.F0.size() < 5) {
                float size = (this.F0.size() * 40) + (this.F0.size() * 10);
                float f16 = this.mDensity;
                i3 = ((int) (size * f16)) + ((int) (f16 * 10.0f));
            } else {
                i3 = (int) (this.mDensity * 230.0f);
            }
            this.f175441h0.setVisibility(8);
        } else {
            i3 = (int) (this.mDensity * 40.0f);
            this.f175441h0.setVisibility(0);
        }
        layoutParams.addRule(15);
        layoutParams.setMargins(i3, 0, i16, 0);
        this.f175444k0.setLayoutParams(layoutParams);
    }

    public void N2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        TextView textView = this.f175452s0;
        if (textView != null) {
            textView.clearAnimation();
            this.f175452s0.setVisibility(8);
            this.f175452s0 = null;
        }
    }

    public void S2(com.tencent.mobileqq.phonecontact.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        if (aVar.f258459d.size() <= 0 && !this.H0) {
            this.f175450q0.setVisibility(0);
        } else {
            this.f175450q0.setVisibility(8);
        }
        if (aVar.f258459d.size() > 10 && !this.K0 && this.J0 == 1) {
            ReportController.o(this.app, "dc00898", "", "", "0X8007972", "0X8007972", 0, 0, "", "", "", "");
            this.K0 = true;
        }
        if (aVar.f258459d.size() <= 10 && !this.H0) {
            this.f175449p0.setVisibility(8);
        } else {
            this.f175449p0.setVisibility(0);
        }
        this.f175437d0.j(aVar);
        this.f175437d0.notifyDataSetChanged();
    }

    protected void adjustGridView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        this.f175443j0.setNumColumns(this.F0.size());
        ViewGroup.LayoutParams layoutParams = this.f175443j0.getLayoutParams();
        layoutParams.width = (int) (((this.F0.size() * 40) + (this.F0.size() * 10)) * this.mDensity);
        this.f175443j0.setLayoutParams(layoutParams);
        M2();
        if (z16) {
            this.B0.sendEmptyMessageDelayed(3, 200L);
        }
        this.E0.notifyDataSetChanged();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) editable);
            return;
        }
        String obj = editable.toString();
        View view = this.f175442i0;
        if (TextUtils.isEmpty(obj)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view.setVisibility(i3);
        ContactSearchFragment contactSearchFragment = this.f175457x0;
        if (contactSearchFragment != null) {
            contactSearchFragment.startSearch(obj);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 101 && i16 == -1) {
            if (intent.hasExtra("result")) {
                ArrayList<AddBatchPhoneFriendResult> arrayList = (ArrayList) intent.getSerializableExtra("result");
                if (!arrayList.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<AddBatchPhoneFriendResult> arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    FriendsManager friendsManager = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
                    for (AddBatchPhoneFriendResult addBatchPhoneFriendResult : arrayList) {
                        int i17 = addBatchPhoneFriendResult.sendResult;
                        if (i17 == 0) {
                            friendsManager.y0(addBatchPhoneFriendResult.mobile, true);
                            arrayList2.add(addBatchPhoneFriendResult);
                        } else if (i17 == 37) {
                            arrayList4.add(addBatchPhoneFriendResult);
                        } else if (i17 != 32 && i17 != 33) {
                            if (addBatchPhoneFriendResult.allowType == 2) {
                                arrayList3.add(addBatchPhoneFriendResult);
                            }
                        } else {
                            arrayList5.add(addBatchPhoneFriendResult);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("IMCore.PhoneContact.ContactBindedActivity", 2, "doOnActivityResult, adds=" + arrayList2.size() + ", needAnswers=" + arrayList3.size() + ", security anti=" + arrayList4.size() + ", upToLimits=" + arrayList5.size() + ", others=" + ((((arrayList.size() - arrayList2.size()) - arrayList3.size()) - arrayList4.size()) - arrayList5.size()));
                    }
                    StringBuilder sb5 = new StringBuilder();
                    if (!arrayList4.isEmpty()) {
                        str = HardCodeUtil.qqStr(R.string.f171791l10);
                        sb5.append("\u90e8\u5206\u597d\u53cb\u6dfb\u52a0\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u3002");
                    } else if (!arrayList5.isEmpty()) {
                        str = HardCodeUtil.qqStr(R.string.f171793l13);
                        sb5.append("\u597d\u53cb\u5df2\u8fbe\u4e0a\u9650\uff0c\u90e8\u5206\u597d\u53cb\u672a\u6dfb\u52a0\u3002");
                    } else if (!arrayList3.isEmpty()) {
                        str = getString(R.string.a9a);
                        if (arrayList3.size() == 1) {
                            AddBatchPhoneFriendResult addBatchPhoneFriendResult2 = (AddBatchPhoneFriendResult) arrayList3.get(0);
                            Iterator<PhoneContact> it = this.F0.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                PhoneContact next = it.next();
                                if (addBatchPhoneFriendResult2.mobile.equals(next.unifiedCode)) {
                                    if (TextUtils.isEmpty(next.name)) {
                                        str3 = next.nickName;
                                    } else {
                                        str3 = next.name;
                                    }
                                    sb5.append(com.tencent.open.base.j.i(str3, 12, true));
                                    sb5.append("\u7684\u597d\u53cb\u9a8c\u8bc1\u65b9\u5f0f\u9700\u8981\u56de\u7b54\u95ee\u9898, \u8bf7\u5355\u72ec\u6dfb\u52a0\u3002");
                                }
                            }
                        } else {
                            ArrayList arrayList6 = new ArrayList(arrayList3.size());
                            for (AddBatchPhoneFriendResult addBatchPhoneFriendResult3 : arrayList3) {
                                Iterator<PhoneContact> it5 = this.F0.iterator();
                                while (it5.hasNext()) {
                                    PhoneContact next2 = it5.next();
                                    if (addBatchPhoneFriendResult3.mobile.equals(next2.unifiedCode)) {
                                        arrayList6.add(next2);
                                    }
                                }
                            }
                            Collections.sort(arrayList6, this.I0);
                            for (int i18 = 0; i18 < 2; i18++) {
                                PhoneContact phoneContact = (PhoneContact) arrayList6.get(i18);
                                if (TextUtils.isEmpty(phoneContact.name)) {
                                    str2 = phoneContact.nickName;
                                } else {
                                    str2 = phoneContact.name;
                                }
                                sb5.append(com.tencent.open.base.j.i(str2, 12, true));
                                if (i18 == 0) {
                                    sb5.append("\u3001");
                                }
                            }
                            sb5.append("\u7b49");
                            sb5.append(arrayList3.size());
                            sb5.append("\u4f4d\u8054\u7cfb\u4eba\u7684\u597d\u53cb\u9a8c\u8bc1\u65b9\u5f0f\u9700\u8981\u56de\u7b54\u95ee\u9898, \u8bf7\u5355\u72ec\u6dfb\u52a0\u3002");
                            if (this.J0 == 0) {
                                ReportController.o(this.app, "dc00898", "", "", "0X8007970", "0X8007970", 0, 0, String.valueOf(arrayList3.size()), "", "", "");
                            } else {
                                ReportController.o(this.app, "dc00898", "", "", "0X8007977", "0X8007977", 0, 0, String.valueOf(arrayList3.size()), "", "", "");
                            }
                        }
                    } else {
                        str = "";
                    }
                    if (!arrayList4.isEmpty() || !arrayList5.isEmpty() || !arrayList3.isEmpty()) {
                        this.f175453t0 = DialogUtil.createCustomDialog(this, 230, str, sb5.toString(), new a(), null);
                        this.B0.sendEmptyMessageDelayed(6, 900L);
                    }
                    arrayList3.addAll(arrayList2);
                    if (this.D0 == null) {
                        this.D0 = new ArrayList<>();
                    }
                    this.D0.clear();
                    for (AddBatchPhoneFriendResult addBatchPhoneFriendResult4 : arrayList3) {
                        Iterator<PhoneContact> it6 = this.F0.iterator();
                        while (it6.hasNext()) {
                            PhoneContact next3 = it6.next();
                            if (addBatchPhoneFriendResult4.mobile.equals(next3.unifiedCode)) {
                                this.D0.add(next3);
                            }
                        }
                    }
                    this.f175449p0.setIndex(N0);
                    z18 = true;
                    this.H0 = true;
                    z19 = false;
                    R2(z19);
                    W2(z18);
                    adjustGridView(z18);
                    this.B0.removeMessages(4);
                    Handler handler = this.B0;
                    handler.sendMessageDelayed(handler.obtainMessage(4), 120L);
                    return;
                }
            }
            z18 = true;
            z19 = false;
            R2(z19);
            W2(z18);
            adjustGridView(z18);
            this.B0.removeMessages(4);
            Handler handler2 = this.B0;
            handler2.sendMessageDelayed(handler2.obtainMessage(4), 120L);
            return;
        }
        if (i3 == 102 && i16 == -1) {
            if (!this.F0.isEmpty()) {
                if (this.D0 == null) {
                    this.D0 = new ArrayList<>();
                }
                this.D0.clear();
                z17 = false;
                this.D0.add(this.F0.get(0));
                this.f175449p0.setIndex(N0);
                z16 = true;
                this.H0 = true;
            } else {
                z16 = true;
                z17 = false;
            }
            R2(z17);
            W2(z16);
            adjustGridView(z16);
            this.B0.removeMessages(4);
            Handler handler3 = this.B0;
            handler3.sendMessageDelayed(handler3.obtainMessage(4), 120L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    @TargetApi(9)
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        getWindow().setSoftInputMode(48);
        com.tencent.relation.common.utils.a.a(this, -1, 1);
        setContentView(R.layout.at5);
        Intent intent = getIntent();
        this.f175454u0 = (IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "");
        if (intent != null) {
            ArrayList arrayList = (ArrayList) intent.getSerializableExtra("isBindAction");
            if (arrayList != null && !arrayList.isEmpty()) {
                this.D0 = new ArrayList<>(arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    PhoneContact queryPhoneContactByMobile = this.f175454u0.queryPhoneContactByMobile((String) it.next());
                    if (queryPhoneContactByMobile != null) {
                        this.D0.add(queryPhoneContactByMobile);
                    }
                }
            } else {
                this.D0 = this.f175454u0.generateRandomList();
            }
            this.J0 = intent.getIntExtra("from_type", 1);
            this.L0 = intent.getIntExtra("from_page", -1);
            if (intent.getIntExtra("fromKeyForContactBind", 0) == 1) {
                QQToast.makeText(BaseApplication.getContext(), 2, R.string.f171162cs4, 0);
            }
        }
        this.B0 = new Handler(Looper.getMainLooper(), this);
        this.C0 = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        GestureActivityModule.setFlingHandler(this, new e(this));
        this.f175435b0 = findViewById(R.id.root);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.f175435b0.setFitsSystemWindows(true);
        }
        this.f175434a0 = (PinnedDividerListView) findViewById(R.id.j9v);
        TextView textView = (TextView) findViewById(R.id.ivTitleName);
        this.f175436c0 = textView;
        textView.setVisibility(0);
        this.f175436c0.setText(R.string.crh);
        setTitle(getString(R.string.crh));
        setLeftViewName(R.string.button_back);
        this.leftView.setOnClickListener(this);
        if (SimpleUIUtil.isNowElderMode()) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.cai);
            this.leftView.setMinWidth(dimensionPixelSize);
            this.leftView.setMinHeight(dimensionPixelSize);
        }
        View findViewById = findViewById(R.id.ijp);
        this.f175439f0 = findViewById;
        this.f175440g0 = (CustomHorizontalScrollView) findViewById.findViewById(R.id.iig);
        this.f175441h0 = this.f175439f0.findViewById(R.id.iiq);
        EditText editText = (EditText) this.f175439f0.findViewById(R.id.ik5);
        this.f175444k0 = editText;
        editText.addTextChangedListener(this);
        this.f175444k0.setOnKeyListener(this);
        this.f175443j0 = (GridView) this.f175439f0.findViewById(R.id.imn);
        AccessibilityUtil.n(this.f175440g0, false);
        this.f175440g0.setOverScrollMode(2);
        this.f175443j0.setOverScrollMode(2);
        this.f175443j0.setSmoothScrollbarEnabled(false);
        d dVar = new d(this);
        this.E0 = dVar;
        this.f175443j0.setAdapter((ListAdapter) dVar);
        this.f175443j0.setOnItemClickListener(this);
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
        this.f175455v0 = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this.E0);
        this.f175456w0 = BaseImageUtil.getDefaultFaceBitmap();
        this.f175439f0.setOnClickListener(this);
        this.f175442i0 = findViewById(R.id.iji);
        this.f175445l0 = findViewById(R.id.cc8);
        Button button = (Button) findViewById(R.id.aii);
        this.f175446m0 = button;
        button.setOnClickListener(this);
        QUISearchBar qUISearchBar = new QUISearchBar(this);
        this.f175447n0 = qUISearchBar;
        qUISearchBar.updateStyle(1);
        this.f175447n0.findViewById(R.id.f65993_f).setOnClickListener(this);
        EditText editText2 = (EditText) this.f175447n0.findViewById(R.id.f66003_g);
        this.f175448o0 = editText2;
        editText2.setFocusableInTouchMode(false);
        this.f175448o0.setCursorVisible(false);
        this.f175448o0.setOnClickListener(this);
        this.f175434a0.addHeaderView(this.f175447n0);
        IndexView indexView = (IndexView) findViewById(R.id.djg);
        this.f175449p0 = indexView;
        if (this.D0 == null) {
            indexView.setIndex(O0);
        } else {
            indexView.setIndex(N0);
        }
        this.f175449p0.setOnIndexChangedListener(this);
        this.f175450q0 = (LinearLayout) findViewById(R.id.bwi);
        P2();
        this.f175439f0.setVisibility(8);
        RespondQueryQQBindingStat selfBindInfo = this.f175454u0.getSelfBindInfo();
        if (selfBindInfo != null && TextUtils.isEmpty(selfBindInfo.mobileNo) && selfBindInfo.noBindUploadContacts) {
            ReportController.o(this.app, "dc00898", "", "", "0X80077CC", "0X80077CC", 0, 0, "", "", "", "");
        }
        if (this.f175454u0.isBindedIgnoreUpload()) {
            ReportController.o(this.app, "dc00898", "", "", "0X80077D2", "0X80077D2", 0, 0, "", "", "", "");
        }
        com.tencent.mobileqq.phonecontact.data.a contactBoundDataCache = this.f175454u0.getContactBoundDataCache();
        if (contactBoundDataCache == null || this.D0 == null) {
            contactBoundDataCache = new com.tencent.mobileqq.phonecontact.data.a();
        }
        com.tencent.mobileqq.adapter.h hVar = new com.tencent.mobileqq.adapter.h(this, this.app, this.f175434a0, contactBoundDataCache.f258459d);
        this.f175437d0 = hVar;
        hVar.R = this;
        hVar.Q = this.f175449p0;
        this.f175434a0.setAdapter((ListAdapter) hVar);
        this.f175434a0.setOnScrollListener(this);
        if (!contactBoundDataCache.f258459d.isEmpty()) {
            ArrayList<PhoneContact> arrayList2 = this.D0;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                long currentTimeMillis = System.currentTimeMillis();
                contactBoundDataCache = com.tencent.mobileqq.phonecontact.util.a.a(contactBoundDataCache.f258459d, this.D0, true);
                this.f175454u0.setContactBoundDataCache(contactBoundDataCache);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d("IMCore.PhoneContact.ContactBindedActivity", 2, "constructHashStruct startTime=" + currentTimeMillis + ", endTime=" + currentTimeMillis2 + ", cost=" + String.valueOf(currentTimeMillis2 - currentTimeMillis));
                }
            }
            S2(contactBoundDataCache);
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(getApplicationContext(), "common_mmkv_configurations");
        this.M0 = fromV2.getBoolean("phone_contact_first_enter_contact_binded", true, true);
        fromV2.putBoolean("phone_contact_first_enter_contact_binded", false, true);
        R2(true);
        INewFriendService iNewFriendService = (INewFriendService) this.app.getRuntimeService(INewFriendService.class);
        this.f175438e0 = iNewFriendService;
        iNewFriendService.addListener(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.doOnDestroy();
        N2();
        Handler handler = this.B0;
        if (handler != null) {
            handler.removeMessages(1);
            this.B0.removeMessages(4);
            this.B0.removeMessages(6);
        }
        Handler handler2 = this.C0;
        if (handler2 != null) {
            handler2.removeMessages(2);
        }
        this.f175438e0.removeListener(this);
        com.tencent.mobileqq.adapter.h hVar = this.f175437d0;
        if (hVar != null) {
            hVar.destroy();
        }
        this.f175454u0.clearRecommendBadge();
    }

    @Override // com.tencent.mobileqq.adapter.h.b
    public void e0(PhoneContact phoneContact, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, phoneContact, Boolean.valueOf(z16));
        } else if (phoneContact != null) {
            Y2(phoneContact, z16);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        PhoneContact phoneContact;
        String upperCase;
        com.tencent.mobileqq.phonecontact.data.a a16;
        ArrayList<PhoneContact> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 6 && this.f175453t0 != null) {
                            this.B0.removeMessages(6);
                            this.f175453t0.show();
                        }
                    } else {
                        this.f175434a0.setSelectionFromTop(0, 0);
                    }
                } else {
                    this.f175440g0.scrollTo(this.f175443j0.getLayoutParams().width, 0);
                }
            } else {
                ArrayList arrayList2 = new ArrayList(this.f175454u0.getBindAllFriendList());
                if (this.H0 && (arrayList = this.D0) != null && !arrayList.isEmpty()) {
                    Iterator<PhoneContact> it = this.D0.iterator();
                    while (it.hasNext()) {
                        PhoneContact next = it.next();
                        int i16 = 0;
                        while (true) {
                            if (i16 < arrayList2.size()) {
                                if (TextUtils.equals(((PhoneContact) arrayList2.get(i16)).unifiedCode, next.unifiedCode)) {
                                    break;
                                }
                                i16++;
                            } else {
                                i16 = -1;
                                break;
                            }
                        }
                        if (i16 >= 0) {
                            arrayList2.remove(i16);
                        }
                    }
                    a16 = com.tencent.mobileqq.phonecontact.util.a.a(arrayList2, this.D0, false);
                } else {
                    a16 = com.tencent.mobileqq.phonecontact.util.a.a(arrayList2, this.D0, true);
                }
                Message.obtain(this.B0, 1, ((Boolean) message.obj).booleanValue() ? 1 : 0, 0, a16).sendToTarget();
            }
        } else {
            com.tencent.mobileqq.phonecontact.data.a aVar = (com.tencent.mobileqq.phonecontact.data.a) message.obj;
            if (this.D0 != null) {
                this.f175454u0.setContactBoundDataCache(aVar);
            }
            if (this.A0 != -1 && (phoneContact = this.f175459z0) != null) {
                if (TextUtils.isEmpty(phoneContact.pinyinFirst)) {
                    upperCase = "#";
                } else {
                    upperCase = String.valueOf(this.f175459z0.pinyinFirst.charAt(0)).toUpperCase();
                }
                List<PhoneContact> list = aVar.f258456a.get(upperCase);
                if (list != null && !list.isEmpty()) {
                    int size = list.size() - 1;
                    while (true) {
                        if (size >= 0) {
                            if (TextUtils.equals(this.f175459z0.unifiedCode, list.get(size).unifiedCode)) {
                                break;
                            }
                            size--;
                        } else {
                            size = -1;
                            break;
                        }
                    }
                    if (size != -1) {
                        list.add(this.A0, list.remove(size));
                    }
                }
                this.A0 = -1;
                this.f175459z0 = null;
            }
            S2(aVar);
            if (message.arg1 == 1) {
                boolean z16 = !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("phone_contact_binded_first_enter_update_disable", false);
                if (this.M0 && z16 && aVar.f258459d.isEmpty()) {
                    QLog.d("IMCore.PhoneContact.ContactBindedActivity", 1, "checkUpdateLocalContact first enter page");
                    this.f175454u0.checkUpdateLocalContact(true, 18);
                } else {
                    this.f175454u0.checkUpdateBindStateAndListIgnoreBindState(true, true, 18);
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.view.d
    public void onAction(View view) {
        PhoneContact phoneContact;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view);
            return;
        }
        com.tencent.mobileqq.search.model.k kVar = (com.tencent.mobileqq.search.model.k) view.getTag(R.id.kxb);
        if (kVar != null && (phoneContact = ((wn2.m) kVar).X) != null) {
            Y2(phoneContact, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.L0 == 1) {
            ReportController.o(this.app, "dc00898", "", "", "0X8009EC6", "0X8009EC6", 0, 0, "", "", "", "");
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ArrayList<PhoneContact> arrayList;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnLeft) {
                if (this.L0 == 1) {
                    ReportController.o(this.app, "dc00898", "", "", "0X8009EC6", "0X8009EC6", 0, 0, "", "", "", "");
                }
                finish();
            } else if (id5 == R.id.ivTitleBtnRightText) {
                N2();
                if (!this.f175458y0) {
                    if (this.J0 == 0) {
                        ReportController.o(this.app, "dc00898", "", "", "0X800796C", "0X800796C", 0, 0, "", "", "", "");
                    } else {
                        ReportController.o(this.app, "dc00898", "", "", "0X8007973", "0X8007973", 0, 0, "", "", "", "");
                    }
                }
                W2(true);
            } else if (id5 != R.id.f65993_f && id5 != R.id.f66003_g) {
                if (id5 == R.id.aii) {
                    if (!this.F0.isEmpty()) {
                        int i3 = 0;
                        if (!this.H0 && (arrayList = this.D0) != null && !arrayList.isEmpty()) {
                            Iterator<PhoneContact> it = this.D0.iterator();
                            while (it.hasNext()) {
                                PhoneContact next = it.next();
                                Iterator<PhoneContact> it5 = this.F0.iterator();
                                while (true) {
                                    if (!it5.hasNext()) {
                                        break;
                                    } else if (TextUtils.equals(it5.next().unifiedCode, next.unifiedCode)) {
                                        i3++;
                                        break;
                                    }
                                }
                            }
                        }
                        if (this.J0 == 0) {
                            ReportController.o(this.app, "dc00898", "", "", "0X800796D", "0X800796D", 0, 0, "", "", "", "");
                            ReportController.o(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 0, 0, String.valueOf(this.F0.size()), "", "", "");
                            ReportController.o(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 1, 0, String.valueOf(i3), "", "", "");
                            ReportController.o(this.app, "dc00898", "", "", "0X800796E", "0X800796E", 2, 0, String.valueOf(this.F0.size() - i3), "", "", "");
                        } else {
                            ReportController.o(this.app, "dc00898", "", "", "0X8007974", "0X8007974", 0, 0, "", "", "", "");
                            ReportController.o(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 0, 0, String.valueOf(this.F0.size()), "", "", "");
                            ReportController.o(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 1, 0, String.valueOf(i3), "", "", "");
                            ReportController.o(this.app, "dc00898", "", "", "0X8007975", "0X8007975", 2, 0, String.valueOf(this.F0.size() - i3), "", "", "");
                        }
                    }
                    Q2();
                } else if (id5 == R.id.kbr) {
                    N2();
                }
            } else {
                N2();
                ContactSearchComponentActivity.V2(this, null, 17, 524288, 21001);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // nb2.a
    public void onContactCountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            QLog.d("IMCore.PhoneContact.ContactBindedActivity", 1, "onContactCountChanged");
            R2(false);
        }
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if ("$".equals(str)) {
            this.f175434a0.setSelection(0);
            return;
        }
        int i3 = this.f175437d0.i(str);
        if (i3 != -1) {
            PinnedDividerListView pinnedDividerListView = this.f175434a0;
            pinnedDividerListView.setSelection(i3 + pinnedDividerListView.getHeaderViewsCount());
        }
    }

    @Override // android.view.ViewStub.OnInflateListener
    public void onInflate(ViewStub viewStub, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) viewStub, (Object) view);
            return;
        }
        TextView textView = (TextView) view;
        this.f175452s0 = textView;
        textView.setOnClickListener(this);
        b bVar = new b(0.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        bVar.setDuration(500L);
        bVar.setInterpolator(new OvershootInterpolator());
        bVar.setAnimationListener(new c());
        this.f175452s0.startAnimation(bVar);
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("has_contact_bind_act_show_new_guide_" + this.app.getCurrentAccountUin(), true).commit();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        } else if (view.getTag() != null) {
            Y2((PhoneContact) view.getTag(), false);
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, this, view, Integer.valueOf(i3), keyEvent)).booleanValue();
        }
        if (i3 == 67) {
            if (keyEvent.getAction() == 0) {
                this.G0 = TextUtils.isEmpty(this.f175444k0.getText());
            } else if (keyEvent.getAction() == 1 && this.G0) {
                this.E0.b();
            }
        }
        return false;
    }

    @Override // nb2.a
    public void onMayKnowStatesChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            R2(false);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) absListView, i3);
        } else if (i3 != 0) {
            ((InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.f175434a0.getWindowToken(), 0);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // nb2.a
    public void onUnreadChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.search.view.d
    public /* synthetic */ void selectedItemClick(String str, int i3, boolean z16) {
        com.tencent.mobileqq.search.view.c.a(this, str, i3, z16);
    }
}
