package com.tencent.aelight.camera.ae.album.logic;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.album.adapter.AEAlbumListAdapter;
import com.tencent.aelight.camera.ae.util.i;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qzonehub.api.IQzoneReq;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends AEAlbumListLogicBase<com.tencent.aelight.camera.ae.album.fragment.a> {

    /* renamed from: g, reason: collision with root package name */
    protected com.tencent.mobileqq.activity.photo.album.a f62119g;

    /* renamed from: h, reason: collision with root package name */
    protected final boolean f62120h;

    protected b(com.tencent.aelight.camera.ae.album.fragment.a aVar) {
        super(aVar);
        this.f62120h = i.a();
        this.f62118d = this;
        com.tencent.mobileqq.activity.photo.album.a aVar2 = new com.tencent.mobileqq.activity.photo.album.a();
        this.f62117c = aVar2;
        this.f62119g = aVar2;
    }

    public static a n(com.tencent.aelight.camera.ae.album.fragment.a aVar) {
        if (a.f62114e == null || a.f62114e.f62115a.get() != aVar) {
            synchronized (b.class) {
                if (a.f62114e == null || a.f62114e.f62115a.get() != aVar) {
                    a.f62114e = new b(aVar);
                }
            }
        }
        return a.f62114e;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicBase, com.tencent.aelight.camera.ae.album.logic.a.InterfaceC0532a
    public String a() {
        return super.a();
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicBase, com.tencent.aelight.camera.ae.album.logic.a.InterfaceC0532a
    public void b(int i3) {
        super.b(i3);
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicBase, com.tencent.aelight.camera.ae.album.logic.a.InterfaceC0532a
    public List<QQAlbumInfo> c(List<QQAlbumInfo> list, List<QQAlbumInfo> list2, int i3) {
        List<QQAlbumInfo> c16 = super.c(list, list2, i3);
        if (c16 != null && !c16.isEmpty() && i3 == -1 && k().L && k().M > 0) {
            QQAlbumInfo qQAlbumInfo = new QQAlbumInfo();
            qQAlbumInfo.f203112id = "qzone_album";
            qQAlbumInfo.name = "\u7a7a\u95f4\u76f8\u518c";
            qQAlbumInfo.mMediaFileCount = (int) k().M;
            c16.add(0, qQAlbumInfo);
        }
        return c16;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicBase, com.tencent.aelight.camera.ae.album.logic.a.InterfaceC0532a
    public List<LocalMediaInfo> d(Context context, int i3, int i16, MediaFileFilter mediaFileFilter, int i17, boolean z16, ArrayList<String> arrayList) {
        return super.d(context, i3, i16, mediaFileFilter, i17, z16, arrayList);
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicBase, com.tencent.aelight.camera.ae.album.logic.a
    public void f(Intent intent) {
        super.f(intent);
        this.f62119g.f184204a = intent.getBooleanExtra(PeakConstants.IS_FINISH_RESTART_INIT_ACTIVITY, false);
        this.f62116b.isShowQzoneAlbum = intent.getBooleanExtra(PeakConstants.IS_SHOW_QZONE_ALBUM, false);
        if (this.f62116b.isShowQzoneAlbum) {
            ((IQzoneReq) QRoute.api(IQzoneReq.class)).sentGetAlbumListNumServlet(this.f62119g.f184205b, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
        }
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicBase, com.tencent.aelight.camera.ae.album.logic.a.InterfaceC0532a
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i3, view, viewGroup);
        com.tencent.aelight.camera.ae.album.adapter.a k3 = k();
        TextView textView = (TextView) view2;
        if (k3.getItem(i3).f203112id.equals("qzone_album")) {
            Drawable drawable = k3.f62005e.getDrawable(R.drawable.owa);
            drawable.setBounds(0, 0, k3.f62006f, k3.f62007h);
            textView.setCompoundDrawables(drawable, null, null, null);
        }
        view2.setBackgroundResource(R.color.f9048l);
        textView.setTextColor(k3.f62005e.getColor(R.color.black));
        return view2;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicBase
    protected AEAlbumListAdapter j() {
        return new com.tencent.aelight.camera.ae.album.adapter.a((com.tencent.aelight.camera.ae.album.fragment.a) this.f62115a.get());
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicBase
    boolean l(boolean z16, QQAlbumInfo qQAlbumInfo) {
        return !qQAlbumInfo.f203112id.equals("qzone_album") && z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicBase
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public com.tencent.aelight.camera.ae.album.adapter.a k() {
        return (com.tencent.aelight.camera.ae.album.adapter.a) super.k();
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicBase, com.tencent.aelight.camera.ae.album.logic.a
    public boolean g(QQAlbumInfo qQAlbumInfo, int i3, Intent intent) {
        if (qQAlbumInfo.f203112id.equals("qzone_album")) {
            Bundle extras = intent.getExtras();
            extras.putInt("key_personal_album_enter_model", 1);
            extras.putInt(QAlbumConstants.CURRENT_QUALITY_TYPE, intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0));
            extras.putSerializable(PeakConstants.PHOTO_INFOS, intent.getSerializableExtra(PeakConstants.PHOTO_INFOS));
            extras.putBoolean(PeakConstants.IS_SHOW_QZONE_ALBUM, true);
            extras.putStringArrayList("PhotoConst.PHOTO_PATHS", intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            extras.putString("keyAction", "actionSelectPicture");
            extras.putBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_NEED_CHANGE_TO_JPG, true);
            QZoneHelper.forwardToPersonalAlbumSelect(((com.tencent.aelight.camera.ae.album.fragment.a) this.f62115a.get()).getActivity(), userInfo, extras, 10016);
            return i(intent, qQAlbumInfo);
        }
        intent.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0));
        if (QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID.equals(qQAlbumInfo.f203112id)) {
            ReportController.o(null, "CliOper", "", "", "0X8006131", "0X8006131", 0, 0, "", "", "", "");
        }
        return super.g(qQAlbumInfo, i3, intent);
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.a
    public void h() {
    }
}
