package com.tencent.mobileqq.aio.panel.ptt;

import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.audio.view.AudioPanel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001*B\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020#\u00a2\u0006\u0004\b'\u0010(J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J>\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u001c\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u0015\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u001c\u0010\u0016\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u0018\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000bH\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/ptt/d;", "Lcom/tencent/mobileqq/ptt/d$a;", "", "path", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "p", "", "onInitFailed", "onInitSuccess", "", "sliceData", "", "size", "maxAmplitude", "", "time", "onRecorderSilceEnd", "onRecorderPrepare", "onRecorderStart", "onBeginReceiveData", "totalTime", "onRecorderEnd", "onRecorderAbnormal", "throwable", "onRecorderError", "state", "onRecorderVolumeStateChanged", "Lcom/tencent/qqnt/audio/view/AudioPanel;", "d", "Lcom/tencent/qqnt/audio/view/AudioPanel;", "recordPanel", "Lcom/tencent/mobileqq/aio/panel/ptt/e;", "e", "Lcom/tencent/mobileqq/aio/panel/ptt/e;", "mRecordChangeListener", "Lcom/tencent/qqnt/audio/record/writer/e;", "f", "Lcom/tencent/qqnt/audio/record/writer/e;", "fileWriter", "<init>", "(Lcom/tencent/qqnt/audio/view/AudioPanel;Lcom/tencent/mobileqq/aio/panel/ptt/e;Lcom/tencent/qqnt/audio/record/writer/e;)V", h.F, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d implements d.a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AudioPanel recordPanel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e mRecordChangeListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.audio.record.writer.e fileWriter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/ptt/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.panel.ptt.d$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64552);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull AudioPanel recordPanel, @NotNull e mRecordChangeListener, @NotNull com.tencent.qqnt.audio.record.writer.e fileWriter) {
        Intrinsics.checkNotNullParameter(recordPanel, "recordPanel");
        Intrinsics.checkNotNullParameter(mRecordChangeListener, "mRecordChangeListener");
        Intrinsics.checkNotNullParameter(fileWriter, "fileWriter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, recordPanel, mRecordChangeListener, fileWriter);
            return;
        }
        this.recordPanel = recordPanel;
        this.mRecordChangeListener = mRecordChangeListener;
        this.fileWriter = fileWriter;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onBeginReceiveData(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) path, (Object) p16)).intValue();
        }
        return 6000000;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitFailed(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) path, (Object) p16);
        } else {
            this.recordPanel.v();
            QLog.e("PttRecordCallback", 1, "onInitFailed");
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d("PttRecordCallback", 2, "onInitSuccess");
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderAbnormal(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) path, (Object) p16);
            return;
        }
        this.recordPanel.v();
        QLog.e("PttRecordCallback", 1, "onRecorderAbnormal");
        this.mRecordChangeListener.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
    
        r0 = kotlin.collections.ArraysKt___ArraysKt.slice(r0, new kotlin.ranges.IntRange(0, r7.C));
     */
    @Override // com.tencent.mobileqq.ptt.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onRecorderEnd(@Nullable String path, @Nullable RecordParams.RecorderParam p16, double totalTime) {
        List emptyList;
        List list;
        List slice;
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, path, p16, Double.valueOf(totalTime));
            return;
        }
        if (p16 == null) {
            return;
        }
        this.fileWriter.onRecorderEnd(path, p16, totalTime);
        AudioPanel audioPanel = this.recordPanel;
        int[] iArr = p16.D;
        if (iArr == null || slice == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList;
        } else {
            List list2 = slice;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            list = new ArrayList(collectionSizeOrDefault);
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                list.add(Byte.valueOf((byte) ((Number) it.next()).intValue()));
            }
        }
        audioPanel.l(totalTime, new ArrayList<>(list));
        if (QLog.isColorLevel()) {
            QLog.d("PttRecordCallback", 2, "onRecorderEnd " + p16.D);
        }
        this.mRecordChangeListener.a();
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderError(@Nullable String path, @Nullable RecordParams.RecorderParam p16, @Nullable String throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, path, p16, throwable);
            return;
        }
        this.recordPanel.v();
        QLog.e("PttRecordCallback", 1, "onRecorderError", throwable);
        this.mRecordChangeListener.a();
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderPrepare(@Nullable String path, @Nullable RecordParams.RecorderParam p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) path, (Object) p16);
            return;
        }
        this.fileWriter.onRecorderPrepare(path, p16);
        this.recordPanel.m();
        if (QLog.isColorLevel()) {
            QLog.d("PttRecordCallback", 2, "onRecorderPrepare");
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderSilceEnd(@Nullable String path, @Nullable byte[] sliceData, int size, int maxAmplitude, double time, @Nullable RecordParams.RecorderParam p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, path, sliceData, Integer.valueOf(size), Integer.valueOf(maxAmplitude), Double.valueOf(time), p16);
        } else {
            this.fileWriter.onRecorderSilceEnd(path, sliceData, size, maxAmplitude, time, p16);
            this.recordPanel.o(maxAmplitude, time);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onRecorderStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        this.recordPanel.q();
        if (QLog.isColorLevel()) {
            QLog.d("PttRecordCallback", 2, "onRecorderStart");
        }
        this.mRecordChangeListener.b();
        return 0;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderVolumeStateChanged(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, state);
        } else if (QLog.isColorLevel()) {
            QLog.d("PttRecordCallback", 2, "onRecorderVolumeStateChanged, " + state);
        }
    }
}
