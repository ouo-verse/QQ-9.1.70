package com.qzone.proxy.feedcomponent.model;

import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.RawImageProcessor;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FriendBirthdayGift implements SmartParcelable {

    @NeedParcel
    public int actiontype;
    public boolean hasSent;
    ImageProcessor imageProcessor;

    @NeedParcel
    public boolean istiming;
    public int magic;

    @NeedParcel
    public int moreflag;
    public ImageLoader.Options preOpt;
    RawImageProcessor rawImageProcessor;
    public long receiveruin;

    @NeedParcel
    public String sendtime;

    @NeedParcel
    public String giftname = "";

    @NeedParcel
    public String giftviewname = "";

    @NeedParcel
    public String gifttype = "";

    @NeedParcel
    public String giftid = "";

    @NeedParcel
    public Map<Integer, String> gifturl = null;
    public Map<Integer, ImageUrl> giftImageUrl = null;

    @NeedParcel
    public String giftdesc = "";

    @NeedParcel
    public String giftbackid = "";

    @NeedParcel
    public String actionurl = "";

    public ImageUrl getCurrentImageUrl() {
        Map<Integer, ImageUrl> map = this.giftImageUrl;
        if (map != null && map.size() > 0) {
            ImageUrl imageUrl = this.giftImageUrl.get(1);
            if (imageUrl != null) {
                return imageUrl;
            }
            ImageUrl imageUrl2 = this.giftImageUrl.get(2);
            if (imageUrl2 != null) {
                return imageUrl2;
            }
            ImageUrl imageUrl3 = this.giftImageUrl.get(3);
            if (imageUrl3 != null) {
                return imageUrl3;
            }
            ImageUrl imageUrl4 = this.giftImageUrl.get(0);
            if (imageUrl4 != null) {
                return imageUrl4;
            }
        }
        return null;
    }

    public String getCurrentUrl() {
        Map<Integer, String> map = this.gifturl;
        if (map != null && map.size() > 0) {
            String str = this.gifturl.get(1);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String str2 = this.gifturl.get(2);
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            String str3 = this.gifturl.get(3);
            if (!TextUtils.isEmpty(str3)) {
                return str3;
            }
            String str4 = this.gifturl.get(0);
            if (!TextUtils.isEmpty(str4)) {
                return str4;
            }
        }
        return null;
    }

    public ImageProcessor getImageProcessor() {
        return this.imageProcessor;
    }

    public RawImageProcessor getRawImageProcessor() {
        return this.rawImageProcessor;
    }

    public void setImageProcessor(ImageProcessor imageProcessor) {
        this.imageProcessor = imageProcessor;
    }

    public void setRawImageProcessor(RawImageProcessor rawImageProcessor) {
        this.rawImageProcessor = rawImageProcessor;
    }
}
