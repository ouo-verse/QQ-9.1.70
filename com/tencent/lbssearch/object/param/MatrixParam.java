package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.huawei.hms.hihealth.HiHealthActivities;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class MatrixParam implements ParamObject {
    static IPatchRedirector $redirector_;
    protected List<HeadingLatLng> fromPoints;
    protected String mode;
    protected List<LatLng> toPoints;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class ModeType {
        private static final /* synthetic */ ModeType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ModeType BICYCLING;
        public static final ModeType DRIVING;
        public static final ModeType TRUCKING;
        public static final ModeType WALKING;
        public final String mode;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60951);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ModeType modeType = new ModeType("DRIVING", 0, "driving");
            DRIVING = modeType;
            ModeType modeType2 = new ModeType("WALKING", 1, HiHealthActivities.WALKING);
            WALKING = modeType2;
            ModeType modeType3 = new ModeType("BICYCLING", 2, "bicycling");
            BICYCLING = modeType3;
            ModeType modeType4 = new ModeType("TRUCKING", 3, "trucking");
            TRUCKING = modeType4;
            $VALUES = new ModeType[]{modeType, modeType2, modeType3, modeType4};
        }

        ModeType(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
            } else {
                this.mode = str2;
            }
        }

        public static ModeType valueOf(String str) {
            return (ModeType) Enum.valueOf(ModeType.class, str);
        }

        public static ModeType[] values() {
            return (ModeType[]) $VALUES.clone();
        }
    }

    public MatrixParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.fromPoints = new ArrayList();
            this.toPoints = new ArrayList();
        }
    }

    private String locationToParamsString(HeadingLatLng headingLatLng) {
        String str = headingLatLng.latitude + "," + headingLatLng.longitude;
        if (headingLatLng.mHeading == null) {
            return str;
        }
        return str + "," + headingLatLng.mHeading;
    }

    public MatrixParam addFromPoint(HeadingLatLng headingLatLng) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MatrixParam) iPatchRedirector.redirect((short) 2, (Object) this, (Object) headingLatLng);
        }
        if (headingLatLng != null) {
            this.fromPoints.add(headingLatLng);
        }
        return this;
    }

    public MatrixParam addFromPoints(Iterator<HeadingLatLng> it) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MatrixParam) iPatchRedirector.redirect((short) 3, (Object) this, (Object) it);
        }
        if (it != null) {
            while (it.hasNext()) {
                HeadingLatLng next = it.next();
                if (next != null) {
                    this.fromPoints.add(next);
                }
            }
        }
        return this;
    }

    public MatrixParam addToPoint(LatLng latLng) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MatrixParam) iPatchRedirector.redirect((short) 4, (Object) this, (Object) latLng);
        }
        if (latLng != null) {
            this.toPoints.add(latLng);
        }
        return this;
    }

    public MatrixParam addToPoints(Iterator<LatLng> it) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MatrixParam) iPatchRedirector.redirect((short) 5, (Object) this, (Object) it);
        }
        if (it != null) {
            while (it.hasNext()) {
                LatLng next = it.next();
                if (next != null) {
                    this.toPoints.add(next);
                }
            }
        }
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RequestParams) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        RequestParams requestParams = new RequestParams();
        if (this.fromPoints.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<HeadingLatLng> it = this.fromPoints.iterator();
            while (it.hasNext()) {
                sb5.append(locationToParamsString(it.next()));
                sb5.append(";");
            }
            sb5.setLength(sb5.length() - 1);
            requestParams.put("from", sb5.toString());
        }
        if (this.toPoints.size() > 0) {
            StringBuilder sb6 = new StringBuilder();
            Iterator<LatLng> it5 = this.toPoints.iterator();
            while (it5.hasNext()) {
                sb6.append(locationToParamsString(it5.next()));
                sb6.append(";");
            }
            sb6.setLength(sb6.length() - 1);
            requestParams.put("to", sb6.toString());
        }
        if (!TextUtils.isEmpty(this.mode)) {
            requestParams.put("mode", this.mode);
        }
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.fromPoints != null && this.toPoints != null && this.mode != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MatrixParam setMode(ModeType modeType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MatrixParam) iPatchRedirector.redirect((short) 8, (Object) this, (Object) modeType);
        }
        this.mode = modeType.mode;
        return this;
    }

    /* loaded from: classes7.dex */
    public static class HeadingLatLng extends LatLng {
        static IPatchRedirector $redirector_;
        public Integer mHeading;

        public HeadingLatLng(LatLng latLng, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) latLng, i3);
                return;
            }
            this.latitude = latLng.latitude;
            this.longitude = latLng.longitude;
            this.mHeading = Integer.valueOf(i3);
        }

        public HeadingLatLng(LatLng latLng) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) latLng);
            } else {
                this.latitude = latLng.latitude;
                this.longitude = latLng.longitude;
            }
        }
    }

    private String locationToParamsString(LatLng latLng) {
        return latLng.latitude + "," + latLng.longitude;
    }
}
