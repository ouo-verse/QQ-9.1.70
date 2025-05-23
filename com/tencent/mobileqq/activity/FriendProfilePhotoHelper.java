package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.CustomCoverFragment;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: classes9.dex */
public class FriendProfilePhotoHelper implements CardHandler.d {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    public static final String f176051n;

    /* renamed from: a, reason: collision with root package name */
    public QQAppInterface f176052a;

    /* renamed from: b, reason: collision with root package name */
    public final QBaseActivity f176053b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f176054c;

    /* renamed from: d, reason: collision with root package name */
    public QQProgressDialog f176055d;

    /* renamed from: e, reason: collision with root package name */
    public WeakReferenceHandler f176056e;

    /* renamed from: f, reason: collision with root package name */
    public CardHandler.c f176057f;

    /* renamed from: g, reason: collision with root package name */
    public b f176058g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f176059h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f176060i;

    /* renamed from: j, reason: collision with root package name */
    public String f176061j;

    /* renamed from: k, reason: collision with root package name */
    public int f176062k;

    /* renamed from: l, reason: collision with root package name */
    public Runnable f176063l;

    /* renamed from: m, reason: collision with root package name */
    Handler.Callback f176064m;

    /* loaded from: classes9.dex */
    class a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfilePhotoHelper.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            return true;
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void notifyUser(int i3, int i16);

        void onUploadResult(byte[] bArr);

        void updateCover(byte[] bArr);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67089);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            f176051n = FriendProfilePhotoHelper.class.getSimpleName();
        }
    }

    public FriendProfilePhotoHelper(QBaseActivity qBaseActivity, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) bVar);
            return;
        }
        this.f176059h = false;
        this.f176060i = null;
        this.f176062k = 0;
        this.f176063l = new Runnable() { // from class: com.tencent.mobileqq.activity.FriendProfilePhotoHelper.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendProfilePhotoHelper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    FriendProfilePhotoHelper.this.d();
                }
            }
        };
        this.f176064m = new a();
        this.f176053b = qBaseActivity;
        this.f176052a = (QQAppInterface) qBaseActivity.getAppRuntime();
        this.f176058g = bVar;
        this.f176056e = new WeakReferenceHandler(Looper.getMainLooper(), this.f176064m);
        CardHandler cardHandler = (CardHandler) this.f176052a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (cardHandler != null) {
            this.f176057f = cardHandler.G2(this.f176052a, this);
        }
    }

    @Override // com.tencent.mobileqq.app.CardHandler.d
    public void a(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f176051n, 2, String.format("onSendFailed resultCode=%s", Integer.valueOf(i3)));
        }
        this.f176056e.removeCallbacks(this.f176063l);
        d();
        if (i3 == 1503) {
            i16 = R.string.f20338502;
        } else {
            i16 = R.string.ib6;
        }
        if (!com.tencent.mobileqq.utils.u.a().b()) {
            this.f176058g.notifyUser(i16, 1);
        }
    }

    @Override // com.tencent.mobileqq.app.CardHandler.d
    public void b(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bArr);
            return;
        }
        this.f176056e.removeCallbacks(this.f176063l);
        d();
        if (!com.tencent.mobileqq.utils.u.a().b()) {
            this.f176058g.notifyUser(R.string.f173243ib4, 2);
        }
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            byte b16 = wrap.get();
            if (b16 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(f176051n, 2, "error retCode:" + ((int) b16));
                    return;
                }
                return;
            }
            byte[] bArr2 = new byte[4];
            byte[] bArr3 = new byte[4];
            for (int i3 = 0; i3 < 4; i3++) {
                byte b17 = wrap.get();
                bArr2[i3] = b17;
                bArr3[3 - i3] = b17;
            }
            int a16 = (int) com.tencent.mobileqq.troop.utils.g.a(bArr2);
            if (a16 > bArr.length - 5 || a16 < 0) {
                a16 = (int) com.tencent.mobileqq.troop.utils.g.a(bArr3);
            }
            if (QLog.isColorLevel()) {
                QLog.d(f176051n, 2, "len:" + a16 + " bLength:" + HexUtil.bytes2HexStr(bArr2) + " bFlipLength:" + HexUtil.bytes2HexStr(bArr3));
            }
            if (a16 <= bArr.length - 5 && a16 >= 0) {
                byte[] bArr4 = new byte[a16];
                for (int i16 = 0; i16 < a16; i16++) {
                    bArr4[i16] = bArr[i16 + 5];
                }
                this.f176058g.onUploadResult(bArr4);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(f176051n, 2, "\u957f\u5ea6\u8d85\u51fa! len:" + a16 + " extraInfo.length:" + bArr.length);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f176051n, 2, "send finish extraInfo is null");
        }
        this.f176058g.onUploadResult(null);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f176057f != null) {
            ((CardHandler) this.f176052a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).N4(this.f176057f);
            this.f176057f = null;
        }
        this.f176059h = false;
        this.f176060i = null;
        this.f176061j = "";
        this.f176062k = 0;
    }

    protected void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.f176055d;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.f176055d.dismiss();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        this.f176055d = null;
    }

    public void e(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) arrayList);
        } else {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                this.f176058g.notifyUser(R.string.cjm, 1);
                return;
            }
            ((CardHandler) this.f176052a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).A5(arrayList.get(0));
            l();
            this.f176056e.postDelayed(this.f176063l, 30000L);
        }
    }

    public void f(Intent intent, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent, (Object) arrayList);
        } else if (intent.getBooleanExtra(IProfileCardConst.KEY_COVER_PICK_GALLERY, false)) {
            e(arrayList);
        } else {
            g(arrayList);
        }
    }

    public void g(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) arrayList);
        } else if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            this.f176058g.notifyUser(R.string.cjm, 1);
        } else {
            ((CardHandler) this.f176052a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).B5(arrayList);
            l();
        }
    }

    public void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("is_default_key", z16);
        PublicFragmentActivity.b.d(this.f176053b, intent, PublicFragmentActivity.class, CustomCoverFragment.class, 1024);
    }

    protected void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Business_Origin", 101);
        intent.putExtra(IProfileCardConst.KEY_COVER_PICK_GALLERY, true);
        intent.putExtra(PeakConstants.USE_32_BIT_CONFIG, true);
        QBaseActivity qBaseActivity = this.f176053b;
        PhotoUtils.startPhotoEdit(intent, qBaseActivity, qBaseActivity.getClass().getName(), ProfileCardUtil.s(this.f176053b), ProfileCardUtil.q(this.f176053b), ProfileCardUtil.s(this.f176053b), ProfileCardUtil.q(this.f176053b), str, ProfileCardUtil.C());
    }

    public void j(int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) intent);
            return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            this.f176058g.notifyUser(R.string.cjm, 1);
            return;
        }
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("req_code_key", 0);
        if (intExtra == 1025) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                CardHandler cardHandler = (CardHandler) this.f176052a.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
                if (intent.getBooleanExtra(IProfileCardConst.KEY_COVER_PICK_GALLERY, false)) {
                    cardHandler.A5(stringArrayListExtra.get(0));
                    l();
                    this.f176056e.postDelayed(this.f176063l, 30000L);
                    return;
                } else {
                    cardHandler.B5(stringArrayListExtra);
                    l();
                    return;
                }
            }
            return;
        }
        if (intExtra == 1020) {
            if (i3 == -1) {
                String stringExtra = intent.getStringExtra(QZoneHelper.QZoneAlbumConstants.KEY_COVER_SELECTED_IMG_PATH);
                if (!TextUtils.isEmpty(stringExtra)) {
                    i(stringExtra);
                    return;
                }
                return;
            }
            return;
        }
        if (intExtra == 1021) {
            if (i3 == -1) {
                Uri uri = (Uri) intent.getParcelableExtra("upload_uri_key");
                this.f176054c = uri;
                i(BaseImageUtil.getRealPathFromContentURI(this.f176053b, uri));
                return;
            }
            return;
        }
        if (intExtra == 2002 && i3 == -1) {
            this.f176058g.updateCover(ProfileCardManager.o(intent.getStringExtra("card_url_key")));
        }
    }

    public void k(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
            return;
        }
        this.f176060i = bArr;
        this.f176059h = true;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.FriendProfilePhotoHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendProfilePhotoHelper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    FriendsManager friendsManager = (FriendsManager) FriendProfilePhotoHelper.this.f176052a.getManager(QQManagerFactory.FRIENDS_MANAGER);
                    Card r16 = friendsManager.r(FriendProfilePhotoHelper.this.f176052a.getCurrentAccountUin());
                    if (r16 == null) {
                        return;
                    }
                    if (r16.checkCoverUrl(FriendProfilePhotoHelper.this.f176060i)) {
                        r16.updateCoverData(FriendProfilePhotoHelper.this.f176060i);
                    }
                    friendsManager.p0(r16);
                    Object[] coverData = r16.getCoverData(FriendProfilePhotoHelper.this.f176062k);
                    String str = (String) coverData[0];
                    if (!TextUtils.isEmpty(str) && !str.equals(FriendProfilePhotoHelper.this.f176061j)) {
                        FriendProfilePhotoHelper friendProfilePhotoHelper = FriendProfilePhotoHelper.this;
                        friendProfilePhotoHelper.f176061j = str;
                        friendProfilePhotoHelper.f176062k = ((Integer) coverData[1]).intValue();
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }, 16, null, false);
    }

    protected void l() {
        QQProgressDialog qQProgressDialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        try {
            if (!this.f176053b.isFinishing()) {
                if (AppSetting.t(this.f176053b) && (qQProgressDialog = this.f176055d) != null && qQProgressDialog.isShowing()) {
                    return;
                }
                QBaseActivity qBaseActivity = this.f176053b;
                QQProgressDialog qQProgressDialog2 = new QQProgressDialog(qBaseActivity, qBaseActivity.getTitleBarHeight());
                this.f176055d = qQProgressDialog2;
                qQProgressDialog2.setCancelable(false);
                this.f176055d.setMessage(R.string.a2h);
                this.f176055d.show();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void m(Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) card);
            return;
        }
        if (card != null) {
            Object[] coverData = card.getCoverData(this.f176062k);
            String str = (String) coverData[0];
            if (!TextUtils.isEmpty(str) && !str.equals(this.f176061j)) {
                this.f176061j = str;
                this.f176062k = ((Integer) coverData[1]).intValue();
            }
        }
    }
}
