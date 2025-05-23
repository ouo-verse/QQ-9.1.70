package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationExtendFriendPhotoWall;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationExtendFriendPhotoWall;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes35.dex */
public class PhotoWallListView extends FrameLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private QBaseActivity f264172d;

    /* renamed from: e, reason: collision with root package name */
    private Context f264173e;

    /* renamed from: f, reason: collision with root package name */
    private List<RoundCornerImageView> f264174f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<a> f264175h;

    /* renamed from: i, reason: collision with root package name */
    private long f264176i;

    /* renamed from: m, reason: collision with root package name */
    private long f264177m;

    /* loaded from: classes35.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f264178a;

        /* renamed from: b, reason: collision with root package name */
        public String f264179b;

        public a(String str, String str2) {
            this.f264178a = str;
            this.f264179b = str2;
        }

        public static ArrayList<String> b(ArrayList<a> arrayList) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                arrayList2.add(arrayList.get(i3).a());
                if (arrayList2.size() >= 4) {
                    break;
                }
            }
            return arrayList2;
        }

        public String a() {
            if (!TextUtils.isEmpty(this.f264179b)) {
                return this.f264179b;
            }
            return this.f264178a;
        }

        public boolean c() {
            return TextUtils.isEmpty(this.f264178a) && !TextUtils.isEmpty(this.f264179b);
        }
    }

    public PhotoWallListView(Context context) {
        super(context);
        this.f264174f = new ArrayList();
        this.f264176i = 0L;
        this.f264177m = 3000L;
        this.f264173e = context;
        f();
    }

    private URL c(String str) {
        try {
            if (!TextUtils.isEmpty(str) && (str.startsWith("http") || str.startsWith("https"))) {
                return new URL(str);
            }
            return new File(str).toURL();
        } catch (MalformedURLException e16) {
            QLog.e("PhotoWallListView", 1, e16, new Object[0]);
            return null;
        }
    }

    private Drawable d(String str) {
        URL c16 = c(str);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = this.f264174f.get(0).getWidth();
        obtain.mRequestHeight = this.f264174f.get(0).getHeight();
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        return URLDrawable.getDrawable(c16, obtain);
    }

    private boolean e() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f264176i >= this.f264177m) {
            this.f264176i = currentTimeMillis;
            return false;
        }
        this.f264177m = 1000L;
        return true;
    }

    private void f() {
        RoundCornerImageView roundCornerImageView = new RoundCornerImageView(this.f264173e);
        roundCornerImageView.setId(80400);
        roundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        roundCornerImageView.setCorner(8, 8, 8, 8);
        roundCornerImageView.setImageDrawable(this.f264173e.getResources().getDrawable(R.drawable.gej));
        this.f264174f.add(roundCornerImageView);
        RoundCornerImageView roundCornerImageView2 = new RoundCornerImageView(this.f264173e);
        roundCornerImageView2.setId(80401);
        roundCornerImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        roundCornerImageView2.setCorner(8, 8, 8, 8);
        this.f264174f.add(roundCornerImageView2);
        RoundCornerImageView roundCornerImageView3 = new RoundCornerImageView(this.f264173e);
        roundCornerImageView3.setId(80402);
        roundCornerImageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
        roundCornerImageView3.setCorner(8, 8, 8, 8);
        this.f264174f.add(roundCornerImageView3);
        RoundCornerImageView roundCornerImageView4 = new RoundCornerImageView(this.f264173e);
        roundCornerImageView4.setId(80403);
        roundCornerImageView4.setScaleType(ImageView.ScaleType.CENTER_CROP);
        roundCornerImageView4.setCorner(8, 8, 8, 8);
        this.f264174f.add(roundCornerImageView4);
        for (int i3 = 0; i3 < 4; i3++) {
            addView(this.f264174f.get(i3));
            this.f264174f.get(i3).setOnClickListener(this);
        }
    }

    private void g(int i3) {
        Intent intent = new Intent(this.f264172d, (Class<?>) TroopAvatarWallPreviewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("index", i3);
        bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, a.b(this.f264175h));
        bundle.putBoolean(IProfileCardConst.KEY_DELETE_ABILITY, true);
        bundle.putBoolean("SHOW_MENU", true);
        bundle.putBoolean("is_show_action", false);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(TroopAvatarWallPreviewActivity.KEY_FROM_EXTEND_FRIEND_EDIT, true);
        bundle.putBundle(TroopAvatarWallPreviewActivity.KEY_BUNDLE_DATA_EXTRA, bundle2);
        int[] iArr = new int[2];
        RoundCornerImageView roundCornerImageView = this.f264174f.get(i3);
        roundCornerImageView.getLocationOnScreen(iArr);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(iArr[0]));
        arrayList.add(Integer.valueOf(iArr[1]));
        arrayList.add(Integer.valueOf(roundCornerImageView.getWidth()));
        arrayList.add(Integer.valueOf(roundCornerImageView.getHeight()));
        bundle.putIntegerArrayList("mPreviewPhotoLocation", arrayList);
        intent.putExtras(bundle);
        this.f264172d.startActivityForResult(intent, 5001);
    }

    private void h(int i3) {
        if (e()) {
            return;
        }
        Intent intent = new Intent(this.f264172d, (Class<?>) NewPhotoListActivity.class);
        intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 54);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationExtendFriendPhotoWall.G);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationExtendFriendPhotoWall.G);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
        intent.putExtra(PeakConstants.IS_SINGLE_NEED_EDIT, false);
        intent.putExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 4 - i3);
        intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, false);
        intent.putExtra(PeakConstants.REQUEST_CODE, 10020);
        this.f264172d.startActivityForResult(intent, 10020);
    }

    public void i(ArrayList<String> arrayList) {
        this.f264175h.clear();
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (!TextUtils.isEmpty(arrayList.get(i3))) {
                    this.f264175h.add(new a(arrayList.get(i3), null));
                }
                if (this.f264175h.size() == 4) {
                    return;
                }
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int abs = Math.abs(i17 - i3);
        int dimension = (int) this.f264173e.getResources().getDimension(R.dimen.f10692r);
        int dimension2 = (int) this.f264173e.getResources().getDimension(R.dimen.f10712t);
        int i19 = ((abs - (dimension * 2)) - (dimension2 * 3)) / 4;
        int i26 = (dimension - i19) - dimension2;
        int i27 = dimension - dimension2;
        for (int i28 = 0; i28 < 4; i28++) {
            int i29 = i19 + dimension2;
            i26 += i29;
            i27 += i29;
            this.f264174f.get(i28).layout(i26, 0, i27, i19);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int size = View.MeasureSpec.getSize(i3);
        setMeasuredDimension(size, ((size - (((int) this.f264173e.getResources().getDimension(R.dimen.f10692r)) * 2)) - (((int) this.f264173e.getResources().getDimension(R.dimen.f10712t)) * 3)) / 4);
    }

    public void setActivity(QBaseActivity qBaseActivity) {
        this.f264172d = qBaseActivity;
    }

    public void setPhotoPathList(ArrayList<a> arrayList) {
        this.f264175h = arrayList;
    }

    public void a(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (!TextUtils.isEmpty(arrayList.get(i3))) {
                this.f264175h.add(new a(null, arrayList.get(i3)));
            }
            if (this.f264175h.size() == 4) {
                return;
            }
        }
    }

    public void b(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            for (int i16 = 0; i16 < this.f264175h.size(); i16++) {
                if (arrayList.get(i3).equals(this.f264175h.get(i16).f264179b) || arrayList.get(i3).equals(this.f264175h.get(i16).f264178a)) {
                    this.f264175h.remove(i16);
                    break;
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i3 = 0; i3 < 4; i3++) {
            if (view.getId() == this.f264174f.get(i3).getId()) {
                if (i3 < this.f264175h.size()) {
                    g(i3);
                } else if (i3 == this.f264175h.size()) {
                    ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#add_photo_btn", true, -1L, -1L, null, true, true);
                    h(i3);
                }
            }
        }
    }

    public void j() {
        for (int i3 = 0; i3 < 4; i3++) {
            if (i3 < this.f264175h.size() && !TextUtils.isEmpty(this.f264175h.get(i3).a())) {
                this.f264174f.get(i3).setImageDrawable(d(this.f264175h.get(i3).a()));
                this.f264174f.get(i3).setVisibility(0);
            } else if (i3 == this.f264175h.size()) {
                this.f264174f.get(i3).setImageDrawable(this.f264173e.getResources().getDrawable(R.drawable.gej));
                this.f264174f.get(i3).setVisibility(0);
            } else {
                this.f264174f.get(i3).setImageDrawable(this.f264173e.getResources().getDrawable(R.color.ajr));
                this.f264174f.get(i3).setVisibility(4);
            }
        }
    }

    public PhotoWallListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f264174f = new ArrayList();
        this.f264176i = 0L;
        this.f264177m = 3000L;
        this.f264173e = context;
        f();
    }

    public PhotoWallListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f264174f = new ArrayList();
        this.f264176i = 0L;
        this.f264177m = 3000L;
        this.f264173e = context;
        f();
    }
}
