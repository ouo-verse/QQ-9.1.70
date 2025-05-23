package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.LocationElement;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMLocationElem extends V2TIMElem {
    private String description;
    private double longitude = 0.0d;
    private double latitude = 0.0d;

    public String getDesc() {
        if (getElement() == null) {
            return this.description;
        }
        return ((LocationElement) getElement()).getDescription();
    }

    public double getLatitude() {
        if (getElement() == null) {
            return this.latitude;
        }
        return ((LocationElement) getElement()).getLatitude();
    }

    public double getLongitude() {
        if (getElement() == null) {
            return this.longitude;
        }
        return ((LocationElement) getElement()).getLongitude();
    }

    public void setDesc(String str) {
        if (getElement() == null) {
            this.description = str;
        } else {
            ((LocationElement) getElement()).setDescription(str);
        }
    }

    public void setLatitude(double d16) {
        if (getElement() == null) {
            this.latitude = d16;
        } else {
            ((LocationElement) getElement()).setLatitude(d16);
        }
    }

    public void setLongitude(double d16) {
        if (getElement() == null) {
            this.longitude = d16;
        } else {
            ((LocationElement) getElement()).setLongitude(d16);
        }
    }

    public String toString() {
        return "V2TIMLocationElem--->longitude:" + getLongitude() + ", latitude:" + getLatitude() + ", desc:" + getDesc();
    }
}
