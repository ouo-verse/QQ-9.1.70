package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.utils.ViewUtils;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendHonorOfKingRecordView extends FrameLayout {
    private ImageView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private URLImageView H;
    private URLImageView I;
    private URLImageView J;
    private ImageView K;
    private ImageView L;
    private ImageView M;

    /* renamed from: d, reason: collision with root package name */
    private View f264139d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f264140e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f264141f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f264142h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f264143i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f264144m;

    public ExtendFriendHonorOfKingRecordView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.czv, (ViewGroup) this, true);
        this.f264139d = inflate;
        this.f264140e = (ImageView) inflate.findViewById(R.id.p0z);
        this.f264142h = (ImageView) this.f264139d.findViewById(R.id.p1o);
        this.f264141f = (ImageView) this.f264139d.findViewById(R.id.f163234p12);
        this.f264143i = (TextView) this.f264139d.findViewById(R.id.p1p);
        this.f264144m = (TextView) this.f264139d.findViewById(R.id.f163235p13);
        this.C = (ImageView) this.f264139d.findViewById(R.id.f163233p11);
        this.D = (TextView) this.f264139d.findViewById(R.id.f163239p21);
        this.E = (TextView) this.f264139d.findViewById(R.id.p0h);
        this.F = (TextView) this.f264139d.findViewById(R.id.p2k);
        this.G = (TextView) this.f264139d.findViewById(R.id.ozq);
        this.H = (URLImageView) this.f264139d.findViewById(R.id.p1_);
        this.I = (URLImageView) this.f264139d.findViewById(R.id.p1a);
        this.J = (URLImageView) this.f264139d.findViewById(R.id.p1b);
        this.K = (ImageView) this.f264139d.findViewById(R.id.p1c);
        this.L = (ImageView) this.f264139d.findViewById(R.id.p1d);
        this.M = (ImageView) this.f264139d.findViewById(R.id.p1e);
    }

    private void b(JSONObject jSONObject) {
        this.D.setText(String.valueOf(jSONObject.optInt("games_total", 0)));
        this.E.setText(String.valueOf(jSONObject.optInt("mvp_total", 0)));
        try {
            double optDouble = jSONObject.optDouble("win_rate");
            NumberFormat percentInstance = NumberFormat.getPercentInstance();
            percentInstance.setMaximumFractionDigits(2);
            this.F.setText(percentInstance.format(optDouble));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        String occupationTypeText = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getOccupationTypeText(jSONObject.optInt("best_occupation", 0));
        if (TextUtils.isEmpty(occupationTypeText)) {
            return;
        }
        this.G.setText(occupationTypeText);
    }

    private void d(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("best_heros");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.H);
        arrayList.add(this.I);
        arrayList.add(this.J);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList2.add(this.K);
        arrayList2.add(this.L);
        arrayList2.add(this.M);
        for (int i3 = 0; i3 < 3; i3++) {
            if (i3 >= length) {
                ((URLImageView) arrayList.get(i3)).setVisibility(8);
                ((ImageView) arrayList2.get(i3)).setVisibility(8);
            } else {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = ViewUtils.dpToPx(20.0f);
                obtain.mRequestHeight = ViewUtils.dpToPx(20.0f);
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject == null) {
                    ((URLImageView) arrayList.get(i3)).setVisibility(8);
                    ((ImageView) arrayList2.get(i3)).setVisibility(8);
                } else {
                    URLDrawable drawable = URLDrawable.getDrawable(optJSONObject.optString("icon"), obtain);
                    if (drawable != null) {
                        int dpToPx = ViewUtils.dpToPx(20.0f);
                        drawable.setTag(com.tencent.mobileqq.urldrawable.a.d(dpToPx, dpToPx));
                        drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306335o);
                        ((URLImageView) arrayList.get(i3)).setImageDrawable(drawable);
                    }
                    ((URLImageView) arrayList.get(i3)).setVisibility(0);
                    Bitmap imageBitmap = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap(((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getGameSkilledLevelIconPath(optJSONObject.optInt("skill", 0)));
                    if (imageBitmap != null) {
                        ((ImageView) arrayList2.get(i3)).setImageBitmap(imageBitmap);
                        ((ImageView) arrayList2.get(i3)).setVisibility(0);
                    }
                }
            }
        }
    }

    public ExtendFriendHonorOfKingRecordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void c(int i3) {
        int i16 = i3 / 100000;
        Bitmap imageBitmap = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap(((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getGameGradeStarImagePathById(i3));
        if (i16 >= 8) {
            if (imageBitmap != null) {
                this.f264142h.setImageBitmap(imageBitmap);
            }
            String string = getContext().getString(R.string.f160391uw, String.valueOf(i3 % 10000));
            if (!TextUtils.isEmpty(string)) {
                this.f264143i.setText(string);
            }
        } else {
            if (imageBitmap != null) {
                this.f264141f.setImageBitmap(imageBitmap);
            }
            Bitmap imageBitmap2 = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap(((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getGameGradeNumberIconPathById(i3));
            if (imageBitmap2 != null) {
                this.C.setImageBitmap(imageBitmap2);
            }
        }
        Bitmap imageBitmap3 = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap(((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getGameGradeIconPathById(i3));
        if (imageBitmap3 != null) {
            this.f264140e.setImageBitmap(imageBitmap3);
        }
        String gradeDescById = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getGradeDescById(i3);
        if (TextUtils.isEmpty(gradeDescById)) {
            return;
        }
        this.f264144m.setText(gradeDescById);
    }

    public void setData(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(QQPermissionConstants.Permission.AUIDO_GROUP)) == null) {
            return;
        }
        c(optJSONObject.optInt("grade", 0));
        b(optJSONObject);
        d(optJSONObject);
    }

    public ExtendFriendHonorOfKingRecordView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context);
    }
}
