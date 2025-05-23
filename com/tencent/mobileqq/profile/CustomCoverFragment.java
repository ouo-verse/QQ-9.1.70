package com.tencent.mobileqq.profile;

import ProfileLogic.QC.profileItem;
import ProfileLogic.QC.readUserInfoRsp;
import ProfileLogic.QC.setUserFlagRsp;
import ProfileLogic.QC.setUserProfileRsp;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationProfileCustomCover;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.qcircle.api.event.QFSSetCoverFeedEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.pendant.proto.qcUserinfoServer;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class CustomCoverFragment extends IphoneTitleBarFragment implements View.OnClickListener, Handler.Callback, SimpleEventReceiver {
    static IPatchRedirector $redirector_;
    private RecyclerView C;
    private i D;
    private QUICheckBox E;
    private View F;
    private ap G;
    private Drawable H;
    private Handler I;
    private QQAppInterface J;
    private ProfileCardManager K;
    private int L;
    private int M;
    private Vector<Integer> N;
    private int P;
    private boolean Q;
    private boolean R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private Uri W;
    private View X;
    private View Y;
    private View Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f259750a0;

    /* renamed from: b0, reason: collision with root package name */
    private SVIPObserver f259751b0;

    /* renamed from: c0, reason: collision with root package name */
    private DialogInterface.OnCancelListener f259752c0;

    /* renamed from: d0, reason: collision with root package name */
    public View.OnClickListener f259753d0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f259754d;

        a(int i3) {
            this.f259754d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CustomCoverFragment.this, i3);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 != 0) {
                QLog.e("Q.profilecard.FrdProfileCard.CustomCoverFragment", 1, "QcUserinfoServer.SsoGetProfile fail, code=" + i3);
                CustomCoverFragment.this.ei(this.f259754d);
                return;
            }
            try {
                qcUserinfoServer.SsoGetProfileRsp ssoGetProfileRsp = new qcUserinfoServer.SsoGetProfileRsp();
                ssoGetProfileRsp.mergeFrom(bArr);
                if (ssoGetProfileRsp.hasSeted.get()) {
                    CustomCoverFragment.this.ei(this.f259754d);
                }
                if (QLog.isColorLevel()) {
                    QLog.i("Q.profilecard.FrdProfileCard.CustomCoverFragment", 1, "hasSetRecommendCover=" + ssoGetProfileRsp.hasSeted.get());
                }
            } catch (Exception e16) {
                QLog.e("Q.profilecard.FrdProfileCard.CustomCoverFragment", 1, e16, new Object[0]);
                CustomCoverFragment.this.ei(this.f259754d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends SVIPObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CustomCoverFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onDefaultCardRsp(boolean z16, Object obj) {
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z18 = true;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            CustomCoverFragment.this.G.b();
            BaseActivity baseActivity = CustomCoverFragment.this.getBaseActivity();
            if (baseActivity == null) {
                return;
            }
            if (z16) {
                if (obj instanceof readUserInfoRsp) {
                    CustomCoverFragment.this.stopTitleProgress();
                    readUserInfoRsp readuserinforsp = (readUserInfoRsp) obj;
                    if (CustomCoverFragment.this.V) {
                        CustomCoverFragment customCoverFragment = CustomCoverFragment.this;
                        if (readuserinforsp.flag == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        customCoverFragment.ci(z17);
                    }
                    CustomCoverFragment.this.S = readuserinforsp.itemid;
                    CustomCoverFragment.this.U = readuserinforsp.index;
                    CustomCoverFragment.this.P = readuserinforsp.listend;
                    if (!TextUtils.isEmpty(readuserinforsp.urlprefix)) {
                        ProfileCardManager.f259995j = readuserinforsp.urlprefix;
                    }
                    CustomCoverFragment.this.di(readuserinforsp.itemlist);
                    if (CustomCoverFragment.this.F != null) {
                        if (CustomCoverFragment.this.N.size() == 0) {
                            CustomCoverFragment.this.F.setVisibility(8);
                            CustomCoverFragment.this.P = 2;
                        } else {
                            CustomCoverFragment.this.F.setVisibility(0);
                        }
                    }
                    if (CustomCoverFragment.this.I != null) {
                        CustomCoverFragment.this.I.sendEmptyMessage(101);
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("onDefaultCardRsp: [readUserInfoRsp] selId=");
                        sb5.append(CustomCoverFragment.this.S);
                        sb5.append(" reqIndex=");
                        sb5.append(CustomCoverFragment.this.U);
                        sb5.append(" footerState=");
                        sb5.append(CustomCoverFragment.this.P);
                        sb5.append(" flag=");
                        if (readuserinforsp.flag != 1) {
                            z18 = false;
                        }
                        sb5.append(z18);
                        sb5.append(" itemList=");
                        ArrayList<profileItem> arrayList = readuserinforsp.itemlist;
                        if (arrayList != null) {
                            i3 = arrayList.size();
                        }
                        sb5.append(i3);
                        QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, sb5.toString());
                        return;
                    }
                    return;
                }
                if (obj instanceof setUserProfileRsp) {
                    int i16 = ((setUserProfileRsp) obj).ret;
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "onDefaultCardRsp: [setUserProfileRsp] ret=" + i16);
                    }
                    if (i16 == 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "onDefaultCardRsp: [setUserProfileRsp] selId=" + CustomCoverFragment.this.S);
                        }
                        Intent intent = new Intent();
                        intent.putExtra("req_code_key", 2002);
                        CustomCoverFragment customCoverFragment2 = CustomCoverFragment.this;
                        intent.putExtra("card_url_key", customCoverFragment2.Yh(customCoverFragment2.T));
                        baseActivity.setResult(-1, intent);
                        baseActivity.finish();
                        return;
                    }
                    if (CustomCoverFragment.this.getActivity() != null) {
                        QQToast.makeText(CustomCoverFragment.this.getActivity(), 1, R.string.i8c, 0).show();
                        return;
                    }
                    return;
                }
                if (obj instanceof setUserFlagRsp) {
                    int i17 = ((setUserFlagRsp) obj).ret;
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "onDefaultCardRsp: [setUserFlagRsp] ret=" + i17);
                    }
                    if (i17 == 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "onDefaultCardRsp: [setUserFlagRsp] setFlag=" + CustomCoverFragment.this.R);
                        }
                        CustomCoverFragment.this.V = true;
                        QQToast.makeText(baseActivity, 0, R.string.i8f, 0).show();
                        if (CustomCoverFragment.this.R) {
                            CustomCoverFragment customCoverFragment3 = CustomCoverFragment.this;
                            customCoverFragment3.ci(customCoverFragment3.R);
                            return;
                        }
                        CustomCoverFragment customCoverFragment4 = CustomCoverFragment.this;
                        customCoverFragment4.ci(customCoverFragment4.R);
                        if (CustomCoverFragment.this.I != null) {
                            CustomCoverFragment.this.I.sendEmptyMessage(101);
                            return;
                        }
                        return;
                    }
                    if (CustomCoverFragment.this.getActivity() != null) {
                        QQToast.makeText(CustomCoverFragment.this.getActivity(), 1, R.string.i8c, 0).show();
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "onDefaultCardRsp: isSuccess=false, cmd=" + obj);
            }
            if ("profilelogic.readUserInfo".equals(obj)) {
                CustomCoverFragment.this.P = 1;
                CustomCoverFragment.this.stopTitleProgress();
                QQToast.makeText(baseActivity, 1, R.string.i0t, 0).show();
                return;
            }
            QQToast.makeText(baseActivity, 1, R.string.i8c, 0).show();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CustomCoverFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else if (CustomCoverFragment.this.getActivity() != null) {
                CustomCoverFragment.this.getActivity().finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CustomCoverFragment.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (view.getId() == R.id.dug) {
                if (CustomCoverFragment.this.J != null) {
                    CustomCoverFragment.this.R = !r0.Q;
                    ((ISVIPHandler) CustomCoverFragment.this.J.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).setDefaultCardFlag(CustomCoverFragment.this.R ? 1 : 0);
                    CustomCoverFragment.this.G.f(0, CustomCoverFragment.this.getString(R.string.f171502fk4), 0, CustomCoverFragment.this.f259752c0);
                    VasCommonReporter.getHistoryFeature().setValue1("daily_cover").setValue2("click").report(false);
                    String currentAccountUin = CustomCoverFragment.this.J.getCurrentAccountUin();
                    if (CustomCoverFragment.this.R) {
                        str = "open_random";
                    } else {
                        str = "close_random";
                    }
                    VasWebviewUtil.reportCommercialDrainage(currentAccountUin, "defaultcard", str, "", 1, 0, 0, "", "", "");
                }
            } else if (CustomCoverFragment.this.getActivity() != null) {
                Object tag = view.getTag();
                if (tag instanceof Integer) {
                    i3 = ((Integer) tag).intValue();
                } else {
                    i3 = 0;
                }
                if (view instanceof Button) {
                    if (CustomCoverFragment.this.Q) {
                        QQToast.makeText(CustomCoverFragment.this.getActivity(), 0, R.string.f170685yi, 0).show();
                    } else if (CustomCoverFragment.this.S != i3) {
                        CustomCoverFragment.this.bi(i3);
                    } else if (i3 == CustomCoverFragment.this.S) {
                        CustomCoverFragment.this.bi(0);
                    }
                } else if (view instanceof ImageView) {
                    Intent intent = new Intent();
                    intent.putExtra("cover_id_key", i3);
                    if (!CustomCoverFragment.this.Q) {
                        if (CustomCoverFragment.this.S != i3) {
                            i16 = 1;
                        }
                    } else {
                        i16 = 0;
                    }
                    intent.putExtra("cover_button_key", i16);
                    PublicFragmentActivity.b.d(CustomCoverFragment.this.getActivity(), intent, PublicFragmentActivity.class, CoverDetailFragment.class, 2001);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class e extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseActivity f259759a;

        e(BaseActivity baseActivity) {
            this.f259759a = baseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CustomCoverFragment.this, (Object) baseActivity);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                CustomCoverFragment.this.Xh(this.f259759a);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class f extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        public f(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CustomCoverFragment.this, (Object) view);
                return;
            }
            this.itemView.setTag(this);
            CustomCoverFragment.this.F = this.itemView.findViewById(R.id.e2y);
            CustomCoverFragment.this.F.setVisibility(8);
            CustomCoverFragment.this.E = (QUICheckBox) this.itemView.findViewById(R.id.dug);
            CustomCoverFragment.this.E.setOnClickListener(CustomCoverFragment.this.f259753d0);
            BaseAIOUtils.h(CustomCoverFragment.this.E, 0, 0, (int) ((((IphoneTitleBarFragment) CustomCoverFragment.this).mDensity * 20.0f) + 0.5f), (int) ((((IphoneTitleBarFragment) CustomCoverFragment.this).mDensity * 20.0f) + 0.5f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class g extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f259762d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f259763e;

        /* renamed from: f, reason: collision with root package name */
        TextView f259764f;

        /* renamed from: h, reason: collision with root package name */
        QUIButton f259765h;

        public g(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CustomCoverFragment.this, (Object) view);
                return;
            }
            view.setTag(this);
            this.f259763e = (ImageView) view.findViewById(R.id.dce);
            this.f259764f = (TextView) view.findViewById(R.id.jfo);
            QUIButton qUIButton = (QUIButton) view.findViewById(R.id.ama);
            this.f259765h = qUIButton;
            qUIButton.setOnClickListener(CustomCoverFragment.this.f259753d0);
            this.f259763e.setOnClickListener(CustomCoverFragment.this.f259753d0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class h extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        TextView f259767d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f259768e;

        public h(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CustomCoverFragment.this, (Object) view);
                return;
            }
            this.itemView.setTag(this);
            this.f259767d = (TextView) view.findViewById(R.id.f165265cj4);
            this.f259768e = (ImageView) view.findViewById(R.id.civ);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class i extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        static IPatchRedirector $redirector_;

        public i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CustomCoverFragment.this);
            }
        }

        private void q(g gVar) {
            if (CustomCoverFragment.this.Q) {
                gVar.f259765h.setBackgroundDisabled();
                gVar.f259765h.setText(R.string.cxt);
            } else if (gVar.f259762d == CustomCoverFragment.this.S && CustomCoverFragment.this.V) {
                gVar.f259765h.setBackgroundDisabled();
                gVar.f259765h.setText(R.string.hgn);
            } else {
                gVar.f259765h.o();
                gVar.f259765h.setText(R.string.cxt);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            if (CustomCoverFragment.this.N == null) {
                size = 0;
            } else {
                size = CustomCoverFragment.this.N.size();
            }
            return size + 2;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
            }
            if (i3 == 0) {
                return 0;
            }
            if (CustomCoverFragment.this.N != null && i3 > CustomCoverFragment.this.N.size()) {
                return 2;
            }
            return 1;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder, i3);
            } else if (viewHolder instanceof g) {
                g gVar = (g) viewHolder;
                ProfileCardManager.a p16 = p(i3);
                if (p16 != null) {
                    gVar.f259762d = p16.f260008a;
                    gVar.f259764f.setText(p16.f260009b);
                    if (TextUtils.isEmpty(p16.f260010c)) {
                        gVar.f259763e.setImageDrawable(CustomCoverFragment.this.H);
                    } else {
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mRequestWidth = CustomCoverFragment.this.L;
                        obtain.mRequestHeight = CustomCoverFragment.this.M;
                        obtain.mLoadingDrawable = CustomCoverFragment.this.H;
                        obtain.mFailedDrawable = CustomCoverFragment.this.H;
                        gVar.f259763e.setImageDrawable(URLDrawable.getDrawable(p16.f260010c, obtain));
                    }
                    gVar.f259765h.setTag(Integer.valueOf(p16.f260008a));
                    gVar.f259763e.setTag(Integer.valueOf(p16.f260008a));
                } else {
                    gVar.f259765h.setTag(0);
                    gVar.f259763e.setTag(0);
                }
                q(gVar);
            } else if (viewHolder instanceof h) {
                h hVar = (h) viewHolder;
                if (CustomCoverFragment.this.P == 0) {
                    CustomCoverFragment.this.P = 3;
                    CustomCoverFragment.this.ai();
                }
                if (CustomCoverFragment.this.P == 3) {
                    hVar.itemView.setVisibility(0);
                    hVar.f259767d.setTextColor(-16777216);
                    hVar.f259767d.setText(R.string.f169986bg);
                    hVar.f259768e.setVisibility(8);
                } else if (CustomCoverFragment.this.P == 1) {
                    hVar.itemView.setVisibility(0);
                    hVar.f259767d.setTextColor(CustomCoverFragment.this.getResources().getColor(R.color.f157117k9));
                    hVar.f259767d.setText(R.string.f170687yk);
                    hVar.f259768e.setVisibility(0);
                } else if (CustomCoverFragment.this.P == 2) {
                    hVar.itemView.setVisibility(8);
                }
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup, i3);
            }
            if (i3 == 0) {
                return new f(CustomCoverFragment.this.getActivity().getLayoutInflater().inflate(R.layout.be9, viewGroup, false));
            }
            if (i3 == 1) {
                g gVar = new g(CustomCoverFragment.this.getActivity().getLayoutInflater().inflate(R.layout.be_, viewGroup, false));
                gVar.f259763e.getLayoutParams().height = CustomCoverFragment.this.M;
                return gVar;
            }
            if (i3 == 2) {
                return new h(CustomCoverFragment.this.getActivity().getLayoutInflater().inflate(R.layout.bbn, viewGroup, false));
            }
            return null;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewHolder);
                return;
            }
            super.onViewAttachedToWindow(viewHolder);
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
                StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
                boolean z16 = true;
                if (getItemViewType(viewHolder.getLayoutPosition()) == 1) {
                    z16 = false;
                }
                layoutParams2.setFullSpan(z16);
            }
        }

        public ProfileCardManager.a p(int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ProfileCardManager.a) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            if (CustomCoverFragment.this.N != null && i3 > 0 && i3 - 1 < CustomCoverFragment.this.N.size() && CustomCoverFragment.this.K != null) {
                return CustomCoverFragment.this.K.q(((Integer) CustomCoverFragment.this.N.get(i16)).intValue(), false);
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class j extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f259771d;

        public j(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CustomCoverFragment.this, i3);
            } else {
                this.f259771d = i3;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, rect, view, recyclerView, state);
                return;
            }
            if (!(view.getTag() instanceof g)) {
                rect.left = 0;
                return;
            }
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view) - 1;
            int i3 = this.f259771d;
            float f16 = ((i3 * 2) * 1.0f) / 3.0f;
            float f17 = childLayoutPosition % 3;
            rect.left = (int) ((i3 - f16) * f17);
            rect.right = (int) (f16 - (f17 * (i3 - f16)));
        }
    }

    public CustomCoverFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.P = 2;
        this.f259750a0 = false;
        this.f259751b0 = new b();
        this.f259752c0 = new c();
        this.f259753d0 = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xh(BaseActivity baseActivity) {
        this.W = ProfileCardUtils.enterSnapshot(baseActivity, 1021);
        ReportController.o(baseActivity.app, "CliOper", "", "", "0X8006A89", "0X8006A89", 0, 0, "", "", "", "");
        VasLogReporter.getProfileCard().reportHighest("enter capture");
    }

    private void Zh(int i3) {
        if (!com.tencent.relation.common.config.toggle.c.f364702o.g(false)) {
            ei(i3);
        } else {
            ProtoUtils.d(this.J, new a(i3), new qcUserinfoServer.SsoGetProfileReq().toByteArray(), "trpc.qqva.qc_userinfo_server.QcUserinfoServer.SsoGetProfile");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai() {
        if (this.J != null) {
            if (!this.f259750a0) {
                startTitleProgress();
                this.f259750a0 = true;
            }
            ((ISVIPHandler) this.J.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).requestDefaultCardInfo(this.U);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(int i3) {
        QQAppInterface qQAppInterface = this.J;
        if (qQAppInterface != null) {
            this.T = i3;
            ((ISVIPHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).setDefaultCardId(i3);
            this.G.f(0, getString(R.string.f171502fk4), 0, this.f259752c0);
            VasWebviewUtil.reportCommercialDrainage(this.J.getCurrentAccountUin(), "defaultcard", "set_defaultcard", "", 1, 0, 0, "", Integer.toString(i3), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(boolean z16) {
        this.Q = z16;
        QUICheckBox qUICheckBox = this.E;
        if (qUICheckBox != null) {
            qUICheckBox.setChecked(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(List<profileItem> list) {
        if (list != null && this.J != null && this.K != null) {
            for (profileItem profileitem : list) {
                this.K.q(profileitem.itemid, true);
                if (!this.N.contains(Integer.valueOf(profileitem.itemid))) {
                    this.N.add(Integer.valueOf(profileitem.itemid));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ei(int i3) {
        RecyclerView recyclerView = (RecyclerView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.i4m);
        this.C = recyclerView;
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, 1));
        i iVar = new i();
        this.D = iVar;
        this.C.setAdapter(iVar);
        this.C.addItemDecoration(new j(i3));
        ai();
        VasCommonReporter.getHistoryFeature().setValue1("daily_cover").setValue2("show").report();
    }

    public String Yh(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        ProfileCardManager.a q16 = this.K.q(i3, false);
        if (q16 != null && !TextUtils.isEmpty(q16.f260011d)) {
            QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "getItemCoverUrl: " + q16.f260011d);
            return q16.f260011d;
        }
        QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "getItemCoverUrl: null");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        int i3;
        int i16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        setTitle(getResources().getString(R.string.btz));
        TextView textView = this.mLeftBackText;
        if (textView != null) {
            textView.setText("");
        }
        TextView textView2 = this.leftView;
        if (textView2 != null) {
            textView2.setText("");
        }
        ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.c_).setOnClickListener(this);
        ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163927cl).setOnClickListener(this);
        ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163919c7).setOnClickListener(this);
        this.Z = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.s9x);
        this.Y = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.trm);
        this.Z.setOnClickListener(this);
        View view = this.Z;
        if (view instanceof FormSimpleItem) {
            ((FormSimpleItem) view).setLeftText(com.dataline.util.j.d(getContext().getString(R.string.f159981ts)));
        }
        this.V = getBaseActivity().getIntent().getBooleanExtra("is_default_key", true);
        QQAppInterface qQAppInterface = getBaseActivity().app;
        this.J = qQAppInterface;
        int i17 = QQManagerFactory.VAS_EXTENSION_MANAGER;
        this.K = ((ao) qQAppInterface.getManager(i17)).f308431i;
        int dip2px = ViewUtils.dip2px(3.0f);
        int screenWidth = ((ViewUtils.getScreenWidth() - (dip2px * 2)) - (ViewUtils.dip2px(16.0f) * 2)) / 3;
        this.L = screenWidth;
        this.M = (int) (screenWidth * 0.77f);
        this.N = new Vector<>();
        this.I = new Handler(this);
        ((ao) this.J.getManager(i17)).f308431i.f260000e = this.I;
        this.G = new ap(getActivity(), R.layout.f168851b15);
        try {
            this.H = getActivity().getResources().getDrawable(R.drawable.h7o);
        } catch (Exception e16) {
            QLog.e("Q.profilecard.FrdProfileCard.CustomCoverFragment", 1, "doOnCreateView: ", e16);
        }
        Zh(dip2px);
        if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "doOnCreateView: mIsDefaultTypeCard=" + this.V);
        }
        this.X = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.trn);
        boolean decodeBool = QMMKV.from(getActivity(), QMMKVFile.FILE_QCIRCLE).decodeBool("qcircle_cover_red_dot_show", true);
        boolean c75 = uq3.c.c7();
        View view2 = this.X;
        int i18 = 0;
        if (decodeBool && c75) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view2.setVisibility(i3);
        View view3 = this.Z;
        if (c75) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        view3.setVisibility(i16);
        View view4 = this.Y;
        if (!c75) {
            i18 = 8;
        }
        view4.setVisibility(i18);
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(((IphoneTitleBarFragment) this).mContentView, "pg_user_profile_cover_setting");
        HashMap hashMap = new HashMap();
        if (decodeBool) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put(ProfileCardDtReportUtil.IS_REDDOT, str);
        VideoReport.setElementId(this.Z, ProfileCardDtReportUtil.DT_XSJ_COVER_SET_EID);
        VideoReport.setElementParams(this.Z, hashMap);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.bea;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ArrayList) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSetCoverFeedEvent.class);
        return arrayList;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 101) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "handleMessage: refresh list");
            }
            this.D.notifyDataSetChanged();
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        if (i3 == 1021) {
            intent.putExtra("upload_uri_key", this.W);
        }
        if (i3 != 1020 && i3 != 1021) {
            if (i3 == 2001 && i16 == -1) {
                QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "onActivityResult: ");
                int intExtra = intent.getIntExtra("cover_id_key", 0);
                intent.putExtra("req_code_key", 2002);
                intent.putExtra("card_url_key", Yh(intExtra));
                getActivity().setResult(i16, intent);
                getActivity().finish();
                return;
            }
        } else if (i16 == -1) {
            intent.putExtra("req_code_key", i3);
            getActivity().setResult(i16, intent);
            getActivity().finish();
            return;
        }
        super.onActivityResult(i3, i16, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            BaseActivity baseActivity = getBaseActivity();
            if (baseActivity != null && baseActivity.app != null) {
                int id5 = view.getId();
                if (id5 == R.id.c_) {
                    Intent intent = new Intent(baseActivity, (Class<?>) NewPhotoListActivity.class);
                    intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 44);
                    intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationProfileCustomCover.F);
                    intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", baseActivity.getClass().getName());
                    intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
                    intent.putExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, false);
                    intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
                    intent.putExtra(PeakConstants.IS_SINGLE_NEED_EDIT, true);
                    intent.putExtra(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, true);
                    intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
                    int s16 = ProfileCardUtil.s(baseActivity);
                    int q16 = ProfileCardUtil.q(baseActivity);
                    intent.putExtra(PeakConstants.CLIP_WIDTH, s16);
                    intent.putExtra(PeakConstants.CLIP_HEIGHT, q16);
                    intent.putExtra(PeakConstants.USE_32_BIT_CONFIG, true);
                    intent.putExtra(PeakConstants.TARGET_WIDTH, s16);
                    intent.putExtra(PeakConstants.TARGET_HEIGHT, q16);
                    intent.putExtra(PeakConstants.TARGET_PATH, ProfileCardUtil.r());
                    intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
                    intent.putExtra(IProfileCardConst.KEY_COVER_PICK_GALLERY, true);
                    startActivity(intent);
                    QAlbumUtil.anim(baseActivity, false, true);
                    ReportController.o(baseActivity.app, "CliOper", "", "", "0X8006A87", "0X8006A87", 0, 0, "", "", "", "");
                    VasLogReporter.getProfileCard().reportHighest("enter gallary");
                } else if (id5 == R.id.f163927cl) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_personal_album_enter_model", 2);
                    bundle.putInt("_input_max", 1);
                    bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_MULTIPLE_MODEL_NEED_DOWNLOAD_IMG, true);
                    QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                    userInfo.qzone_uin = baseActivity.app.getCurrentAccountUin();
                    bundle.putString("keyAction", "actionSelectPicture");
                    bundle.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_NEED_CHANGE_TO_JPG, true);
                    QZoneHelper.forwardToPersonalAlbumSelect(baseActivity, userInfo, bundle, 1020);
                    ReportController.o(baseActivity.app, "CliOper", "", "", "0X8006A88", "0X8006A88", 0, 0, "", "", "", "");
                    VasLogReporter.getProfileCard().reportHighest("enter qzone");
                } else if (id5 == R.id.s9x) {
                    com.tencent.mobileqq.activity.qcircle.utils.c.g().enterByScheme(getContext(), "mqqapi://qcircle/openpersonalcoverfeedpage");
                    QMMKV.from(getActivity(), QMMKVFile.FILE_QCIRCLE).encodeBool("qcircle_cover_red_dot_show", false);
                    VasLogReporter.getProfileCard().reportHighest("enter qcircle");
                } else if (id5 == R.id.f163919c7) {
                    QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.COVER));
                    if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
                        qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new e(baseActivity));
                    } else {
                        Xh(baseActivity);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ProfileCardManager profileCardManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        if (this.J != null && (profileCardManager = this.K) != null) {
            profileCardManager.f260000e = null;
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) intent);
            return;
        }
        super.onNewIntent(intent);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        FragmentActivity activity = getActivity();
        if (stringArrayListExtra != null && stringArrayListExtra.size() > 0 && activity != null) {
            if (this.R && VasNormalToggle.BUG_CUSTOM_COVER_OPT.isEnable(true)) {
                QLog.i("Q.profilecard.FrdProfileCard.CustomCoverFragment", 1, "update daily cover to close");
                ((ISVIPHandler) this.J.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).setDefaultCardFlag(0);
            }
            intent.putExtra("req_code_key", 1025);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onPause();
        QQAppInterface qQAppInterface = this.J;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f259751b0);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) simpleBaseEvent);
        } else if ((simpleBaseEvent instanceof QFSSetCoverFeedEvent) && getActivity() != null && !getActivity().isFinishing()) {
            getActivity().finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        QQAppInterface qQAppInterface = this.J;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.f259751b0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
