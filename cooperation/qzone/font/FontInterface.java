package cooperation.qzone.font;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class FontInterface {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface FontResult {
        void result(int i3, String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface FullTypeResult extends FontResult {
        @Override // cooperation.qzone.font.FontInterface.FontResult
        void result(int i3, String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface TrueTypeResult extends FontResult {
        @Override // cooperation.qzone.font.FontInterface.FontResult
        void result(int i3, String str, String str2);
    }
}
