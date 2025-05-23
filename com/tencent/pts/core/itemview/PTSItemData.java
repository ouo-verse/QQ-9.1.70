package com.tencent.pts.core.itemview;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes22.dex */
public class PTSItemData implements Parcelable {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<PTSItemData> CREATOR;
    public static final String TAG = "PTSItemData";
    private String frameTreeJson;
    private String itemId;
    private String jsonData;
    private String pageJs;
    private String pageName;

    /* loaded from: classes22.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private String frameTreeJson;
        private String itemID;
        private String jsonData;
        private String pageJs;
        private String pageName;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public PTSItemData build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (PTSItemData) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            PTSItemData pTSItemData = new PTSItemData(null);
            pTSItemData.itemId = this.itemID;
            pTSItemData.pageName = this.pageName;
            pTSItemData.jsonData = this.jsonData;
            pTSItemData.frameTreeJson = this.frameTreeJson;
            pTSItemData.pageJs = this.pageJs;
            return pTSItemData;
        }

        public Builder withFrameTreeJson(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.frameTreeJson = str;
            return this;
        }

        public Builder withItemID(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.itemID = str;
            return this;
        }

        public Builder withJsonData(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.jsonData = str;
            return this;
        }

        public Builder withPageJs(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.pageJs = str;
            return this;
        }

        public Builder withPageName(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.pageName = str;
            return this;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37220);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            CREATOR = new Parcelable.Creator<PTSItemData>() { // from class: com.tencent.pts.core.itemview.PTSItemData.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public PTSItemData createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new Builder().withItemID(parcel.readString()).withPageName(parcel.readString()).withJsonData(parcel.readString()).withFrameTreeJson(parcel.readString()).withPageJs(parcel.readString()).build() : (PTSItemData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public PTSItemData[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new PTSItemData[i3] : (PTSItemData[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    /* synthetic */ PTSItemData(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this, (Object) anonymousClass1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof PTSItemData)) {
            return false;
        }
        PTSItemData pTSItemData = (PTSItemData) obj;
        if (!TextUtils.equals(this.itemId, pTSItemData.getItemID()) || !TextUtils.equals(this.jsonData, pTSItemData.getJSONData())) {
            return false;
        }
        return true;
    }

    public String getFrameTreeJson() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.frameTreeJson;
    }

    public String getItemID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.itemId;
    }

    public String getJSONData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.jsonData;
    }

    public String getPageJs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.pageJs;
    }

    public String getPageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.pageName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.itemId);
        parcel.writeString(this.pageName);
        parcel.writeString(this.jsonData);
        parcel.writeString(this.frameTreeJson);
        parcel.writeString(this.pageJs);
    }

    PTSItemData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
