package com.tencent.mobileqq.mini.out.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.tencent.common.galleryactivity.URLImageView2;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.c;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.BubblePopupWindow;
import java.net.URL;
import java.util.ArrayList;

/* loaded from: classes33.dex */
public class PhotoPreviewActivity extends BaseActivity {
    public static final String BACK_BTN_TEXT = "back_btn_text";
    public static final String TAG = "PhotoPreviewActivity";
    ImageAdapter adapter;
    TextView backBtn;
    String backBtnText;
    int currentSelectedPostion;
    ProGallery gallery;
    ArrayList<String> paths;
    BubblePopupWindow popup;
    int reqHeight;
    int reqWidth;
    TextView titleView;
    View topBar;
    boolean showBar = true;
    int mTotalPicCount = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class ImageAdapter extends BaseAdapter implements c {
        URLDrawable mRawDrawable;
        SparseArray<URLDrawable> mActiveDrawable = new SparseArray<>();
        int mRawDrawablePosition = -1;

        ImageAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<String> arrayList = PhotoPreviewActivity.this.paths;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        String listActiviteDrawables() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("(preview) Actives: ");
            for (int i3 = 0; i3 < this.mActiveDrawable.size(); i3++) {
                if (i3 > 0) {
                    sb5.append(" , ");
                }
                sb5.append(this.mActiveDrawable.keyAt(i3) + 1);
            }
            return sb5.toString();
        }

        @Override // com.tencent.mobileqq.activity.photo.c
        public View onCreateView(int i3, View view, ViewGroup viewGroup) {
            URLDrawable uRLDrawable = this.mActiveDrawable.get(i3);
            if (uRLDrawable != null) {
                if (uRLDrawable.getStatus() == 3) {
                    uRLDrawable.restartDownload();
                }
            } else {
                String url = PhotoPreviewActivity.this.getURL(getItem(i3));
                if (QLog.isColorLevel()) {
                    QLog.d(PhotoPreviewActivity.TAG, 2, "onCreateView position=" + i3 + ", url=" + url);
                }
                if (TextUtils.isEmpty(url)) {
                    return null;
                }
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = viewGroup.getWidth();
                obtain.mRequestHeight = viewGroup.getHeight();
                obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
                drawable.setTag(1);
                drawable.startDownload();
                this.mActiveDrawable.put(i3, drawable);
            }
            if (QLog.isColorLevel()) {
                QLog.d(PhotoPreviewActivity.TAG, 2, listActiviteDrawables());
            }
            return null;
        }

        @Override // com.tencent.mobileqq.activity.photo.c
        public void onDestroyView(int i3, View view, ViewGroup viewGroup) {
            URLDrawable uRLDrawable = this.mActiveDrawable.get(i3);
            if (uRLDrawable != null) {
                if (uRLDrawable.getStatus() == 0) {
                    uRLDrawable.cancelDownload(true);
                }
                this.mActiveDrawable.remove(i3);
            }
            if (QLog.isColorLevel()) {
                QLog.d(PhotoPreviewActivity.TAG, 2, listActiviteDrawables());
            }
        }

        @Override // com.tencent.mobileqq.activity.photo.c
        public void onShowAreaChanged(int i3, View view, RegionDrawableData regionDrawableData) {
            if (ImageView.class.isInstance(view)) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if (URLDrawable.class.isInstance(drawable)) {
                    ((URLDrawable) drawable).updateRegionBitmap(regionDrawableData);
                }
            }
        }

        @Override // com.tencent.mobileqq.activity.photo.c
        public void onSlot(int i3, View view, ViewGroup viewGroup) {
            System.gc();
        }

        @Override // com.tencent.mobileqq.activity.photo.c
        public void onViewDetached(int i3, View view, ViewGroup viewGroup, boolean z16) {
            if (i3 == this.mRawDrawablePosition) {
                URLDrawable uRLDrawable = this.mRawDrawable;
                if (uRLDrawable != null && uRLDrawable.getStatus() == 0) {
                    this.mRawDrawable.cancelDownload(true);
                }
                this.mRawDrawable = null;
                this.mRawDrawablePosition = -1;
                if (QLog.isColorLevel()) {
                    QLog.d(PhotoPreviewActivity.TAG, 2, "(preview)destory rawDrawable, position: " + i3);
                }
            }
        }

        @Override // com.tencent.mobileqq.activity.photo.c
        public void onscaleBegin(int i3, View view, ViewGroup viewGroup) {
            if (!(view instanceof URLImageView2)) {
                if (QLog.isColorLevel()) {
                    QLog.d(PhotoPreviewActivity.TAG, 2, "onscaleBegin,classcast error,class of current view is " + view.getClass().toString());
                    return;
                }
                return;
            }
            URLImageView2 uRLImageView2 = (URLImageView2) view;
            Drawable drawable = uRLImageView2.getDrawable();
            URLDrawable uRLDrawable = uRLImageView2.f99854d;
            if (drawable instanceof URLDrawable) {
                URLDrawable uRLDrawable2 = (URLDrawable) drawable;
                if (uRLDrawable2.isFakeSize() && uRLDrawable == null) {
                    URL url = uRLDrawable2.getURL();
                    if ("file".equals(url.getProtocol()) && url.getRef() == null) {
                        if (i3 == this.mRawDrawablePosition && this.mRawDrawable != null) {
                            if (!QLog.isColorLevel() || this.mRawDrawable == null) {
                                return;
                            }
                            QLog.d(PhotoPreviewActivity.TAG, 2, "use exist raw drawable");
                            return;
                        }
                        if (QLog.isColorLevel() && this.mRawDrawable != null) {
                            QLog.d(PhotoPreviewActivity.TAG, 2, "rawDrawable is exist");
                        }
                        String str = url.toString() + "#NOSAMPLE";
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mUseExifOrientation = false;
                        obtain.mUseMemoryCache = false;
                        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
                        drawable2.setTag(2);
                        this.mRawDrawable = null;
                        this.mRawDrawablePosition = i3;
                        if (QLog.isColorLevel()) {
                            QLog.d(PhotoPreviewActivity.TAG, 2, "create rawDrawable, position:" + i3);
                        }
                        if (drawable2.getStatus() == 1) {
                            uRLImageView2.f99855e = true;
                            uRLImageView2.setImageDrawable(drawable2);
                            uRLImageView2.f99855e = false;
                        } else {
                            uRLImageView2.setDecodingDrawble(drawable2);
                            drawable2.startDownload();
                        }
                    }
                }
            }
        }

        @Override // android.widget.Adapter
        public String getItem(int i3) {
            ArrayList<String> arrayList = PhotoPreviewActivity.this.paths;
            if (arrayList == null || i3 >= arrayList.size() || i3 < 0) {
                return null;
            }
            return PhotoPreviewActivity.this.paths.get(i3);
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            if (view != null) {
                return view;
            }
            String url = PhotoPreviewActivity.this.getURL(getItem(i3));
            URLDrawable uRLDrawable = this.mActiveDrawable.get(i3);
            if (QLog.isColorLevel()) {
                QLog.d(PhotoPreviewActivity.TAG, 2, "getView position=" + i3 + ",cache=" + uRLDrawable + JefsClass.INDEX_URL + url);
            }
            URLImageView2 uRLImageView2 = new URLImageView2(viewGroup.getContext());
            if (uRLDrawable != null && uRLDrawable.getStatus() == 1) {
                uRLImageView2.setImageDrawable(uRLDrawable);
            } else if (!TextUtils.isEmpty(url)) {
                int width = viewGroup.getWidth();
                int height = viewGroup.getHeight();
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = width;
                obtain.mRequestHeight = height;
                obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
                int status = drawable.getStatus();
                if (status != 1 && status != 2 && status != 3) {
                    drawable.setTag(1);
                    drawable.startDownload();
                }
                if (QLog.isColorLevel()) {
                    QLog.d(PhotoPreviewActivity.TAG, 2, "getView position=" + i3 + ",parentWidth=" + width + ",parentHeight=" + height);
                }
                uRLImageView2.setImageDrawable(drawable);
            }
            uRLImageView2.setContentDescription(HardCodeUtil.qqStr(R.string.p6e) + i3);
            return uRLImageView2;
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        super.doOnBackPressed();
        if (this.gallery.resetScale(false)) {
            return;
        }
        back();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        BubblePopupWindow bubblePopupWindow = this.popup;
        if (bubblePopupWindow != null) {
            bubblePopupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        super.doOnNewIntent(intent);
        setIntent(intent);
        initData();
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        View view;
        super.doOnResume();
        if (!this.showBar || (view = this.topBar) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public String getURL(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("//")) {
            return "file:/" + str;
        }
        if (!str.startsWith("/")) {
            return str;
        }
        return "file://" + str;
    }

    void initData() {
        Intent intent = getIntent();
        this.backBtnText = intent.getStringExtra(BACK_BTN_TEXT);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        this.paths = stringArrayListExtra;
        int size = stringArrayListExtra != null ? stringArrayListExtra.size() : 0;
        this.mTotalPicCount = size;
        if (size < 1) {
            finish();
        } else {
            this.currentSelectedPostion = intent.getIntExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, 0);
            intent.removeExtra(QAlbumConstants.CURRENT_SELECTED_INDEX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        setContentView(R.layout.bdb);
        this.reqWidth = getResources().getDisplayMetrics().widthPixels;
        this.reqHeight = getResources().getDisplayMetrics().heightPixels;
        initData();
        initUI();
        return true;
    }

    void hideMenuBar() {
        this.showBar = false;
        this.topBar.setVisibility(4);
        BubblePopupWindow bubblePopupWindow = this.popup;
        if (bubblePopupWindow != null) {
            bubblePopupWindow.dismiss();
        }
    }

    void showMenuBar() {
        this.showBar = true;
        this.topBar.setVisibility(0);
    }

    void back() {
        QAlbumUtil.anim(this, true, false);
        super.finish();
    }

    void initUI() {
        this.topBar = findViewById(R.id.f166999jt2);
        TextView textView = (TextView) findViewById(R.id.a4c);
        this.backBtn = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.out.activity.PhotoPreviewActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PhotoPreviewActivity.this.back();
            }
        });
        if (this.showBar) {
            this.topBar.setVisibility(0);
        }
        this.titleView = (TextView) findViewById(R.id.title);
        this.gallery = (ProGallery) findViewById(R.id.gallery);
        ImageAdapter imageAdapter = new ImageAdapter();
        this.adapter = imageAdapter;
        this.gallery.setAdapter((SpinnerAdapter) imageAdapter);
        this.gallery.setOnNoBlankListener(this.adapter);
        this.gallery.setSpacing(getResources().getDimensionPixelSize(R.dimen.f158920sg));
        this.gallery.setSelection(this.currentSelectedPostion);
        this.gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.mini.out.activity.PhotoPreviewActivity.2
            @Override // com.tencent.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
                PhotoPreviewActivity photoPreviewActivity = PhotoPreviewActivity.this;
                if (photoPreviewActivity.showBar) {
                    photoPreviewActivity.hideMenuBar();
                } else {
                    photoPreviewActivity.showMenuBar();
                }
            }
        });
    }
}
