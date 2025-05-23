package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;
import androidx.annotation.Nullable;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.emoticon.data.IEmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonInfo extends EmotionPanelData implements IEmoticonInfo {
    static IPatchRedirector $redirector_ = null;
    public static final String ADD_ACTION = "add";
    public static final int ADD_LOCAL = 1;
    public static final String CAMERA_EDIT_ACTION = "cameraEdit";
    public static final String CAMERA_JUMP_ACTION = "cameraJump";
    public static final Parcelable.Creator<EmoticonInfo> CREATOR;
    public static final int DEFAULT = 0;
    public static final String DELETE_ACTION = "delete";
    public static final int FAVORITE = 2;
    public static final String FAV_EDIT_ACTION = "favEdit";
    public static final String FUNNY_PIC_ACTION = "funny_pic";
    public static final String PUSH_ACTION = "push";
    public static final int RENCENT = 1;
    public static final String SETTING_ACTION = "setting";
    public static final String SHOW_FAV_MENU_ACTION = "show_fav_menu";
    public String action;
    public int drawableId;
    public int emoId;
    public boolean isChecked;
    public String longClickAction;
    public int operateType;
    public int srcType;
    public Serializable stickerInfo;
    public int type;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40750);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            CREATOR = new Parcelable.Creator<EmoticonInfo>() { // from class: com.tencent.mobileqq.emoticonview.EmoticonInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public EmoticonInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new EmoticonInfo(parcel) : (EmoticonInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public EmoticonInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new EmoticonInfo[i3] : (EmoticonInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public EmoticonInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.type = -1;
        this.srcType = 0;
        this.operateType = 0;
    }

    private Drawable getResourceDrawableThroughImageCache(Resources resources, int i3) {
        Bitmap f16 = ImageCacheHelper.f98636a.f("android.resource://" + i3);
        if (f16 != null) {
            return new BitmapDrawable(f16);
        }
        try {
            return resources.getDrawable(i3);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public Drawable getBigDrawable(Context context, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, this, context, Float.valueOf(f16));
        }
        return getDrawable(context, f16);
    }

    @Nullable
    public String getBigImagePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return null;
    }

    @Nullable
    public String getBigImageURL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return null;
    }

    public Drawable getDrawable(Context context, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, this, context, Float.valueOf(f16));
        }
        return getResourceDrawableThroughImageCache(context.getResources(), this.drawableId);
    }

    public int getEmoticonType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return 0;
    }

    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return null;
    }

    @Nullable
    public Option getOption() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Option) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return null;
    }

    @Nullable
    public String getThumbImagePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return null;
    }

    @Nullable
    public String getThumbURL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return null;
    }

    public Drawable getZoomDrawable(Context context, float f16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Drawable) iPatchRedirector.redirect((short) 6, this, context, Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return getResourceDrawableThroughImageCache(context.getResources(), this.drawableId);
    }

    public void send(AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, appRuntime, context, editText, parcelable);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "EmoticonInfo[type: " + this.type + "  action: " + this.action + "]";
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.type);
        parcel.writeString(this.action);
        parcel.writeString(this.longClickAction);
        parcel.writeInt(this.srcType);
        parcel.writeInt(this.drawableId);
        parcel.writeInt(this.operateType);
        parcel.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.emoId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EmoticonInfo(Parcel parcel) {
        super(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.type = -1;
        this.srcType = 0;
        this.operateType = 0;
        this.type = parcel.readInt();
        this.action = parcel.readString();
        this.longClickAction = parcel.readString();
        this.srcType = parcel.readInt();
        this.drawableId = parcel.readInt();
        this.operateType = parcel.readInt();
        this.isChecked = parcel.readByte() != 0;
        this.emoId = parcel.readInt();
    }
}
