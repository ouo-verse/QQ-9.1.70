package com.tencent.open.agent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.ap;
import com.tencent.mobileqq.config.business.aq;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.PhotoEditResultHelper;
import com.tencent.open.agent.util.t;
import com.tencent.open.virtual.OpenVirtualAccountNickEditorDialog;
import com.tencent.qqconnect.wtlogin.IOpenSdkQQLiteBridgeApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_OPENSDK_AUTH, scene = QQPermissionConstants.Business.SCENE.OPENSDK_CREATE_VIRTUAL_ACCOUNT)
/* loaded from: classes22.dex */
public class OpenVirtualAccountCreatorFragment extends QPublicBaseFragment implements View.OnClickListener, TextWatcher, ep3.m {
    private View D;
    private View E;
    private Drawable F;
    private View G;
    private QQProgressDialog H;
    private Uri K;
    private String M;
    private List<ap.b> N;
    private h R;
    private ep3.l S;
    private QQPermission T;
    private x U;
    private ImageView V;
    private x W;
    private QUIListItemAdapter Y;
    private final String C = "OpenVirtualAccountCreatorFragment";
    private final int I = 1000;
    private long J = 0;
    private final String L = "1001_0cab6b944b59d75644e53b70de2f5d5a";
    protected long P = 0;
    private int Q = 0;
    private boolean X = false;
    private PhotoEditResultHelper Z = new PhotoEditResultHelper(new a());

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements PhotoEditResultHelper.b {
        a() {
        }

        @Override // com.tencent.open.agent.util.PhotoEditResultHelper.b
        public void a(Intent intent) {
            String k3 = com.tencent.open.agent.util.p.k(intent);
            if (TextUtils.isEmpty(k3) || OpenVirtualAccountCreatorFragment.this.U == null) {
                return;
            }
            t.b("OpenVirtualAccountCreatorFragment", "photo edit result path: " + k3);
            x.c O = OpenVirtualAccountCreatorFragment.this.U.O();
            if (O instanceof x.c.d) {
                ((x.c.d) O).j(k3);
                OpenVirtualAccountCreatorFragment.this.Y.l0(OpenVirtualAccountCreatorFragment.this.U);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements OpenVirtualAccountNickEditorDialog.c {
        b() {
        }

        @Override // com.tencent.open.virtual.OpenVirtualAccountNickEditorDialog.c
        public void a(String str) {
            if (OpenVirtualAccountCreatorFragment.this.W != null && !TextUtils.isEmpty(str)) {
                OpenVirtualAccountCreatorFragment.this.Oh(str);
                OpenVirtualAccountCreatorFragment.this.R.c(true);
            }
        }

        @Override // com.tencent.open.virtual.OpenVirtualAccountNickEditorDialog.c
        public void onCancel() {
            OpenVirtualAccountCreatorFragment.this.R.c(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements ActionSheet.OnDismissListener {
        c() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            if (OpenVirtualAccountCreatorFragment.this.R != null) {
                OpenVirtualAccountCreatorFragment.this.R.c(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f339959d;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a extends QQPermission.BasePermissionsListener {
            a() {
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                OpenVirtualAccountCreatorFragment openVirtualAccountCreatorFragment = OpenVirtualAccountCreatorFragment.this;
                openVirtualAccountCreatorFragment.K = com.tencent.open.agent.util.p.e(openVirtualAccountCreatorFragment.getActivity());
            }
        }

        d(ActionSheet actionSheet) {
            this.f339959d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 != 0) {
                boolean z16 = true;
                if (i3 == 1) {
                    if (OpenVirtualAccountCreatorFragment.this.T == null) {
                        OpenVirtualAccountCreatorFragment openVirtualAccountCreatorFragment = OpenVirtualAccountCreatorFragment.this;
                        openVirtualAccountCreatorFragment.T = QQPermissionFactory.getQQPermission(openVirtualAccountCreatorFragment);
                    }
                    if (OpenVirtualAccountCreatorFragment.this.T != null) {
                        if (OpenVirtualAccountCreatorFragment.this.T.hasPermission(QQPermissionConstants.Permission.CAMERA) == 0) {
                            z16 = false;
                        }
                        if (z16) {
                            OpenVirtualAccountCreatorFragment.this.T.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new a());
                        } else {
                            OpenVirtualAccountCreatorFragment openVirtualAccountCreatorFragment2 = OpenVirtualAccountCreatorFragment.this;
                            openVirtualAccountCreatorFragment2.K = com.tencent.open.agent.util.p.e(openVirtualAccountCreatorFragment2.getActivity());
                        }
                    } else {
                        t.e("OpenVirtualAccountCreatorFragment", "click camera QQPermission is null");
                    }
                    OpenVirtualAccountCreatorFragment.this.Z.h();
                }
            } else {
                ((IOpenSdkQQLiteBridgeApi) QRoute.api(IOpenSdkQQLiteBridgeApi.class)).startPhotoListEdit(OpenVirtualAccountCreatorFragment.this.getActivity());
                OpenVirtualAccountCreatorFragment.this.Z.h();
            }
            try {
                this.f339959d.dismiss();
                OpenVirtualAccountCreatorFragment.this.R.c(false);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            OpenVirtualAccountCreatorFragment.this.showActionSheet();
            OpenVirtualAccountCreatorFragment.this.R.d();
            com.tencent.open.agent.util.g.O("0X800C34B");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class f implements Function2<ImageView, String, Unit> {
        f() {
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(ImageView imageView, String str) {
            OpenVirtualAccountCreatorFragment.this.V = imageView;
            if (str != null && !str.isEmpty()) {
                if (str.startsWith("http://") || str.startsWith("https://")) {
                    OpenVirtualAccountCreatorFragment.this.Qh(imageView, str);
                } else {
                    t.f("OpenVirtualAccountCreatorFragment", "loadAvatar path: " + str);
                    OpenVirtualAccountCreatorFragment.this.S.a(str, imageView.getWidth(), imageView.getHeight());
                }
            } else {
                imageView.setImageDrawable(OpenVirtualAccountCreatorFragment.this.F);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            OpenVirtualAccountCreatorFragment.this.Fh();
            com.tencent.open.agent.util.g.O("0X800C34C");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface h {
        void a(long j3);

        void b(int i3);

        void c(boolean z16);

        void d();

        void onCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh() {
        this.R.d();
        String nickName = getNickName();
        t.b("OpenVirtualAccountCreatorFragment", "lastInputNickName = ", nickName);
        com.tencent.open.virtual.h.d(getQBaseActivity(), nickName, new b());
    }

    private String Gh(String str) {
        for (ap.b bVar : this.N) {
            if (TextUtils.equals(bVar.f202521c, str)) {
                return bVar.f202520b;
            }
        }
        return "";
    }

    private void Hh(View view) {
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) view.findViewById(R.id.i4m);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter();
        this.Y = qUIListItemAdapter;
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        x xVar = new x(new x.b.C8996b(getString(R.string.ppu), R.drawable.qui_avatar), new x.c.d("", "", true, false));
        this.U = xVar;
        xVar.x(new e());
        this.U.T(new f());
        x xVar2 = new x(new x.b.C8996b(getString(R.string.ppf), R.drawable.qui_edit), new x.c.g(getString(R.string.f173002rz), true, false));
        this.W = xVar2;
        xVar2.x(new g());
        this.Y.t0(new Group(this.U, this.W));
    }

    private boolean Ih(String str) {
        List<ap.b> list = this.N;
        if (list == null) {
            return false;
        }
        Iterator<ap.b> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f202521c, str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh() {
        if (this.D.isEnabled()) {
            String str = this.M;
            if (str == null || str.equals("1001_0cab6b944b59d75644e53b70de2f5d5a") || TextUtils.isEmpty(getNickName())) {
                this.D.setEnabled(false);
                return;
            }
            return;
        }
        String str2 = this.M;
        if (str2 != null && !str2.equals("1001_0cab6b944b59d75644e53b70de2f5d5a") && !TextUtils.isEmpty(getNickName())) {
            this.D.setEnabled(true);
        }
    }

    private void Kh(Activity activity, int i3) {
        if (i3 == 151) {
            AuthUIUtil.l(activity, HardCodeUtil.qqStr(R.string.f213545qh), false);
            this.R.b(i3);
        } else {
            if (i3 == 10670) {
                AuthUIUtil.l(activity, HardCodeUtil.qqStr(R.string.f213585ql), false);
                return;
            }
            if (i3 == 10710) {
                AuthUIUtil.l(activity, HardCodeUtil.qqStr(R.string.f213595qm), false);
                return;
            }
            AuthUIUtil.l(activity, HardCodeUtil.qqStr(R.string.l57) + i3, false);
        }
    }

    private void Lh(Activity activity, long j3) {
        AuthUIUtil.l(activity, HardCodeUtil.qqStr(R.string.f171818l55), true);
        this.R.a(j3);
    }

    private void Mh() {
        String nickName = getNickName();
        t.b("OpenVirtualAccountCreatorFragment", "onSaveBtnClick name=", nickName, ", mCurrentIconLocalPath=", this.M);
        if (System.currentTimeMillis() - this.J <= 1000) {
            t.b("OpenVirtualAccountCreatorFragment", "onSaveBtnClick repeat click");
            return;
        }
        this.J = System.currentTimeMillis();
        if (TextUtils.isEmpty(nickName)) {
            AuthUIUtil.l(getActivity(), HardCodeUtil.qqStr(R.string.l56), false);
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            t.e("OpenVirtualAccountCreatorFragment", "onSaveBtnClick network not available ");
            AuthUIUtil.l(getActivity(), HardCodeUtil.qqStr(R.string.f172922rr), false);
            return;
        }
        showLoading();
        if (TextUtils.isEmpty(this.M)) {
            this.S.b(this.P, nickName, "1001_0cab6b944b59d75644e53b70de2f5d5a", com.tencent.open.agent.util.p.m());
        } else if (Ih(this.M)) {
            this.S.b(this.P, nickName, Gh(this.M), com.tencent.open.agent.util.p.m());
        } else {
            Sh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        x.c O = this.W.O();
        if (O instanceof x.c.g) {
            ((x.c.g) O).h(str);
            this.Y.l0(this.W);
            this.X = true;
        }
        Rh();
    }

    private void Ph() {
        List<ap.b> list = this.N;
        if (list != null && list.size() != 0) {
            ap.b bVar = this.N.get(this.Q % this.N.size());
            if (bVar == null) {
                t.b("OpenVirtualAccountCreatorFragment", " current randomInfo is null");
                return;
            }
            Oh(bVar.f202519a.trim());
            if (!TextUtils.isEmpty(bVar.f202521c)) {
                this.M = bVar.f202521c;
                x.c O = this.U.O();
                if (O instanceof x.c.d) {
                    ((x.c.d) O).j(bVar.f202521c);
                    this.Y.l0(this.U);
                }
                Rh();
            }
            this.Q++;
            return;
        }
        AuthUIUtil.l(getActivity(), HardCodeUtil.qqStr(R.string.l59), false);
        t.b("OpenVirtualAccountCreatorFragment", "randomInfo config is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh(ImageView imageView, String str) {
        if (imageView == null) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = this.F;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        if (drawable2 == null) {
            return;
        }
        drawable2.setDecodeHandler(com.tencent.open.agent.util.p.j());
        if (drawable2.getStatus() == 2) {
            t.b("OpenVirtualAccountCreatorFragment", "setVirtualIcon restartDownload");
            drawable2.restartDownload();
        } else {
            t.b("OpenVirtualAccountCreatorFragment", "setVirtualIcon success");
            imageView.setImageDrawable(drawable2);
        }
    }

    private void Rh() {
        com.tencent.open.util.a.b(new Runnable() { // from class: com.tencent.open.agent.e
            @Override // java.lang.Runnable
            public final void run() {
                OpenVirtualAccountCreatorFragment.this.Jh();
            }
        });
    }

    private void Sh() {
        t.b("OpenVirtualAccountCreatorFragment", "uploadAvatar localPath = " + this.M);
        final String valueOf = String.valueOf(this.P);
        com.tencent.open.model.a b16 = hp3.b.e().b(valueOf);
        if (!TextUtils.isEmpty(this.M) && b16 != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.agent.OpenVirtualAccountCreatorFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    String c16 = com.tencent.open.agent.util.p.c(OpenVirtualAccountCreatorFragment.this.M);
                    t.b("OpenVirtualAccountCreatorFragment", "uploadAvatar appId=", valueOf);
                    OpenVirtualAccountCreatorFragment.this.S.c(valueOf, OpenVirtualAccountCreatorFragment.this.M, com.tencent.open.agent.util.p.m(), c16);
                }
            }, 128, null, false);
        } else {
            t.b("OpenVirtualAccountCreatorFragment", "uploadAvatar params error");
            pe(false, this.M, null, -1);
        }
    }

    private String getNickName() {
        x xVar = this.W;
        String str = null;
        if (xVar == null) {
            t.e("OpenVirtualAccountCreatorFragment", "getNickName fail. configNick is null");
            return null;
        }
        if (!this.X) {
            t.e("OpenVirtualAccountCreatorFragment", "getNickName fail. never set nick");
            return null;
        }
        x.c O = xVar.O();
        if (O instanceof x.c.g) {
            CharSequence text = ((x.c.g) O).getText();
            if (text != null) {
                str = text.toString();
            }
            t.f("OpenVirtualAccountCreatorFragment", "getNickName: " + str);
            return str;
        }
        t.e("OpenVirtualAccountCreatorFragment", "getNickName fail. configNick right is not text");
        return null;
    }

    private void showLoading() {
        this.H = AuthUIUtil.k(getActivity(), this.H, R.layout.b17);
    }

    public void Nh(h hVar) {
        this.R = hVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Rh();
    }

    @Override // ep3.m
    public void df(boolean z16, long j3, int i3) {
        t.b("OpenVirtualAccountCreatorFragment", "onCreateVirtual success=", Boolean.valueOf(z16), ", virtualId=", j3 + ", code=", Integer.valueOf(i3));
        FragmentActivity activity = getActivity();
        if (activity == null) {
            t.e("OpenVirtualAccountCreatorFragment", "onCreateVirtual activity is null");
            return;
        }
        AuthUIUtil.c(activity, this.H);
        if (z16) {
            Lh(activity, j3);
        } else {
            Kh(activity, i3);
        }
        com.tencent.open.agent.util.g.Q(null, "0X800C34E", z16 ? 1 : 0, null);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 != 257) {
            return;
        }
        t.b("OpenVirtualAccountCreatorFragment", "onActivityResult resultCode=", Integer.valueOf(i16));
        AuthUIUtil.c(getActivity(), this.H);
        if (i16 != -1) {
            return;
        }
        com.tencent.open.agent.util.p.n(i3, getQBaseActivity(), this.K);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.D) {
            Mh();
            com.tencent.open.agent.util.g.O("0X800C34A");
        } else if (view == this.E) {
            Ph();
            com.tencent.open.agent.util.g.O("0X800C34D");
        } else if (view == this.G) {
            this.R.onCancel();
            com.tencent.open.agent.util.g.O("0X800C349");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ep3.a.e(this);
        View inflate = layoutInflater.inflate(R.layout.fqu, viewGroup, false);
        this.G = inflate.findViewById(R.id.aou);
        this.E = inflate.findViewById(R.id.hv5);
        this.D = inflate.findViewById(R.id.b7p);
        this.G.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        try {
            if (QQTheme.isNowThemeIsNight()) {
                this.F = getResources().getDrawable(R.drawable.n5b);
            } else {
                this.F = getResources().getDrawable(R.drawable.n5a);
            }
        } catch (OutOfMemoryError e16) {
            t.d("OpenVirtualAccountCreatorFragment", "-->create color drawable oom.", e16);
        }
        ap a16 = aq.a();
        if (a16.a() != null) {
            ArrayList<ap.b> arrayList = a16.a().f202518a;
            this.N = arrayList;
            if (arrayList != null && arrayList.size() > 0) {
                this.Q = Math.abs(new Random().nextInt(this.N.size()));
            }
        }
        QQProgressDialog qQProgressDialog = new QQProgressDialog(getActivity(), 0, R.layout.b17, 17);
        this.H = qQProgressDialog;
        qQProgressDialog.setHeightParams(-1);
        Hh(inflate);
        t.b("OpenVirtualAccountCreatorFragment", "onCreateView appId=", Long.valueOf(this.P), ", mRandIndex=", Integer.valueOf(this.Q), "hashCode=", Integer.valueOf(hashCode()));
        this.X = false;
        this.M = null;
        Rh();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        t.b("OpenVirtualAccountCreatorFragment", "onDestroy ");
        this.Z.g();
        com.tencent.open.base.h.a(getActivity());
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        t.b("OpenVirtualAccountCreatorFragment", "doOnNewIntent====");
        super.onNewIntent(intent);
        AuthUIUtil.c(getActivity(), this.H);
        String k3 = com.tencent.open.agent.util.p.k(intent);
        x.c O = this.U.O();
        if (O instanceof x.c.d) {
            ((x.c.d) O).j(k3);
            this.Y.l0(this.U);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        t.b("OpenVirtualAccountCreatorFragment", "onResume path: " + com.tencent.open.agent.util.p.k(getActivity().getIntent()));
    }

    @Override // ep3.m
    public void pe(boolean z16, String str, String str2, int i3) {
        t.b("OpenVirtualAccountCreatorFragment", "onUploadAvatar success=", Boolean.valueOf(z16), ", filePath=", str, ", headId=" + str2, ", code=", Integer.valueOf(i3));
        if (getActivity() == null) {
            t.e("OpenVirtualAccountCreatorFragment", "onUploadAvatar activity is null");
            return;
        }
        if (!z16) {
            AuthUIUtil.c(getActivity(), this.H);
            AuthUIUtil.l(getActivity(), HardCodeUtil.qqStr(R.string.l5_) + i3, false);
            return;
        }
        String nickName = getNickName();
        if (TextUtils.isEmpty(nickName)) {
            AuthUIUtil.c(getActivity(), this.H);
            AuthUIUtil.l(getActivity(), HardCodeUtil.qqStr(R.string.l58), false);
            return;
        }
        QQProgressDialog qQProgressDialog = this.H;
        if (qQProgressDialog == null || !qQProgressDialog.isShowing()) {
            showLoading();
        }
        this.S.b(this.P, nickName, str2, com.tencent.open.agent.util.p.m());
    }

    @Override // ep3.m
    public void s3(Bitmap bitmap, String str) {
        this.M = str;
        ImageView imageView = this.V;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        Rh();
    }

    public void showActionSheet() {
        ActionSheet b16 = AuthUIUtil.b(getActivity(), null);
        com.tencent.open.agent.util.p.b(b16);
        b16.setRoundCornerTop(true);
        b16.setOnDismissListener(new c());
        b16.setOnButtonClickListener(new d(b16));
        try {
            if (!getActivity().isFinishing()) {
                b16.show();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // ep3.m
    public void tf(ep3.l lVar) {
        this.S = lVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
