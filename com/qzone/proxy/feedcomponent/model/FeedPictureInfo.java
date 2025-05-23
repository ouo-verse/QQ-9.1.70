package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.stPhotoTag;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.RawImageProcessor;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes39.dex */
public class FeedPictureInfo {

    /* renamed from: a, reason: collision with root package name */
    ImageType f50238a;

    /* renamed from: b, reason: collision with root package name */
    final PictureUrl f50239b;

    /* renamed from: c, reason: collision with root package name */
    PictureUrl f50240c;

    /* renamed from: d, reason: collision with root package name */
    PictureUrl f50241d;

    /* renamed from: e, reason: collision with root package name */
    PictureUrl f50242e;

    /* renamed from: f, reason: collision with root package name */
    boolean f50243f;

    /* renamed from: g, reason: collision with root package name */
    ImageProcessor f50244g;

    /* renamed from: h, reason: collision with root package name */
    RawImageProcessor f50245h;

    /* renamed from: i, reason: collision with root package name */
    float f50246i;

    /* renamed from: j, reason: collision with root package name */
    float f50247j;

    /* renamed from: k, reason: collision with root package name */
    public ImageLoader.Options f50248k;

    /* renamed from: l, reason: collision with root package name */
    public int f50249l;

    /* renamed from: m, reason: collision with root package name */
    public String f50250m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f50251n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f50252o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f50253p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f50254q;

    /* renamed from: r, reason: collision with root package name */
    public int f50255r;

    /* renamed from: s, reason: collision with root package name */
    public int f50256s;

    /* renamed from: t, reason: collision with root package name */
    public int f50257t;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList<stPhotoTag> f50258u;

    /* renamed from: v, reason: collision with root package name */
    public Map<Integer, String> f50259v;

    /* renamed from: w, reason: collision with root package name */
    public int f50260w;

    /* renamed from: x, reason: collision with root package name */
    public VideoInfo f50261x;

    /* renamed from: y, reason: collision with root package name */
    public String f50262y;

    /* renamed from: z, reason: collision with root package name */
    public String f50263z;

    /* loaded from: classes39.dex */
    public enum ImageType {
        NORMAL,
        IMAGE_GIF,
        IMAGE_GOLDEN_CUDGEL,
        VIDEO,
        MUSIC,
        AUDIO,
        LEFT_THUMB_VIDEO,
        LEFT_THUMB_AUDIO,
        LEFT_THUMB_QQMUSIC,
        LEFT_THUMB_OUTAUDIO,
        SPACE_REDPOCKET,
        CIRCLE_PANORAMA,
        BALL_PANORAMA
    }

    public FeedPictureInfo(PictureUrl pictureUrl, String... strArr) {
        this(null, pictureUrl, 0.0f, 0.0f, 18, null, strArr);
    }

    public PictureUrl a() {
        return this.f50241d;
    }

    public PictureUrl b() {
        return this.f50240c;
    }

    public ImageProcessor c() {
        return this.f50244g;
    }

    public ImageType d() {
        return this.f50238a;
    }

    public float e() {
        return this.f50246i;
    }

    public float f() {
        return this.f50247j;
    }

    public RawImageProcessor g() {
        return this.f50245h;
    }

    public PictureUrl h() {
        return this.f50239b;
    }

    public boolean i() {
        return this.f50243f;
    }

    public boolean j() {
        return this.f50254q;
    }

    public boolean k() {
        return this.f50238a == ImageType.MUSIC;
    }

    public boolean l() {
        return this.f50238a == ImageType.VIDEO;
    }

    public void m(String str) {
        this.f50263z = str;
    }

    public void n(PictureUrl pictureUrl) {
        this.f50241d = pictureUrl;
    }

    public void o(boolean z16) {
        this.f50254q = z16;
    }

    public void p(boolean z16) {
        this.f50253p = z16;
    }

    public void q(ImageProcessor imageProcessor) {
        this.f50244g = imageProcessor;
    }

    public void r(ImageType imageType) {
        this.f50238a = imageType;
    }

    public void s(PictureUrl pictureUrl) {
        this.f50242e = pictureUrl;
    }

    public void t(ArrayList<stPhotoTag> arrayList) {
        this.f50258u = arrayList;
    }

    public void u(float f16) {
        this.f50246i = f16;
    }

    public void v(float f16) {
        this.f50247j = f16;
    }

    public void w(RawImageProcessor rawImageProcessor) {
        this.f50245h = rawImageProcessor;
    }

    public FeedPictureInfo(ImageType imageType, PictureUrl pictureUrl, String... strArr) {
        this(imageType, pictureUrl, 0.0f, 0.0f, 18, null, strArr);
    }

    public FeedPictureInfo(ImageType imageType, PictureUrl pictureUrl, float f16, float f17, int i3, String str, String... strArr) {
        ImageType imageType2 = ImageType.NORMAL;
        this.f50258u = null;
        this.f50259v = null;
        this.f50262y = "";
        this.f50263z = "";
        this.f50238a = imageType;
        this.f50239b = pictureUrl;
        this.f50246i = f16;
        this.f50247j = f17;
        this.f50249l = i3;
        this.f50250m = str;
    }

    public FeedPictureInfo(ImageType imageType, PictureUrl pictureUrl, PictureUrl pictureUrl2, boolean z16, float f16, float f17, int i3, String str, String... strArr) {
        ImageType imageType2 = ImageType.NORMAL;
        this.f50258u = null;
        this.f50259v = null;
        this.f50262y = "";
        this.f50263z = "";
        this.f50238a = imageType;
        this.f50239b = pictureUrl;
        this.f50240c = pictureUrl2;
        this.f50243f = z16;
        this.f50246i = f16;
        this.f50247j = f17;
        this.f50249l = i3;
        this.f50250m = str;
    }
}
