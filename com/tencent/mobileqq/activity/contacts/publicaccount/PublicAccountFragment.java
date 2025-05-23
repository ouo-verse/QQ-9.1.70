package com.tencent.mobileqq.activity.contacts.publicaccount;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountReport;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.comic.api.IQQComicConfigApi;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.em;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.guild.api.GuildPublicAccountParams;
import com.tencent.mobileqq.guild.api.IGuildDiscoverApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mp.mobileqq_mp$ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountLauncher;
import com.tencent.mobileqq.qcircle.api.ITVideoPublicAccountLauncherApi;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountLauncherSource;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.EcommerceMsgCenterSource;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqnews.api.IQQNewsCommApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.vas.api.IVasReadPublicAccount;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.z1.mod.api.IZPlanPublicAccountLauncherApi;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8$ConfigGroupInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8$ConfigInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes10.dex */
public class PublicAccountFragment extends ContactsBaseFragment implements AdapterView.OnItemClickListener, IndexView.b {
    static IPatchRedirector $redirector_;
    private boolean N;
    protected View P;
    protected PinnedDividerListView Q;
    protected IndexView R;
    protected View S;
    protected g T;
    protected IPublicAccountDataManager U;
    protected MqqHandler V;
    protected List<f> W;
    protected Drawable X;
    protected NewIntent Y;
    protected Handler.Callback Z;

    /* renamed from: a0, reason: collision with root package name */
    private Comparator<f> f181660a0;

    /* renamed from: b0, reason: collision with root package name */
    private ar f181661b0;

    /* renamed from: c0, reason: collision with root package name */
    private IPublicAccountObserver f181662c0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment$7, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass7 implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f181665d;

        AnonymousClass7(f fVar) {
            this.f181665d = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountFragment.this, (Object) fVar);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Contacts.PublicAccountFragment", 2, "success:" + String.valueOf(z16));
            }
            if (!z16) {
                return;
            }
            try {
                byte[] byteArray = bundle.getByteArray("data");
                int i16 = bundle.getInt("type", 0);
                if (byteArray != null) {
                    mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse = new mobileqq_mp$GetPublicAccountDetailInfoResponse();
                    oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse oidb_cmd0xcf8_getpublicaccountdetailinforesponse = new oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse();
                    if (i16 == 0) {
                        mobileqq_mp_getpublicaccountdetailinforesponse.mergeFrom(byteArray);
                    } else {
                        z17 = PublicAccountFragment.ei(byteArray, oidb_cmd0xcf8_getpublicaccountdetailinforesponse, mobileqq_mp_getpublicaccountdetailinforesponse);
                    }
                    if (z17 && mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.has() && mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.get().ret_code.has() && mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.get().ret_code.get() == 0) {
                        ThreadManagerV2.executeDelay(new Runnable(mobileqq_mp_getpublicaccountdetailinforesponse) { // from class: com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.7.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ mobileqq_mp$GetPublicAccountDetailInfoResponse f181667d;

                            {
                                this.f181667d = mobileqq_mp_getpublicaccountdetailinforesponse;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this, (Object) mobileqq_mp_getpublicaccountdetailinforesponse);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                IPublicAccountDetail init = ((IPublicAccountDetail) QRoute.api(IPublicAccountDetail.class)).init(this.f181667d);
                                if (init == null) {
                                    QLog.d("Contacts.PublicAccountFragment", 1, "detail == null");
                                    return;
                                }
                                PublicAccountInfo createPublicAccount = PublicAccountInfo.createPublicAccount(init, 0L);
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable(createPublicAccount) { // from class: com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.7.1.1
                                    static IPatchRedirector $redirector_;

                                    /* renamed from: d, reason: collision with root package name */
                                    final /* synthetic */ PublicAccountInfo f181669d;

                                    {
                                        this.f181669d = createPublicAccount;
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) createPublicAccount);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                        f fVar = anonymousClass7.f181665d;
                                        if (fVar != null) {
                                            fVar.f181676a.uid = this.f181669d.uid;
                                        }
                                        PublicAccountFragment publicAccountFragment = PublicAccountFragment.this;
                                        PublicAccountInfo publicAccountInfo = this.f181669d;
                                        publicAccountFragment.ii(publicAccountInfo, publicAccountInfo.getUin(), this.f181669d.uid);
                                    }
                                });
                                if (((ContactsBaseFragment) PublicAccountFragment.this).E == null) {
                                    QLog.d("Contacts.PublicAccountFragment", 1, "app == null");
                                    return;
                                }
                                EntityManager createEntityManager = ((ContactsBaseFragment) PublicAccountFragment.this).E.getEntityManagerFactory().createEntityManager();
                                if (createEntityManager != null) {
                                    createEntityManager.persistOrReplace(init.getEntity());
                                    createEntityManager.close();
                                }
                                IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) ((ContactsBaseFragment) PublicAccountFragment.this).E.getRuntimeService(IPublicAccountDataManager.class, "all");
                                if (iPublicAccountDataManager != null) {
                                    iPublicAccountDataManager.saveAccountDetailInfoCache(init);
                                    iPublicAccountDataManager.savePublicAccountInfo(createPublicAccount);
                                }
                            }
                        }, 32, null, false, 10L);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes10.dex */
    class a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountFragment.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            if (message.what == 0) {
                PublicAccountFragment.this.ji();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes10.dex */
    class b extends IPublicAccountObserver.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountFragment.this);
            }
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onFollowPublicAccount(int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Contacts.PublicAccountFragment", 2, "onFollowPublicAccount errCode: " + i3);
            }
            if (i3 == 0) {
                PublicAccountFragment.this.ji();
            }
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onUnfollowPublicAccount(int i3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Contacts.PublicAccountFragment", 2, "onUnfollowPublicAccount errCode: " + i3);
            }
            if (i3 == 0) {
                PublicAccountFragment.this.ji();
            }
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onUpdateUserFollowList(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Contacts.PublicAccountFragment", 2, "onUpdateUserFollowList errCode: " + i3 + " isFinish:" + z16);
            }
            if (z16) {
                if (PublicAccountFragment.this.N) {
                    if (((ContactsBaseFragment) PublicAccountFragment.this).C != null) {
                        ((ContactsBaseFragment) PublicAccountFragment.this).C.c(PublicAccountFragment.this.th(), true, null);
                    }
                    PublicAccountFragment.this.N = false;
                }
                PublicAccountFragment.this.ji();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                em.c(((ContactsBaseFragment) PublicAccountFragment.this).K, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes10.dex */
    class d implements Comparator<f> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountFragment.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar, (Object) fVar2)).intValue();
            }
            String str = fVar.f181676a.name;
            String str2 = fVar2.f181676a.name;
            if (str == null && str2 == null) {
                return 0;
            }
            if (str == null && str2 != null) {
                return -1;
            }
            if (str != null && str2 == null) {
                return 1;
            }
            int length = str.length();
            int length2 = str2.length();
            int min = Math.min(length, length2);
            for (int i3 = 0; i3 < min; i3++) {
                char charAt = str.charAt(i3);
                char charAt2 = str2.charAt(i3);
                if (charAt != charAt2) {
                    ChnToSpell.a b16 = ChnToSpell.b(charAt, i3);
                    ChnToSpell.a b17 = ChnToSpell.b(charAt2, i3);
                    int i16 = b16.f306904a;
                    int i17 = b17.f306904a;
                    if (i16 == i17) {
                        return b16.f306905b.compareTo(b17.f306905b);
                    }
                    return i16 - i17;
                }
            }
            if (length < length2) {
                return -1;
            }
            if (length <= length2) {
                return 0;
            }
            return 1;
        }
    }

    /* loaded from: classes10.dex */
    class e extends ar {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PublicAccountFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
            } else if (z16) {
                PublicAccountFragment.this.ji();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public PublicAccountInfo f181676a;

        /* renamed from: b, reason: collision with root package name */
        public String f181677b;

        /* renamed from: c, reason: collision with root package name */
        public String f181678c;

        public f(PublicAccountInfo publicAccountInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) publicAccountInfo);
                return;
            }
            this.f181677b = "";
            this.f181678c = "";
            this.f181676a = publicAccountInfo;
        }

        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            if (str == null) {
                str = "";
            }
            this.f181678c = str;
        }

        public void b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            if (str == null) {
                str = "";
            }
            this.f181677b = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public class g extends com.tencent.mobileqq.adapter.e {
        static IPatchRedirector $redirector_;
        View.OnClickListener D;
        public LinkedHashMap<String, List<f>> E;
        public int[] F;
        public String[] G;
        public int H;
        public int I;
        private boolean J;

        /* loaded from: classes10.dex */
        class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else if (view.getId() == R.id.ao6) {
                    String str = (String) view.getTag(-1);
                    String str2 = (String) view.getTag(-2);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        CrmUtils.z(((ContactsBaseFragment) PublicAccountFragment.this).E, ((ContactsBaseFragment) PublicAccountFragment.this).K, str2, str, "IvrEnterpriseDetailEngineFalse");
                    } else if (QLog.isColorLevel()) {
                        QLog.w("Contacts.PublicAccountFragment", 2, "onClick - uin = " + str + ", name = " + str2);
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public g(PublicAccountFragment publicAccountFragment) {
            this(((ContactsBaseFragment) publicAccountFragment).K, ((ContactsBaseFragment) publicAccountFragment).E, publicAccountFragment.Q, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) publicAccountFragment);
        }

        private void j(View view, String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            VideoReport.setElementId(view, "em_kl_contact_people_unit");
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementParam(view, "user_type", 5);
            VideoReport.setElementParam(view, "user_id", str);
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) view, i3);
                return;
            }
            int binarySearch = Arrays.binarySearch(this.F, i3);
            if (binarySearch < 0) {
                binarySearch = (-(binarySearch + 1)) - 1;
            }
            if (binarySearch < this.G.length && binarySearch >= 0 && (view instanceof TextView)) {
                TextView textView = (TextView) view;
                int paddingLeft = textView.getPaddingLeft();
                int paddingTop = textView.getPaddingTop();
                Resources resources = textView.getResources();
                if (QUITokenResUtil.useQUIToken() && resources != null) {
                    textView.setBackground(resources.getDrawable(R.drawable.qui_common_fill_light_primary_bg, null));
                } else if (!ThemeUtil.isNowThemeDefaultCache && !ThemeUtil.isNowThemeIsNight(((ContactsBaseFragment) PublicAccountFragment.this).E, false, null) && !ThemeUtil.isNowThemeIsSimple(((ContactsBaseFragment) PublicAccountFragment.this).E, false, null)) {
                    textView.setBackgroundColor(553648127);
                } else {
                    textView.setBackgroundResource(R.drawable.skin_list_item_normal_theme_version2);
                }
                textView.setPadding(paddingLeft, paddingTop, 0, 0);
                textView.setText(this.G[binarySearch]);
                textView.setTextColor(((ContactsBaseFragment) PublicAccountFragment.this).K.getResources().getColorStateList(QUITokenResUtil.getResId(R.color.skin_gray2_theme_version2, R.color.qui_common_text_secondary)));
                if (ThemeUtil.isNowThemeIsSimple(((ContactsBaseFragment) PublicAccountFragment.this).E, false, null) && !QUITokenResUtil.useQUIToken()) {
                    if (ThemeUtil.isNowThemeIsNight(((ContactsBaseFragment) PublicAccountFragment.this).E, false, null)) {
                        i16 = -1;
                    } else {
                        i16 = -16777216;
                    }
                    textView.setTextColor(i16);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.adapter.e
        public boolean f(k kVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) kVar)).booleanValue();
            }
            if (kVar.f187212f == null) {
                return false;
            }
            return super.f(kVar);
        }

        public void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            this.E.clear();
            this.F = new int[0];
            this.G = new String[0];
            this.J = false;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            if (this.F.length == 0 || !this.J) {
                return 0;
            }
            List<f> list = this.E.get(this.G[r2.length - 1]);
            if (list == null) {
                return 0;
            }
            return this.F[r1.length - 1] + list.size() + 1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return QUITokenResUtil.getResId(R.layout.f168254qf, R.layout.fg8);
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            int binarySearch = Arrays.binarySearch(this.F, i3);
            if (binarySearch >= 0) {
                return null;
            }
            return this.E.get(this.G[(-(binarySearch + 1)) - 1]).get((i3 - this.F[r0]) - 1);
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            h hVar;
            View view2;
            View view3;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                view3 = view;
                view2 = (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                int binarySearch = Arrays.binarySearch(this.F, i3);
                if (view == null) {
                    view2 = ((ContactsBaseFragment) PublicAccountFragment.this).K.getLayoutInflater().inflate(QUITokenResUtil.getResId(R.layout.f168421vo, R.layout.fs7), viewGroup, false);
                    hVar = new h();
                    hVar.f187211e = 115;
                    hVar.f187213h = (QQProAvatarView) view2.findViewById(R.id.icon);
                    hVar.f181681m = (ImageView) view2.findViewById(R.id.ao6);
                    hVar.F = (TextView) view2.findViewById(R.id.text1);
                    hVar.C = (TextView) view2.findViewById(R.id.g4_);
                    hVar.E = (TextView) view2.findViewById(R.id.g3t);
                    hVar.D = (TextView) view2.findViewById(R.id.g4j);
                    hVar.G = (TextView) view2.findViewById(R.id.text2);
                    hVar.H = (TextView) view2.findViewById(R.id.k8u);
                    hVar.I = view2.findViewById(R.id.g47);
                    hVar.J = (ImageView) view2.findViewById(R.id.anv);
                    view2.setTag(hVar);
                    ImageView imageView = hVar.f187212f;
                    if (imageView instanceof ThemeImageView) {
                        ((ThemeImageView) imageView).setSupportMaskView(false);
                    }
                } else {
                    hVar = (h) view.getTag();
                    view2 = view;
                }
                if (binarySearch < 0) {
                    int i16 = (-(binarySearch + 1)) - 1;
                    f fVar = this.E.get(this.G[i16]).get((i3 - this.F[i16]) - 1);
                    hVar.f181680i = fVar;
                    hVar.f187210d = String.valueOf(fVar.f181676a.uin);
                    View view4 = hVar.I;
                    if (view4 != null) {
                        view4.setVisibility(0);
                    }
                    TextView textView = hVar.H;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    hVar.F.setVisibility(0);
                    hVar.F.setText(fVar.f181676a.name);
                    if (fVar.f181676a.certifiedGrade > 0) {
                        PublicAccountFragment publicAccountFragment = PublicAccountFragment.this;
                        if (publicAccountFragment.X == null) {
                            publicAccountFragment.X = publicAccountFragment.getResources().getDrawable(R.drawable.br7);
                            PublicAccountFragment.this.X.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0f), ImmersiveUtils.dpToPx(15.0f));
                            ThemeUtil.setThemeFilter(PublicAccountFragment.this.X, ThemeUtil.curThemeId);
                        }
                        hVar.F.setCompoundDrawables(null, null, PublicAccountFragment.this.X, null);
                    } else {
                        hVar.F.setCompoundDrawables(null, null, null, null);
                    }
                    hVar.G.setText(fVar.f181676a.summary);
                    hVar.f187213h.w(1, hVar.f187210d);
                    if (fVar.f181676a.extendType == 2) {
                        z16 = CrmUtils.o(((ContactsBaseFragment) PublicAccountFragment.this).E, fVar.f181676a.getUin(), 1024);
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        hVar.f181681m.setTag(-1, fVar.f181676a.getUin());
                        hVar.f181681m.setTag(-2, fVar.f181676a.name);
                        hVar.f181681m.setOnClickListener(this.D);
                        hVar.f181681m.setVisibility(0);
                    } else {
                        hVar.f181681m.setTag(-1, "");
                        hVar.f181681m.setTag(-2, "");
                        hVar.f181681m.setOnClickListener(null);
                        hVar.f181681m.setVisibility(4);
                    }
                    if (!z16) {
                        hVar.J.setTag(-1, "");
                        hVar.J.setTag(-2, "");
                        hVar.J.setOnClickListener(null);
                        hVar.J.setVisibility(4);
                    }
                    hVar.E.setVisibility(8);
                    hVar.C.setVisibility(8);
                    hVar.D.setVisibility(8);
                    if (AppSetting.f99565y) {
                        view2.setContentDescription(hVar.F.getText());
                        view2.setFocusable(true);
                        view2.setFocusableInTouchMode(true);
                    }
                } else {
                    hVar.f181680i = null;
                    hVar.f187210d = "";
                    View view5 = hVar.I;
                    if (view5 != null) {
                        view5.setVisibility(8);
                    }
                    if (hVar.H != null) {
                        String valueOf = String.valueOf(this.G[binarySearch]);
                        hVar.H.setVisibility(0);
                        hVar.H.setText(valueOf);
                        hVar.H.setPadding(hVar.H.getPaddingLeft(), hVar.H.getPaddingTop(), 0, 0);
                        if (AppSetting.f99565y) {
                            hVar.H.setContentDescription(String.format(((ContactsBaseFragment) PublicAccountFragment.this).K.getString(R.string.aud), valueOf.toLowerCase()));
                        }
                    }
                    view3 = view2;
                }
                j(view2, hVar.f187210d);
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        protected void h() {
            char c16;
            int i3;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this);
                return;
            }
            this.E.clear();
            List<f> list = PublicAccountFragment.this.W;
            if (list != null && !list.isEmpty()) {
                Iterator<f> it = PublicAccountFragment.this.W.iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    i3 = 0;
                    String str2 = "#";
                    if (!hasNext) {
                        break;
                    }
                    f next = it.next();
                    String str3 = next.f181677b;
                    if (str3 == null || str3.length() == 0) {
                        str = "#";
                    } else {
                        str = next.f181677b.substring(0, 1);
                    }
                    char charAt = str.charAt(0);
                    if (('A' <= charAt && charAt <= 'Z') || ('a' <= charAt && charAt <= 'z')) {
                        str2 = str.toUpperCase();
                    }
                    if (this.E.get(str2) == null) {
                        this.E.put(str2, new ArrayList());
                    }
                    this.E.get(str2).add(next);
                }
                LinkedHashMap<String, List<f>> linkedHashMap = this.E;
                this.E = new LinkedHashMap<>();
                for (c16 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET; c16 <= 'Z'; c16 = (char) (c16 + 1)) {
                    if (linkedHashMap.get(String.valueOf(c16)) != null) {
                        List<f> list2 = linkedHashMap.get(String.valueOf(c16));
                        Collections.sort(list2, PublicAccountFragment.this.f181660a0);
                        this.E.put(String.valueOf(c16), list2);
                    }
                }
                if (linkedHashMap.get("#") != null) {
                    List<f> list3 = linkedHashMap.get("#");
                    Collections.sort(list3, PublicAccountFragment.this.f181660a0);
                    this.E.put("#", list3);
                }
                linkedHashMap.clear();
                int[] iArr = new int[this.E.keySet().size()];
                this.F = iArr;
                this.G = new String[iArr.length];
                Iterator<String> it5 = this.E.keySet().iterator();
                int[] iArr2 = this.F;
                if (iArr2.length == 0) {
                    return;
                }
                iArr2[0] = 0;
                int i16 = 1;
                while (true) {
                    int[] iArr3 = this.F;
                    if (i16 >= iArr3.length) {
                        break;
                    }
                    iArr3[i16] = iArr3[i16] + iArr3[i16 - 1] + this.E.get(it5.next()).size() + 1;
                    i16++;
                }
                Iterator<String> it6 = this.E.keySet().iterator();
                while (it6.hasNext()) {
                    this.G[i3] = it6.next();
                    i3++;
                }
                this.J = true;
            }
        }

        public int i(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).intValue();
            }
            if (this.G != null) {
                int i3 = 0;
                while (true) {
                    String[] strArr = this.G;
                    if (i3 < strArr.length) {
                        if (strArr[i3].equals(str)) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 >= 0) {
                    return this.F[i3];
                }
            }
            return -1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, i3)).booleanValue();
            }
            if (Arrays.binarySearch(this.F, i3) >= 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean needHideDivider(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) view, i3)).booleanValue();
            }
            if (ThemeUtil.isNowThemeDefaultCache || ThemeUtil.isNowThemeIsNight(((ContactsBaseFragment) PublicAccountFragment.this).E, false, null) || ThemeUtil.isNowThemeIsSimple(((ContactsBaseFragment) PublicAccountFragment.this).E, false, null)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.adapter.e, com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            }
        }

        @Override // com.tencent.mobileqq.adapter.e, com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, (Object) absListView, i3);
                return;
            }
            super.onScrollStateChanged(absListView, i3);
            if (i3 != 0) {
                ApngImage.pauseByTag(3);
            }
            if (i3 == 0) {
                ApngImage.playByTag(3);
            }
        }

        public g(Context context, QQAppInterface qQAppInterface, XListView xListView, boolean z16) {
            super(context, qQAppInterface, xListView, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, PublicAccountFragment.this, context, qQAppInterface, xListView, Boolean.valueOf(z16));
                return;
            }
            this.D = new a();
            this.E = new LinkedHashMap<>();
            this.F = new int[0];
            this.G = new String[0];
            this.H = 0;
            this.I = 0;
            this.J = false;
            this.f187155d = BaseImageUtil.getDefaultFaceBitmap(true);
        }
    }

    /* loaded from: classes10.dex */
    static class h extends k {
        static IPatchRedirector $redirector_;
        public TextView C;
        public TextView D;
        public TextView E;
        public TextView F;
        public TextView G;
        public TextView H;
        public View I;
        public ImageView J;

        /* renamed from: i, reason: collision with root package name */
        public f f181680i;

        /* renamed from: m, reason: collision with root package name */
        public ImageView f181681m;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public PublicAccountFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.N = false;
        this.T = null;
        this.Z = new a();
        this.f181660a0 = new d();
        this.f181661b0 = new e();
    }

    public static boolean ei(byte[] bArr, oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse oidb_cmd0xcf8_getpublicaccountdetailinforesponse, mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse) {
        int i3;
        if (oidb_cmd0xcf8_getpublicaccountdetailinforesponse == null) {
            return false;
        }
        try {
            oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(bArr);
            if (mergeFrom.uint32_result.has()) {
                i3 = mergeFrom.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.i("Contacts.PublicAccountFragment", 2, "handle OidbSvc.0xcf8|OIDBSSOPke.result=" + i3);
                }
            } else {
                i3 = -1;
            }
            if (i3 != 0 || !mergeFrom.bytes_bodybuffer.has() || mergeFrom.bytes_bodybuffer.get() == null) {
                return false;
            }
            oidb_cmd0xcf8_getpublicaccountdetailinforesponse.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
            if (oidb_cmd0xcf8_getpublicaccountdetailinforesponse.ret_info.has()) {
                mobileqq_mp$RetInfo mobileqq_mp_retinfo = new mobileqq_mp$RetInfo();
                mobileqq_mp_retinfo.ret_code.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.ret_info.get().ret_code.get());
                mobileqq_mp_retinfo.err_info.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.ret_info.get().err_info.get());
                mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.set(mobileqq_mp_retinfo);
            }
            mobileqq_mp_getpublicaccountdetailinforesponse.seqno.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.seqno.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.uin.set((int) oidb_cmd0xcf8_getpublicaccountdetailinforesponse.luin.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.name.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.name.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.display_number.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.display_number.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.summary.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.summary.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.is_recv_msg.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.is_recv_msg.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.is_recv_push.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.is_recv_push.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.certified_grade.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.certified_grade.get());
            if (oidb_cmd0xcf8_getpublicaccountdetailinforesponse.config_group_info.has()) {
                ArrayList arrayList = new ArrayList();
                for (oidb_cmd0xcf8$ConfigGroupInfo oidb_cmd0xcf8_configgroupinfo : oidb_cmd0xcf8_getpublicaccountdetailinforesponse.config_group_info.get()) {
                    ArrayList arrayList2 = new ArrayList();
                    for (oidb_cmd0xcf8$ConfigInfo oidb_cmd0xcf8_configinfo : oidb_cmd0xcf8_configgroupinfo.config_info.get()) {
                        mobileqq_mp$ConfigInfo mobileqq_mp_configinfo = new mobileqq_mp$ConfigInfo();
                        mobileqq_mp_configinfo.type.set(oidb_cmd0xcf8_configinfo.type.get());
                        mobileqq_mp_configinfo.title.set(oidb_cmd0xcf8_configinfo.title.get());
                        mobileqq_mp_configinfo.content.set(oidb_cmd0xcf8_configinfo.content.get());
                        mobileqq_mp_configinfo.event_id.set(oidb_cmd0xcf8_configinfo.event_id.get());
                        mobileqq_mp_configinfo.url.set(oidb_cmd0xcf8_configinfo.url.get());
                        mobileqq_mp_configinfo.auth_type.set(oidb_cmd0xcf8_configinfo.auth_type.get());
                        mobileqq_mp_configinfo.state.set(oidb_cmd0xcf8_configinfo.state.get());
                        mobileqq_mp_configinfo.confirm_flag.set(oidb_cmd0xcf8_configinfo.confirm_flag.get());
                        mobileqq_mp_configinfo.confirm_tips.set(oidb_cmd0xcf8_configinfo.confirm_tips.get());
                        mobileqq_mp_configinfo.state_id.set(oidb_cmd0xcf8_configinfo.state_id.get());
                        arrayList2.add(mobileqq_mp_configinfo);
                    }
                    mobileqq_mp$ConfigGroupInfo mobileqq_mp_configgroupinfo = new mobileqq_mp$ConfigGroupInfo();
                    mobileqq_mp_configgroupinfo.config_info.set(arrayList2);
                    arrayList.add(mobileqq_mp_configgroupinfo);
                }
                mobileqq_mp_getpublicaccountdetailinforesponse.config_group_info.set(arrayList);
            }
            mobileqq_mp_getpublicaccountdetailinforesponse.is_show_share_button.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.is_show_share_button.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.is_show_follow_button.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.is_show_follow_button.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.follow_type.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.follow_type.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.is_sync_lbs.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.is_sync_lbs.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.group_id.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.group_id.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.show_flag.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.show_flag.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.account_flag.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.account_flag.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.luin.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.luin.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.config_background_color.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.config_background_color.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.config_background_img.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.config_background_img.get());
            if (oidb_cmd0xcf8_getpublicaccountdetailinforesponse.config_group_info_new.has()) {
                ArrayList arrayList3 = new ArrayList();
                for (oidb_cmd0xcf8$ConfigGroupInfo oidb_cmd0xcf8_configgroupinfo2 : oidb_cmd0xcf8_getpublicaccountdetailinforesponse.config_group_info_new.get()) {
                    ArrayList arrayList4 = new ArrayList();
                    for (oidb_cmd0xcf8$ConfigInfo oidb_cmd0xcf8_configinfo2 : oidb_cmd0xcf8_configgroupinfo2.config_info.get()) {
                        mobileqq_mp$ConfigInfo mobileqq_mp_configinfo2 = new mobileqq_mp$ConfigInfo();
                        mobileqq_mp_configinfo2.type.set(oidb_cmd0xcf8_configinfo2.type.get());
                        mobileqq_mp_configinfo2.title.set(oidb_cmd0xcf8_configinfo2.title.get());
                        mobileqq_mp_configinfo2.content.set(oidb_cmd0xcf8_configinfo2.content.get());
                        mobileqq_mp_configinfo2.event_id.set(oidb_cmd0xcf8_configinfo2.event_id.get());
                        mobileqq_mp_configinfo2.url.set(oidb_cmd0xcf8_configinfo2.url.get());
                        mobileqq_mp_configinfo2.auth_type.set(oidb_cmd0xcf8_configinfo2.auth_type.get());
                        mobileqq_mp_configinfo2.state.set(oidb_cmd0xcf8_configinfo2.state.get());
                        mobileqq_mp_configinfo2.confirm_flag.set(oidb_cmd0xcf8_configinfo2.confirm_flag.get());
                        mobileqq_mp_configinfo2.confirm_tips.set(oidb_cmd0xcf8_configinfo2.confirm_tips.get());
                        mobileqq_mp_configinfo2.state_id.set(oidb_cmd0xcf8_configinfo2.state_id.get());
                        arrayList4.add(mobileqq_mp_configinfo2);
                    }
                    mobileqq_mp$ConfigGroupInfo mobileqq_mp_configgroupinfo2 = new mobileqq_mp$ConfigGroupInfo();
                    mobileqq_mp_configgroupinfo2.config_info.set(arrayList4);
                    arrayList3.add(mobileqq_mp_configgroupinfo2);
                }
                mobileqq_mp_getpublicaccountdetailinforesponse.config_group_info_new.set(arrayList3);
            }
            mobileqq_mp_getpublicaccountdetailinforesponse.certified_description.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.certified_description.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.unified_account_descrpition.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.unified_account_descrpition.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.account_flag2.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.account_flag2.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.account_uid.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.account_uid.get());
            return true;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.w("Contacts.PublicAccountFragment", 4, e16.getMessage(), e16);
            return false;
        } catch (Exception e17) {
            QLog.w("Contacts.PublicAccountFragment", 4, e17.getMessage(), e17);
            return false;
        }
    }

    private f fi(PublicAccountInfo publicAccountInfo) {
        f fVar = new f(publicAccountInfo);
        fVar.b(ChnToSpell.d(publicAccountInfo.name, 2));
        fVar.a(ChnToSpell.d(publicAccountInfo.name, 1));
        return fVar;
    }

    private void gi(f fVar, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("Contacts.PublicAccountFragment", 2, "getUidFromService");
        }
        NewIntent newIntent = this.Y;
        if (newIntent != null) {
            newIntent.setObserver(null);
        }
        NewIntent newIntent2 = new NewIntent(this.K.getApplicationContext(), ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountServlet.class));
        this.Y = newIntent2;
        newIntent2.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_GET_DETAIL_INFO);
        mobileqq_mp$GetPublicAccountDetailInfoRequest mobileqq_mp_getpublicaccountdetailinforequest = new mobileqq_mp$GetPublicAccountDetailInfoRequest();
        mobileqq_mp_getpublicaccountdetailinforequest.seqno.set(0);
        mobileqq_mp_getpublicaccountdetailinforequest.version.set(1);
        mobileqq_mp_getpublicaccountdetailinforequest.versionInfo.set(AppSetting.f99551k + ",3," + AppSetting.f99542b);
        try {
            mobileqq_mp_getpublicaccountdetailinforequest.uin.set((int) Long.parseLong(str));
        } catch (Exception unused) {
        }
        this.Y.putExtra("data", mobileqq_mp_getpublicaccountdetailinforequest.toByteArray());
        this.Y.setObserver(new AnonymousClass7(fVar));
        QQAppInterface qQAppInterface = this.E;
        if (qQAppInterface == null) {
            QLog.d("Contacts.PublicAccountFragment", 1, "getUidFromService mApp == null");
        } else {
            qQAppInterface.startServlet(this.Y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii(PublicAccountInfo publicAccountInfo, String str, String str2) {
        int i3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (getActivity() == null || getActivity().isDestroyed()) {
                QLog.w("Contacts.PublicAccountFragment", 1, "jumpPage - getActivity = null or isDestroyed");
            }
            Intent intent = new Intent(this.K, (Class<?>) ChatActivity.class);
            IQQNewsCommApi iQQNewsCommApi = (IQQNewsCommApi) QRoute.api(IQQNewsCommApi.class);
            if (iQQNewsCommApi.isQQNewsPa(str) && iQQNewsCommApi.startQQNewsPA(this.K)) {
                return;
            }
            IWeatherCommApi iWeatherCommApi = (IWeatherCommApi) QRoute.api(IWeatherCommApi.class);
            if (iWeatherCommApi.isWeatherPA(str) && iWeatherCommApi.startNewWeatherWebPageActivity(this.K, this.E)) {
                return;
            }
            if (((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isNeedRedirectAIOToMainPage(str)) {
                boolean redirectAIOToMainPage = ((IQQHealthService) this.E.getRuntimeService(IQQHealthService.class)).redirectAIOToMainPage(this.K, 165);
                QLog.i("Contacts.PublicAccountFragment", 1, "health contact redirect aio to mainPage is" + redirectAIOToMainPage);
                if (redirectAIOToMainPage) {
                    return;
                }
            }
            if (((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType2(publicAccountInfo.accountFlag2) == -10) {
                com.tencent.biz.subscribe.d.u(this.K, str);
                return;
            }
            if (publicAccountInfo.extendType == 2) {
                intent.putExtra("chat_subType", 1);
                i3 = 0;
            } else {
                i3 = 1008;
            }
            if (TextUtils.equals(str, AppConstants.WEISHI_UIN)) {
                ((IWSManager) QRoute.api(IWSManager.class)).enterWSPublicAccount(getActivity(), "from_user_contacts", false);
                return;
            }
            if (TextUtils.equals(str, AppConstants.TIM_TEAM_UIN)) {
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).enterTimTeam(getBaseActivity(), this.E);
                return;
            }
            if (TextUtils.equals(str, AppConstants.VALUE.UIN_QZONE) && ((IQzoneMsgApi) QRoute.api(IQzoneMsgApi.class)).open(getBaseActivity(), this.E)) {
                return;
            }
            if (TextUtils.equals(str, "2747277822") && ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig()) {
                ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).startQQGamePubAccount(getBaseActivity(), 1);
                this.E.getConversationFacade().r("2747277822", 1008, false);
                return;
            }
            if (TextUtils.equals(str, "3593944551") && ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isCustomGameMallPubAccount()) {
                ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).startGameMallPubAccount(getBaseActivity(), 1);
                this.E.getConversationFacade().r("3593944551", 1008, false);
                return;
            }
            IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
            if (iMiniAppService.shouldOpenWebFragment(str)) {
                iMiniAppService.launchMiniGamePublicAccount(getBaseActivity());
                this.E.getConversationFacade().r(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, 1008, false);
                return;
            }
            String str3 = AppConstants.QQ_VIP_UIN;
            if (TextUtils.equals(str, str3)) {
                s23.a.j(getBaseActivity(), "friendlist");
                this.E.getConversationFacade().r(str3, 1008, false);
                return;
            }
            String str4 = AppConstants.QQ_YELLOW_VIP_UIN;
            if (TextUtils.equals(str, str4)) {
                y33.b.f449310a.d(getBaseActivity(), "friendlist");
                this.E.getConversationFacade().r(str4, 1008, false);
                return;
            }
            if (((IVasReadPublicAccount) QRoute.api(IVasReadPublicAccount.class)).isVipRead(str)) {
                ((IVasReadPublicAccount) QRoute.api(IVasReadPublicAccount.class)).startVipReadFragment(getBaseActivity());
                this.E.getConversationFacade().r(AppConstants.QQ_VIP_READ_UIN, 1008, false);
                return;
            }
            String str5 = qb2.a.f428781a;
            if (TextUtils.equals(str, str5) && qb2.b.e(getBaseActivity(), str, 4)) {
                this.E.getConversationFacade().r(str5, 1008, false);
                return;
            }
            if (TextUtils.equals(IPublicAccountUtil.UIN_FOR_SHOP, str)) {
                ((IEcshopUtilApi) QRoute.api(IEcshopUtilApi.class)).jump(getBaseActivity());
                this.E.getConversationFacade().r(IPublicAccountUtil.UIN_FOR_SHOP, 1008, false);
                return;
            }
            if (((IQQComicConfigApi) QRoute.api(IQQComicConfigApi.class)).launchIfMatched(str, getBaseActivity(), 1035, this.E)) {
                return;
            }
            if (AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(str)) {
                ((IQCirclePublicAccountLauncher) QRoute.api(IQCirclePublicAccountLauncher.class)).launchQCircleFromPublicAccount(this.E, requireContext(), QCirclePublicAccountLauncherSource.CONTACT);
                return;
            }
            if (AppConstants.Q_ECOMMERCE_MSG_PUBLIC_ACCOUNT_UIN.equals(str)) {
                ((IEcommerceMsgCenter) QRoute.api(IEcommerceMsgCenter.class)).launchMainPage(this.E, requireContext(), EcommerceMsgCenterSource.CONTACT);
                return;
            }
            if (AppConstants.VALUE.UIN_GUILD_OFFICIAL_ACCOUNT.equals(str)) {
                ((IGuildDiscoverApi) QRoute.api(IGuildDiscoverApi.class)).openDiscoverFromPublicAccount(requireContext(), new GuildPublicAccountParams(3));
                return;
            }
            if (AppConstants.TVIDEO_PUBLIC_ACCOUNT_UIN.equals(str)) {
                ((ITVideoPublicAccountLauncherApi) QRoute.api(ITVideoPublicAccountLauncherApi.class)).launchTVideoPublicAccountPage(this.E, getActivity(), "");
                return;
            }
            if (AppConstants.ZPLAN_MOD_SMALLHOME_PUBLIC_ACCOUNT_UIN.equals(str)) {
                ((IZPlanPublicAccountLauncherApi) QRoute.api(IZPlanPublicAccountLauncherApi.class)).launchSmallHomeMainPageFromPublicAccount(this.E, requireContext(), "Contacts.PublicAccountFragment");
                return;
            }
            intent.putExtra("uin", str);
            intent.putExtra("key_peerId", str2);
            intent.putExtra("key_from", "7");
            intent.putExtra("uintype", i3);
            intent.putExtra("uinname", publicAccountInfo.name);
            intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, getString(R.string.f171208d54));
            intent.putExtra("jump_from", 3);
            ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).reportPublicAccountADDuration(str2);
            startActivity(intent);
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.E, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "mp_msg_sys_4", "contacts_aio", 0, 0, str, "", "", "", false);
            ReportController.n(this.E, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800573B", "0X800573B", 0, 1, 0, str, "", "", "");
            return;
        }
        QLog.w("Contacts.PublicAccountFragment", 1, "jumpPage - uin or uid = null");
    }

    private void ki() {
        ViewStub viewStub;
        if (this.S == null) {
            View view = this.P;
            if (view == null || (viewStub = (ViewStub) view.findViewById(R.id.bww)) == null) {
                return;
            }
            View inflate = viewStub.inflate();
            this.S = inflate;
            if (inflate != null) {
                inflate.findViewById(R.id.ik7).setOnClickListener(new c());
            }
        }
        this.S.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected void Ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = this.E;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f181661b0);
            IPublicAccountObserver iPublicAccountObserver = this.f181662c0;
            if (iPublicAccountObserver != null) {
                this.E.removeObserver(iPublicAccountObserver.getBusinessObserver());
            }
            this.E.removeHandler(getClass());
            MqqHandler mqqHandler = this.V;
            if (mqqHandler != null) {
                mqqHandler.removeCallbacksAndMessages(null);
            }
            List<f> list = this.W;
            if (list != null) {
                list.clear();
            }
            g gVar = this.T;
            if (gVar != null) {
                gVar.g();
                this.T.destroy();
                this.T.notifyDataSetChanged();
                this.T = null;
            }
            this.U = null;
        }
        NewIntent newIntent = this.Y;
        if (newIntent != null) {
            newIntent.setObserver(null);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Ah();
        g gVar = this.T;
        if (gVar != null) {
            gVar.destroy();
        }
        this.T = null;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment, com.tencent.mobileqq.activity.contacts.base.h.a
    public View getScrollableView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.Q;
    }

    protected void hi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PublicAccountFragment.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IPublicAccountDataManager iPublicAccountDataManager = PublicAccountFragment.this.U;
                    if (iPublicAccountDataManager != null) {
                        iPublicAccountDataManager.initPublicAccountDataManager();
                    }
                }
            }, 5, new ThreadExcutor.IThreadListener() { // from class: com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PublicAccountFragment.this);
                    }
                }

                @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
                public void onAdded() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }

                @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
                public void onPostRun() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this);
                    } else {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.6.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    PublicAccountFragment.this.ji();
                                }
                            }
                        });
                    }
                }

                @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
                public void onPreRun() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this);
                    }
                }
            }, true);
        }
    }

    protected void ji() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.T == null) {
            return;
        }
        if (this.W == null) {
            this.W = new ArrayList();
        }
        if (this.U == null) {
            this.U = (IPublicAccountDataManager) this.E.getRuntimeService(IPublicAccountDataManager.class, "all");
        }
        this.W.clear();
        this.T.g();
        this.T.notifyDataSetChanged();
        ArrayList<Entity> publicAccountListNotIVR = this.U.getPublicAccountListNotIVR();
        if (publicAccountListNotIVR != null && publicAccountListNotIVR.size() > 0) {
            View view = this.S;
            if (view != null) {
                view.setVisibility(8);
            }
            this.Q.setVisibility(0);
            Iterator<Entity> it = publicAccountListNotIVR.iterator();
            while (it.hasNext()) {
                QidianManager qidianManager = (QidianManager) this.E.getManager(QQManagerFactory.QIDIAN_MANAGER);
                PublicAccountInfo publicAccountInfo = (PublicAccountInfo) it.next();
                if (!AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(publicAccountInfo.getUin()) && !AppConstants.KANDIAN_DAILY_UIN.equals(publicAccountInfo.getUin()) && (qidianManager == null || !qidianManager.R(publicAccountInfo.getUin()))) {
                    this.W.add(fi(publicAccountInfo));
                }
            }
            this.T.h();
            this.T.notifyDataSetChanged();
            return;
        }
        ki();
        this.Q.setVisibility(4);
        this.R.setVisibility(4);
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        if ("$".equals(str)) {
            this.Q.setSelection(0);
            return;
        }
        int i3 = this.T.i(str);
        if (i3 != -1) {
            PinnedDividerListView pinnedDividerListView = this.Q;
            pinnedDividerListView.setSelection(i3 + pinnedDividerListView.getHeaderViewsCount());
        }
    }

    @Override // com.tencent.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof h) {
            fVar = ((h) tag).f181680i;
        } else {
            fVar = null;
        }
        if (fVar == null) {
            if (QLog.isColorLevel()) {
                QLog.w("Contacts.PublicAccountFragment", 2, "onItemClick - info = null[position = " + i3 + "]");
                return;
            }
            return;
        }
        PublicAccountInfo publicAccountInfo = fVar.f181676a;
        String uin = publicAccountInfo.getUin();
        String str = publicAccountInfo.uid;
        if (TextUtils.isEmpty(uin)) {
            if (QLog.isColorLevel()) {
                QLog.w("Contacts.PublicAccountFragment", 2, "onItemClick - uin = null");
            }
        } else if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.w("Contacts.PublicAccountFragment", 2, "onItemClick - uid = null");
            }
            gi(fVar, uin);
        } else {
            if (((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).isValidUin(uin)) {
                ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(uin, str);
            }
            ii(publicAccountInfo, uin, str);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected void ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = this.E;
        if (qQAppInterface != null && this.H) {
            qQAppInterface.addObserver(this.f181661b0);
            this.E.addObserver(this.f181662c0.getBusinessObserver());
            if (this.V == null) {
                this.V = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.Z);
                this.E.setHandler(getClass(), this.V);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void qh(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else if (z16) {
            Ah();
            this.Q.setVisibility(4);
            this.R.setVisibility(4);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void refresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Contacts.PublicAccountFragment", 2, "refresh");
        }
        IPublicAccountHandler iPublicAccountHandler = (IPublicAccountHandler) this.E.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
        if (iPublicAccountHandler != null) {
            iPublicAccountHandler.clearPublicAccountSeq();
            iPublicAccountHandler.getUserFollowList();
        }
        EnterpriseQQHandler enterpriseQQHandler = (EnterpriseQQHandler) this.E.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
        if (enterpriseQQHandler != null) {
            enterpriseQQHandler.D2(SystemClock.uptimeMillis());
        }
        this.N = true;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void resetData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.H) {
            g gVar = this.T;
            if (gVar != null) {
                gVar.g();
                this.T.destroy();
            }
            if (this.P != null) {
                g gVar2 = new g(this);
                this.T = gVar2;
                this.Q.setAdapter((ListAdapter) gVar2);
                ji();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void rh(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Contacts.PublicAccountFragment", 2, "doOnResume:" + z16);
        }
        if (this.f181662c0 == null) {
            IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
            this.f181662c0 = iPublicAccountObserver;
            iPublicAccountObserver.setOnCallback(new b());
        }
        View view = this.P;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        if (z16) {
            ph();
        }
        if (this.T == null) {
            g gVar = new g(this);
            this.T = gVar;
            this.Q.setAdapter((ListAdapter) gVar);
        }
        if (this.U == null) {
            this.U = (IPublicAccountDataManager) this.E.getRuntimeService(IPublicAccountDataManager.class, "all");
        }
        IPublicAccountDataManager iPublicAccountDataManager = this.U;
        if (iPublicAccountDataManager != null) {
            if (iPublicAccountDataManager.isCached()) {
                this.P.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PublicAccountFragment.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            PublicAccountFragment.this.ji();
                        }
                    }
                }, 200L);
            } else {
                hi();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected View uh(LayoutInflater layoutInflater, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) layoutInflater, (Object) bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Contacts.PublicAccountFragment", 2, "getView");
        }
        View view = this.P;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.f167793ho, (ViewGroup) null, false);
            this.P = inflate;
            PinnedDividerListView pinnedDividerListView = (PinnedDividerListView) inflate.findViewById(R.id.g49);
            this.Q = pinnedDividerListView;
            pinnedDividerListView.mForContacts = true;
            pinnedDividerListView.setOnItemClickListener(this);
            IndexView indexView = (IndexView) this.P.findViewById(R.id.djh);
            this.R = indexView;
            indexView.setIndex(new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"});
            this.R.setOnIndexChangedListener(this);
            this.R.setVisibility(8);
        } else {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.P);
            }
        }
        return this.P;
    }
}
