package com.tencent.comic.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes32.dex */
public class RedTouchUI extends RedTouch {

    /* renamed from: d, reason: collision with root package name */
    private int f99461d;

    /* renamed from: e, reason: collision with root package name */
    private int f99462e;

    /* renamed from: f, reason: collision with root package name */
    private List<RedTypeInfo> f99463f;

    /* renamed from: h, reason: collision with root package name */
    public RedAppInfo f99464h;

    public RedTouchUI(Context context) {
        this(context, null);
    }

    private void a(RedTypeInfo redTypeInfo) {
        JSONObject jSONObject;
        int i3;
        if (redTypeInfo == null) {
            return;
        }
        this.redTouchContainer.setVisibility(0);
        try {
            if (TextUtils.isEmpty(redTypeInfo.getRedDesc())) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(redTypeInfo.getRedDesc());
            }
            int realColor = jSONObject.has(VasProfileTemplatePreloadHelper.BACKGROUND) ? getRealColor(jSONObject.getString(VasProfileTemplatePreloadHelper.BACKGROUND)) : 0;
            int redType = redTypeInfo.getRedType();
            if (redType == 0) {
                ImageView redPoint = getRedPoint(realColor);
                if (redPoint != null) {
                    int i16 = this.redPointId;
                    this.redPointId = i16 + 1;
                    redPoint.setId(i16);
                    this.redTouchContainer.addView(redPoint);
                    return;
                }
                return;
            }
            if (redType == 9) {
                View space = getSpace(redTypeInfo.getRedContent());
                if (space != null) {
                    this.redTouchContainer.addView(space);
                    return;
                }
                return;
            }
            if (redType == 3) {
                View c16 = c(redTypeInfo.getRedContent(), jSONObject.has("av") ? jSONObject.getInt("av") : 0, jSONObject.has("dot") ? jSONObject.getInt("dot") : 0, realColor);
                if (c16 != null) {
                    int i17 = this.redImageId;
                    this.redImageId = i17 + 1;
                    c16.setId(i17);
                    this.redTouchContainer.addView(c16);
                    return;
                }
                return;
            }
            if (redType == 4 || redType == 5) {
                View textRedPoint = getTextRedPoint(redTypeInfo.getRedContent(), jSONObject.has("cr") ? getRealColor(jSONObject.getString("cr")) : -1, jSONObject.has("cn") ? getRealColor(jSONObject.getString("cn")) : 0, realColor);
                if (textRedPoint != null) {
                    if (redTypeInfo.getRedType() == 4) {
                        i3 = this.redTextId;
                        this.redTextId = i3 + 1;
                    } else {
                        i3 = this.redNumId;
                        this.redNumId = i3 + 1;
                    }
                    textRedPoint.setId(i3);
                    this.redTouchContainer.addView(textRedPoint);
                }
            }
        } catch (Exception unused) {
        }
    }

    private boolean b(RedTypeInfo redTypeInfo, RedTypeInfo redTypeInfo2) {
        return redTypeInfo.getRedType() == redTypeInfo2.getRedType() && redTypeInfo.getRedContent().equals(redTypeInfo2.getRedContent()) && redTypeInfo.getRedDesc().equals(redTypeInfo2.getRedDesc()) && redTypeInfo.getRedPriority() == redTypeInfo2.getRedPriority();
    }

    private boolean checkIsEqual(List<RedTypeInfo> list) {
        if (this.f99463f.size() == 0 || this.f99463f.size() != list.size()) {
            return false;
        }
        for (int i3 = 0; i3 < this.f99463f.size(); i3++) {
            if (!b(this.f99463f.get(i3), list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public View c(String str, int i3, int i16, int i17) {
        URLImageView uRLImageView = new URLImageView(this.context);
        uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        uRLImageView.setBackgroundColor(i17);
        downLoadIcon(str, uRLImageView, i3);
        if (i16 == 1) {
            if (this.f99461d != -1) {
                FrameLayout frameLayout = new FrameLayout(getContext());
                uRLImageView.setLayoutParams(new FrameLayout.LayoutParams(dipToPixels(36.0f), dipToPixels(36.0f)));
                uRLImageView.setPadding(dipToPixels(3.0f), dipToPixels(3.0f), dipToPixels(3.0f), dipToPixels(3.0f));
                frameLayout.addView(uRLImageView);
                ImageView imageView = new ImageView(this.context);
                imageView.setImageResource(this.f99461d);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 53;
                imageView.setLayoutParams(layoutParams);
                frameLayout.addView(imageView);
                frameLayout.setLayoutParams(getRedTouchLayoutParams());
                return frameLayout;
            }
            throw new RuntimeException("must set the redpoint imageresource");
        }
        LinearLayout.LayoutParams redTouchLayoutParams = getRedTouchLayoutParams();
        redTouchLayoutParams.width = dipToPixels(36.0f);
        redTouchLayoutParams.height = dipToPixels(36.0f);
        uRLImageView.setLayoutParams(redTouchLayoutParams);
        uRLImageView.setPadding(dipToPixels(3.0f), dipToPixels(3.0f), dipToPixels(3.0f), dipToPixels(3.0f));
        return uRLImageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tianshu.ui.RedTouch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ImageView getRedPoint(int i3) {
        if (this.f99461d != -1) {
            ImageView imageView = new ImageView(this.context);
            imageView.setImageResource(this.f99461d);
            imageView.setBackgroundColor(i3);
            imageView.setLayoutParams(getRedTouchLayoutParams());
            return imageView;
        }
        throw new RuntimeException("must set the redpoint imageresource");
    }

    public void e(RedAppInfo redAppInfo) {
        clearRedTouch();
        if (redAppInfo == null) {
            return;
        }
        this.f99463f.clear();
        if (redAppInfo.M() == 0 || redAppInfo.F() == null || redAppInfo.F().c() == null || checkIsEqual(redAppInfo.F().c())) {
            return;
        }
        this.f99463f.addAll(redAppInfo.F().c());
        Iterator<RedTypeInfo> it = this.f99463f.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.f99464h = redAppInfo;
    }

    @Override // com.tencent.mobileqq.tianshu.ui.RedTouch
    protected View getTextRedPoint(String str, int i3, int i16, int i17) {
        if (this.f99462e != -1) {
            TextView textView = new TextView(this.context);
            try {
                if (Integer.parseInt(str) > this.maxNum) {
                    textView.setText(this.maxNum + Marker.ANY_NON_NULL_MARKER);
                } else {
                    textView.setText(str);
                }
            } catch (NumberFormatException unused) {
                textView.setText(str);
            }
            textView.setTextColor(i3);
            textView.setGravity(17);
            textView.setSingleLine(true);
            if (i16 != 0) {
                textView.setTextSize(11.0f);
                textView.setBackgroundResource(this.f99462e);
            } else {
                textView.setTextSize(13.0f);
            }
            textView.setLayoutParams(getRedTouchLayoutParams());
            if (this.isLeftAlign) {
                textView.measure(0, 0);
                this.leftMargin = textView.getMeasuredWidth() / 2;
                changeRedTouchContainer();
            }
            return textView;
        }
        throw new RuntimeException("must set the redpoint imageresource");
    }

    public void setRedpointImgResID(int i3) {
        this.f99461d = i3;
    }

    public void setTextOrNumImgRedID(int i3) {
        this.f99462e = i3;
    }

    public RedTouchUI(Context context, View view) {
        super(context, view);
        this.f99461d = -1;
        this.f99462e = -1;
        this.f99464h = null;
        this.f99463f = new ArrayList();
    }
}
