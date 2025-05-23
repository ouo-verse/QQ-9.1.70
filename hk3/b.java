package hk3;

import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.zootopia.api.e;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0016\u00a8\u0006\u0010"}, d2 = {"Lhk3/b;", "", "", "roleType", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "callback", "", "c", "isEnable", "b", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "a", "d", "mute", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public interface b {
    void a(int volume);

    void b(boolean isEnable, e<Boolean> callback);

    void c(int roleType, e<Boolean> callback);

    void d(int volume);

    void e(boolean mute);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public static final class a {
        public static void a(b bVar, boolean z16) {
        }

        public static void b(b bVar, int i3) {
        }

        public static void c(b bVar, int i3) {
        }

        public static void d(b bVar, boolean z16, e<Boolean> eVar) {
        }

        public static void e(b bVar, int i3, e<Boolean> eVar) {
        }
    }
}
