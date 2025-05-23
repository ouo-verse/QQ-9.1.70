package na1;

import android.text.TextUtils;
import com.tencent.mobileqq.config.n;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0003\u0007B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\n\u0010\u000eJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lna1/a;", "", "Lna1/a$b;", "a", "", "Ljava/lang/String;", "mContent", "b", "Lna1/a$b;", "mConfig", "<init>", "()V", "content", DownloadInfo.spKey_Config, "(Ljava/lang/String;Lna1/a$b;)V", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mContent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00052\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lna1/a$b;", "Lcom/tencent/mobileqq/config/n;", "", "fileOrRes", "", "b", "toString", "", "a", "Z", "()Z", "setSupportDynamicAvatar", "(Z)V", "isSupportDynamicAvatar", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements n<String> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isSupportDynamicAvatar = true;

        /* renamed from: a, reason: from getter */
        public final boolean getIsSupportDynamicAvatar() {
            return this.isSupportDynamicAvatar;
        }

        @Override // com.tencent.mobileqq.config.n
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onParse(@Nullable String fileOrRes) {
            if (TextUtils.isEmpty(fileOrRes)) {
                QLog.e("DynamicAvatarConfBean", 1, "dynamic avatar config content is empty");
                return;
            }
            try {
                boolean optBoolean = new JSONObject(fileOrRes).optBoolean("is_support_dynamic_avatar", true);
                this.isSupportDynamicAvatar = optBoolean;
                QLog.i("DynamicAvatarConfBean", 2, "dynamic avatar config parse ok, isSupportDynamicAvatar is " + optBoolean);
            } catch (JSONException e16) {
                QLog.e("DynamicAvatarConfBean", 1, "dynamic avatar config parse exception", e16);
            }
        }

        @NotNull
        public String toString() {
            return "isSupportDynamicAvatar is " + this.isSupportDynamicAvatar;
        }
    }

    public a() {
        this.mContent = "";
        this.mConfig = new b();
    }

    @Nullable
    public final b a() {
        b bVar = this.mConfig;
        if (bVar == null) {
            return new b();
        }
        return bVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String content, @Nullable b bVar) {
        this();
        Intrinsics.checkNotNullParameter(content, "content");
        this.mContent = content;
        this.mConfig = bVar;
    }
}
