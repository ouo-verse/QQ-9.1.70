package ew2;

import com.tencent.tvideo.protocol.pb.AdActionField;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public AdActionField f397276a;

    /* renamed from: b, reason: collision with root package name */
    public int f397277b;

    /* renamed from: c, reason: collision with root package name */
    public String f397278c;

    public a() {
        this.f397276a = AdActionField.AD_ACTION_FIELD_UNKNOWN;
        this.f397277b = 0;
    }

    public a(String str) {
        this.f397276a = AdActionField.AD_ACTION_FIELD_UNKNOWN;
        this.f397277b = 0;
        this.f397278c = str;
    }

    public a(AdActionField adActionField, int i3, String str) {
        AdActionField adActionField2 = AdActionField.AD_ACTION_FIELD_UNKNOWN;
        this.f397276a = adActionField;
        this.f397277b = i3;
        this.f397278c = str;
    }
}
