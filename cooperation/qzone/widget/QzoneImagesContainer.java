package cooperation.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneImagesContainer extends LinearLayout {
    private static int MAX_NUM_CHILDREN = 5;
    private List<ByteStringMicro> images;
    private int totalPic;

    public QzoneImagesContainer(Context context) {
        super(context);
    }

    private void setImagesInLayout(List<ByteStringMicro> list, int i3) {
        if (list != null && !list.isEmpty()) {
            removeAllViewsInLayout();
            Iterator<ByteStringMicro> it = list.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                String stringUtf8 = it.next().toStringUtf8();
                if (URLUtil.isValidUrl(stringUtf8)) {
                    i16++;
                    int i17 = MAX_NUM_CHILDREN;
                    if (i16 < i17) {
                        URLImageView uRLImageView = new URLImageView(getContext());
                        uRLImageView.setVisibility(0);
                        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        uRLImageView.setImageURL(stringUtf8);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(60.0f), ViewUtils.dpToPx(60.0f));
                        layoutParams.setMargins(0, 0, ViewUtils.dpToPx(2.0f), 0);
                        addViewInLayout(uRLImageView, i16 - 1, layoutParams);
                        uRLImageView.setDuplicateParentStateEnabled(true);
                    } else if (i16 == i17) {
                        MaskURLImageView maskURLImageView = new MaskURLImageView(getContext());
                        maskURLImageView.setVisibility(0);
                        maskURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        maskURLImageView.setImageURL(stringUtf8);
                        addViewInLayout(maskURLImageView, i16 - 1, new LinearLayout.LayoutParams(ViewUtils.dpToPx(60.0f), ViewUtils.dpToPx(60.0f)));
                        maskURLImageView.setHasMore(i3 - i16);
                        maskURLImageView.setDuplicateParentStateEnabled(true);
                    }
                }
            }
            if (i16 > 0) {
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int childCount = getChildCount();
        int i19 = childCount;
        while (i19 > 0 && getChildAt(i19 - 1).getRight() > i17) {
            i19--;
        }
        if (i19 != childCount) {
            MAX_NUM_CHILDREN = i19;
            List<ByteStringMicro> subList = this.images.subList(0, i19);
            this.images = subList;
            setImagesInLayout(subList, this.totalPic);
            requestLayout();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    public void setImages(List<ByteStringMicro> list, int i3, boolean z16) {
        this.images = list;
        this.totalPic = i3;
        removeAllViews();
        if (list != null && !list.isEmpty()) {
            if (z16) {
                String stringUtf8 = list.get(0).toStringUtf8();
                MaskURLImageView maskURLImageView = new MaskURLImageView(getContext());
                maskURLImageView.setVisibility(0);
                maskURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                maskURLImageView.setImageURL(stringUtf8);
                addView(maskURLImageView, new LinearLayout.LayoutParams(ViewUtils.dpToPx(60.0f), ViewUtils.dpToPx(60.0f)));
                maskURLImageView.setNeedSowPlayIcon(true);
                maskURLImageView.setDuplicateParentStateEnabled(true);
                return;
            }
            Iterator<ByteStringMicro> it = list.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                String stringUtf82 = it.next().toStringUtf8();
                int dpToPx = ViewUtils.dpToPx(60.0f);
                if (URLUtil.isValidUrl(stringUtf82)) {
                    i16++;
                    int i17 = MAX_NUM_CHILDREN;
                    if (i16 < i17) {
                        URLImageView uRLImageView = new URLImageView(getContext());
                        uRLImageView.setVisibility(0);
                        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mRequestHeight = dpToPx;
                        obtain.mRequestWidth = dpToPx;
                        uRLImageView.setImageDrawable(URLDrawable.getDrawable(stringUtf82, obtain));
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dpToPx, dpToPx);
                        layoutParams.setMargins(0, 0, ViewUtils.dpToPx(2.0f), 0);
                        addView(uRLImageView, layoutParams);
                        uRLImageView.setDuplicateParentStateEnabled(true);
                    } else if (i16 == i17) {
                        MaskURLImageView maskURLImageView2 = new MaskURLImageView(getContext());
                        maskURLImageView2.setVisibility(0);
                        maskURLImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                        obtain2.mRequestHeight = dpToPx;
                        obtain2.mRequestWidth = dpToPx;
                        maskURLImageView2.setImageDrawable(URLDrawable.getDrawable(stringUtf82, obtain2));
                        addView(maskURLImageView2, new LinearLayout.LayoutParams(dpToPx, dpToPx));
                        maskURLImageView2.setHasMore(i3 - i16);
                        maskURLImageView2.setDuplicateParentStateEnabled(true);
                    }
                }
            }
            if (i16 > 0) {
                setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    public QzoneImagesContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
