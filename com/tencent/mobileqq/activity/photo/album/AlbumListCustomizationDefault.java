package com.tencent.mobileqq.activity.photo.album;

import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qzonehub.api.IQzoneReq;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import java.io.Serializable;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AlbumListCustomizationDefault extends AlbumListCustomizationBase<h> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    protected com.tencent.mobileqq.activity.photo.album.a f184170h;

    /* renamed from: i, reason: collision with root package name */
    protected AlbumListFragment f184171i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AlbumListCustomizationDefault.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends l {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AlbumListCustomizationDefault.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.photo.album.l
        protected void a(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            Serializable serializable = bundle.getSerializable("data");
            if (z16 && (serializable instanceof get_albumlist_num_rsp)) {
                ((h) ((com.tencent.mobileqq.activity.photo.album.albumlist.b) AlbumListCustomizationDefault.this).f184223c).f184246d = ((get_albumlist_num_rsp) serializable).album_num;
                NewAlbumListAdapter l3 = AlbumListCustomizationDefault.this.l();
                if (l3 != null) {
                    l3.r(((h) ((com.tencent.mobileqq.activity.photo.album.albumlist.b) AlbumListCustomizationDefault.this).f184223c).f184246d);
                    l3.g();
                }
            }
            ((h) ((com.tencent.mobileqq.activity.photo.album.albumlist.b) AlbumListCustomizationDefault.this).f184223c).f184247e = true;
            MobileQQ.sMobileQQ.peekAppRuntime().unRegistObserver(AlbumListCustomizationDefault.this.f184170h.f184205b);
        }
    }

    public AlbumListCustomizationDefault(AbstractAlbumListFragment abstractAlbumListFragment) {
        super(abstractAlbumListFragment);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractAlbumListFragment);
            return;
        }
        this.f184171i = (AlbumListFragment) abstractAlbumListFragment;
        this.f184225e = this;
        com.tencent.mobileqq.activity.photo.album.a aVar = new com.tencent.mobileqq.activity.photo.album.a();
        this.f184224d = aVar;
        this.f184170h = aVar;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase, com.tencent.mobileqq.activity.photo.album.albumlist.b.InterfaceC7191b
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return super.a();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase, com.tencent.mobileqq.activity.photo.album.albumlist.b
    public void f(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        if (this.f184222b.isShowQzoneAlbum) {
            this.f184170h.f184206c = this.f184219f.getResources().getDrawable(R.drawable.common_arrow_right_selector).getConstantState();
        }
        super.f(intent);
        this.f184170h.f184204a = intent.getBooleanExtra(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, false);
        this.f184222b.isShowQzoneAlbum = intent.getBooleanExtra(PeakConstants.IS_SHOW_QZONE_ALBUM, false);
        l().r(((h) this.f184223c).f184246d);
        if (this.f184222b.isShowQzoneAlbum && !((h) this.f184223c).f184247e) {
            this.f184170h.f184205b = new b();
            ((IQzoneReq) QRoute.api(IQzoneReq.class)).sentGetAlbumListNumServlet(this.f184170h.f184205b, MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin());
            this.f184170h.f184206c = this.f184219f.getResources().getDrawable(R.drawable.common_arrow_right_selector).getConstantState();
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase, com.tencent.mobileqq.activity.photo.album.albumlist.b
    public boolean g(QQAlbumInfo qQAlbumInfo, int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, qQAlbumInfo, Integer.valueOf(i3), intent)).booleanValue();
        }
        if (qQAlbumInfo.f203112id.equals("qzone_album")) {
            Bundle extras = intent.getExtras();
            extras.putInt("key_personal_album_enter_model", 1);
            extras.putInt(QAlbumConstants.CURRENT_QUALITY_TYPE, intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0));
            extras.putSerializable(PeakConstants.PHOTO_INFOS, intent.getSerializableExtra(PeakConstants.PHOTO_INFOS));
            extras.putBoolean(PeakConstants.IS_SHOW_QZONE_ALBUM, true);
            extras.putStringArrayList("PhotoConst.PHOTO_PATHS", intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            extras.putString("keyAction", "actionSelectPicture");
            extras.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_NEED_CHANGE_TO_JPG, true);
            QZoneHelper.forwardToPersonalAlbumSelect(this.f184219f, userInfo, extras, 10016);
            return i(intent, qQAlbumInfo);
        }
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0));
        if (QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID.equals(qQAlbumInfo.f203112id)) {
            ReportController.o(null, "CliOper", "", "", "0X8006131", "0X8006131", 0, 0, "", "", "", "");
        }
        return super.g(qQAlbumInfo, i3, intent);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase, com.tencent.mobileqq.activity.photo.album.albumlist.b.InterfaceC7191b
    public View getView(int i3, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
        }
        View view2 = super.getView(i3, view, viewGroup);
        NewAlbumListAdapter l3 = l();
        TextView textView = (TextView) view2;
        if (l3.getItem(i3).f203112id.equals("qzone_album")) {
            Drawable drawable = this.f184219f.getResources().getDrawable(R.drawable.owa);
            drawable.setBounds(0, 0, l3.f184215f, l3.f184216h);
            com.tencent.mobileqq.activity.photo.album.a aVar = this.f184170h;
            if (aVar.f184206c == null) {
                aVar.f184206c = this.f184219f.getResources().getDrawable(R.drawable.common_arrow_right_selector).getConstantState();
            }
            Drawable newDrawable = this.f184170h.f184206c.newDrawable(this.f184219f.getResources());
            newDrawable.setBounds(0, 0, newDrawable.getIntrinsicWidth(), newDrawable.getIntrinsicHeight());
            textView.setCompoundDrawables(drawable, null, newDrawable, null);
        }
        if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null)) {
            view2.setBackgroundColor(-16777216);
            textView.setTextColor(-9211021);
        }
        return view2;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase
    protected AlbumListAdapter j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AlbumListAdapter) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new NewAlbumListAdapter(this.f184171i);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase
    public boolean o(boolean z16, QQAlbumInfo qQAlbumInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), qQAlbumInfo)).booleanValue();
        }
        if (!qQAlbumInfo.f203112id.equals("qzone_album") && z16) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public NewAlbumListAdapter l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (NewAlbumListAdapter) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return (NewAlbumListAdapter) super.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.b
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public h e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a();
    }
}
