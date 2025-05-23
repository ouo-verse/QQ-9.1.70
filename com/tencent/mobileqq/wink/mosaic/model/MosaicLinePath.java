package com.tencent.mobileqq.wink.mosaic.model;

import android.graphics.Path;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\t\b\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/mosaic/model/MosaicLinePath;", "Ljava/io/Serializable;", "Lorg/json/JSONObject;", "saveEditDraftInfo", "editInfo", "", "parseEditDraftInfo", "", "o", "", "equals", "", "hashCode", "Landroid/graphics/Path;", "path", "Landroid/graphics/Path;", "", "lineWidth", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/mosaic/model/PointAction;", "mTouchPoints", "Ljava/util/ArrayList;", "<init>", "()V", "Companion", "a", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MosaicLinePath implements Serializable {

    @NotNull
    public static final String TAG = "MosaicLinePath_mosaic";
    public static final long serialVersionUID = 599093123464337757L;

    @JvmField
    public float lineWidth;

    @JvmField
    @Nullable
    public Path path = new Path();

    @JvmField
    @Nullable
    public ArrayList<PointAction> mTouchPoints = new ArrayList<>();

    public boolean equals(@Nullable Object o16) {
        boolean z16 = true;
        if (this == o16) {
            return true;
        }
        if (o16 == null || !Intrinsics.areEqual(MosaicLinePath.class, o16.getClass())) {
            return false;
        }
        MosaicLinePath mosaicLinePath = (MosaicLinePath) o16;
        if (this.lineWidth != mosaicLinePath.lineWidth) {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return Intrinsics.areEqual(this.mTouchPoints, mosaicLinePath.mTouchPoints);
    }

    public int hashCode() {
        ArrayList<PointAction> arrayList = this.mTouchPoints;
        int i3 = 0;
        if (arrayList != null && arrayList != null) {
            i3 = arrayList.hashCode();
        }
        return 31 + i3;
    }

    public final void parseEditDraftInfo(@NotNull JSONObject editInfo) {
        Intrinsics.checkNotNullParameter(editInfo, "editInfo");
        try {
            this.lineWidth = editInfo.getInt("lineWidth");
            this.path = new Path();
            this.mTouchPoints = new ArrayList<>();
            JSONArray jSONArray = editInfo.getJSONArray("points");
            int length = jSONArray.length();
            PointAction pointAction = null;
            int i3 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                i3++;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 == 5) {
                                    Intrinsics.checkNotNull(pointAction);
                                    pointAction.f324013y2 = (float) jSONArray.getDouble(i16);
                                    ArrayList<PointAction> arrayList = this.mTouchPoints;
                                    Intrinsics.checkNotNull(arrayList);
                                    arrayList.add(pointAction);
                                    Path path = this.path;
                                    Intrinsics.checkNotNull(path);
                                    path.quadTo(pointAction.f324010x, pointAction.f324012y, pointAction.f324011x2, pointAction.f324013y2);
                                    i3 = 0;
                                }
                            } else {
                                Intrinsics.checkNotNull(pointAction);
                                pointAction.f324011x2 = (float) jSONArray.getDouble(i16);
                            }
                        } else {
                            Intrinsics.checkNotNull(pointAction);
                            pointAction.f324012y = (float) jSONArray.getDouble(i16);
                            int i17 = pointAction.mode;
                            if (i17 == PointAction.MOVETO) {
                                ArrayList<PointAction> arrayList2 = this.mTouchPoints;
                                Intrinsics.checkNotNull(arrayList2);
                                arrayList2.add(pointAction);
                                Path path2 = this.path;
                                Intrinsics.checkNotNull(path2);
                                path2.moveTo(pointAction.f324010x, pointAction.f324012y);
                            } else if (i17 == PointAction.LINETO) {
                                ArrayList<PointAction> arrayList3 = this.mTouchPoints;
                                Intrinsics.checkNotNull(arrayList3);
                                arrayList3.add(pointAction);
                                Path path3 = this.path;
                                Intrinsics.checkNotNull(path3);
                                path3.lineTo(pointAction.f324010x, pointAction.f324012y);
                            }
                            i3 = 0;
                        }
                    } else {
                        Intrinsics.checkNotNull(pointAction);
                        pointAction.f324010x = (float) jSONArray.getDouble(i16);
                    }
                } else {
                    pointAction = new PointAction();
                    pointAction.mode = jSONArray.getInt(i16);
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parseEditDraftInfo error:", e16);
        }
    }

    @Nullable
    public final JSONObject saveEditDraftInfo() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lineWidth", Float.valueOf(this.lineWidth));
            JSONArray jSONArray = new JSONArray();
            ArrayList<PointAction> arrayList = this.mTouchPoints;
            Intrinsics.checkNotNull(arrayList);
            Iterator<PointAction> it = arrayList.iterator();
            while (it.hasNext()) {
                PointAction next = it.next();
                jSONArray.put(next.mode);
                jSONArray.put(next.f324010x);
                jSONArray.put(next.f324012y);
                if (next.mode == PointAction.QUADTO) {
                    jSONArray.put(next.f324011x2);
                    jSONArray.put(next.f324013y2);
                }
            }
            jSONObject.put("points", jSONArray);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
