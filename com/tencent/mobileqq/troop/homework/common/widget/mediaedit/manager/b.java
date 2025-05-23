package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager;

import android.app.Activity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.helper.HWImgCompressHelper;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0002H\u0016R\u001a\u0010\f\u001a\u00020\u00078\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00078\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00078\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u00078\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u00078\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u00078\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000bR\u001a\u0010!\u001a\u00020\u001c8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R&\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\"8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R \u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b\r\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/b;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", "Landroidx/lifecycle/LiveData;", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "p", "t", "", "d", "I", "o", "()I", "imgOrVideoNumLimit", "e", "g", "audioNumLimit", "f", "v", "fileNumLimit", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "canAddImgOrVideoSize", "i", "u", "canAddAudioSize", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "canAddFileSize", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper$ImgQuality;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper$ImgQuality;", "getImgQuality", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/helper/HWImgCompressHelper$ImgQuality;", "imgQuality", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "b", "()Landroidx/lifecycle/MutableLiveData;", "itemListLiveData", "E", "updateItemLiveData", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class b implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final HWImgCompressHelper.ImgQuality imgQuality;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<BaseItem>> itemListLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<BaseItem> updateItemLiveData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int imgOrVideoNumLimit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int audioNumLimit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int fileNumLimit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int canAddImgOrVideoSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int canAddAudioSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int canAddFileSize;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.imgOrVideoNumLimit = 10;
        this.audioNumLimit = 1;
        this.fileNumLimit = 2;
        this.imgQuality = HWImgCompressHelper.ImgQuality.DEFAULT;
        this.itemListLiveData = new MutableLiveData<>();
        this.updateItemLiveData = new MutableLiveData<>();
    }

    public void a(@NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) bVar);
        } else {
            f.a.d(this, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final MutableLiveData<List<BaseItem>> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.itemListLiveData;
    }

    @Override // qs2.a
    public void c(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) activity);
        } else {
            f.a.a(this, activity);
        }
    }

    public void d(@NotNull com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) aVar);
        } else {
            f.a.c(this, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final MutableLiveData<BaseItem> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.updateItemLiveData;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f
    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.audioNumLimit;
    }

    @Override // qs2.a
    public void j(@NotNull BaseItem baseItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) baseItem);
        } else {
            f.a.h(this, baseItem);
        }
    }

    public void l(@NotNull List<com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.f> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) list);
        } else {
            f.a.e(this, list);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f
    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.imgOrVideoNumLimit;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f
    @NotNull
    public LiveData<List<BaseItem>> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (LiveData) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.itemListLiveData;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f
    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.canAddImgOrVideoSize;
    }

    public void r(@NotNull List<com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.h> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) list);
        } else {
            f.a.f(this, list);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f
    @NotNull
    public LiveData<BaseItem> t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (LiveData) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.updateItemLiveData;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f
    public int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.canAddAudioSize;
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f
    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.fileNumLimit;
    }

    @Override // qs2.a
    public void w(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            f.a.g(this, i3);
        }
    }

    @Override // qs2.a
    public void y(@NotNull BaseItem baseItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) baseItem);
        } else {
            f.a.b(this, baseItem);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f
    public int z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.canAddFileSize;
    }
}
