package com.tencent.state.template.data;

import com.tencent.state.template.data.FootLabelInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ks4.d;
import ks4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u00a2\u0006\u0004\b$\u0010%B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b$\u0010(J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u00c2\u0003J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\t\u001a\u00020\bJ\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u000f\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J%\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00052\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010 R\u0013\u0010#\u001a\u0004\u0018\u00010\u00038F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/template/data/CommonFootLabel;", "", "", "Lcom/tencent/state/template/data/FootLabelInfo;", "component2", "", "tipText", "linkUrl", "", "showText", "bundleName", "domainName", "", "jumpType", "()Ljava/lang/Integer;", "Lcom/tencent/state/template/data/FootLabelInfo$Companion$SourceScene;", "scene", "Lcom/tencent/state/template/data/FootLabelInfo$Companion$LabelType;", "labelType", "component1", "uin", "uniFootLabelInfo", "copy", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "Ljava/util/List;", "getLabel", "()Lcom/tencent/state/template/data/FootLabelInfo;", "label", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Lks4/e;", "pb", "(Lks4/e;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class CommonFootLabel {
    private String uin;
    private List<FootLabelInfo> uniFootLabelInfo;

    public CommonFootLabel(String uin, List<FootLabelInfo> list) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.uniFootLabelInfo = list;
    }

    private final List<FootLabelInfo> component2() {
        return this.uniFootLabelInfo;
    }

    public final String bundleName() {
        UniFootLabelStyleInfo info;
        FootLabelInfo label = getLabel();
        if (label == null || (info = label.getInfo()) == null) {
            return null;
        }
        return info.getBundleName();
    }

    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public final CommonFootLabel copy(String uin, List<FootLabelInfo> uniFootLabelInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return new CommonFootLabel(uin, uniFootLabelInfo);
    }

    public final String domainName() {
        UniFootLabelStyleInfo info;
        FootLabelInfo label = getLabel();
        if (label == null || (info = label.getInfo()) == null) {
            return null;
        }
        return info.getDomainName();
    }

    public final FootLabelInfo getLabel() {
        Object firstOrNull;
        List<FootLabelInfo> list = this.uniFootLabelInfo;
        if (list == null) {
            return null;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
        return (FootLabelInfo) firstOrNull;
    }

    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        String str = this.uin;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<FootLabelInfo> list = this.uniFootLabelInfo;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public final Integer jumpType() {
        UniFootLabelStyleInfo info;
        FootLabelInfo label = getLabel();
        if (label == null || (info = label.getInfo()) == null) {
            return null;
        }
        return Integer.valueOf(info.getLinkJumpType());
    }

    public final FootLabelInfo.Companion.LabelType labelType() {
        FootLabelInfo label = getLabel();
        if (label != null) {
            return label.getLabelType();
        }
        return null;
    }

    public final String linkUrl() {
        UniFootLabelStyleInfo info;
        FootLabelInfo label = getLabel();
        if (label == null || (info = label.getInfo()) == null) {
            return null;
        }
        return info.getLinkUrl();
    }

    public final FootLabelInfo.Companion.SourceScene scene() {
        FootLabelInfo label = getLabel();
        if (label != null) {
            return label.getScene();
        }
        return null;
    }

    public final void setUin(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uin = str;
    }

    public final boolean showText() {
        FootLabelInfo label = getLabel();
        return (label != null ? label.getScene() : null) == FootLabelInfo.Companion.SourceScene.STRANGER;
    }

    public final String tipText() {
        UniFootLabelStyleInfo info;
        FootLabelInfo label = getLabel();
        if (label == null || (info = label.getInfo()) == null) {
            return null;
        }
        return info.getTipText();
    }

    public String toString() {
        return "CommonFootLabel(uin=" + this.uin + ", uniFootLabelInfo=" + this.uniFootLabelInfo + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CommonFootLabel(e pb5) {
        this("", r1);
        List emptyList;
        Intrinsics.checkNotNullParameter(pb5, "pb");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.uin = String.valueOf(pb5.f412967a);
        d[] dVarArr = pb5.f412968b;
        Intrinsics.checkNotNullExpressionValue(dVarArr, "pb.labels");
        if (!(dVarArr.length == 0)) {
            d[] dVarArr2 = pb5.f412968b;
            Intrinsics.checkNotNullExpressionValue(dVarArr2, "pb.labels");
            ArrayList arrayList = new ArrayList(dVarArr2.length);
            for (d it : dVarArr2) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(new FootLabelInfo(it));
            }
            this.uniFootLabelInfo = arrayList;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonFootLabel)) {
            return false;
        }
        CommonFootLabel commonFootLabel = (CommonFootLabel) other;
        return Intrinsics.areEqual(this.uin, commonFootLabel.uin) && Intrinsics.areEqual(this.uniFootLabelInfo, commonFootLabel.uniFootLabelInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonFootLabel copy$default(CommonFootLabel commonFootLabel, String str, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = commonFootLabel.uin;
        }
        if ((i3 & 2) != 0) {
            list = commonFootLabel.uniFootLabelInfo;
        }
        return commonFootLabel.copy(str, list);
    }
}
