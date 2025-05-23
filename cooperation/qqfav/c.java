package cooperation.qqfav;

import android.content.ContentValues;
import com.tencent.mobileqq.data.ChatMessage;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public long f390599a;

    /* renamed from: b, reason: collision with root package name */
    public Object f390600b;

    /* renamed from: c, reason: collision with root package name */
    public String f390601c;

    /* renamed from: d, reason: collision with root package name */
    public long f390602d;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public ChatMessage f390603a;

        /* renamed from: b, reason: collision with root package name */
        public String f390604b;

        public a(ChatMessage chatMessage, String str) {
            this.f390603a = chatMessage;
            this.f390604b = str;
        }
    }

    public c(long j3, long j16, ContentValues contentValues) {
        this.f390601c = "";
        this.f390602d = j3;
        this.f390599a = j16;
        this.f390600b = contentValues;
        try {
            this.f390601c = contentValues.getAsString("entityNickName");
        } catch (Exception unused) {
        }
    }

    public c(long j3, long j16, Object obj, String str) {
        this.f390602d = j3;
        this.f390599a = j16;
        this.f390600b = obj;
        this.f390601c = str;
    }
}
