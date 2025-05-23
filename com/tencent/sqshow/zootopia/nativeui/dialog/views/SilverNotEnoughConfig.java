package com.tencent.sqshow.zootopia.nativeui.dialog.views;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "message", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "cancelText", "a", "setCancelText", "confirmText", "b", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.nativeui.dialog.views.l, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class SilverNotEnoughConfig {

    @SerializedName("cancelText")
    private String cancelText;

    @SerializedName("confirmText")
    private final String confirmText;

    @SerializedName("message")
    private String message;

    public SilverNotEnoughConfig() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getCancelText() {
        return this.cancelText;
    }

    /* renamed from: b, reason: from getter */
    public final String getConfirmText() {
        return this.confirmText;
    }

    /* renamed from: c, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (((this.message.hashCode() * 31) + this.cancelText.hashCode()) * 31) + this.confirmText.hashCode();
    }

    public String toString() {
        return "SilverNotEnoughConfig(message=" + this.message + ", cancelText=" + this.cancelText + ", confirmText=" + this.confirmText + ")";
    }

    public SilverNotEnoughConfig(String message, String cancelText, String confirmText) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cancelText, "cancelText");
        Intrinsics.checkNotNullParameter(confirmText, "confirmText");
        this.message = message;
        this.cancelText = cancelText;
        this.confirmText = confirmText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SilverNotEnoughConfig)) {
            return false;
        }
        SilverNotEnoughConfig silverNotEnoughConfig = (SilverNotEnoughConfig) other;
        return Intrinsics.areEqual(this.message, silverNotEnoughConfig.message) && Intrinsics.areEqual(this.cancelText, silverNotEnoughConfig.cancelText) && Intrinsics.areEqual(this.confirmText, silverNotEnoughConfig.confirmText);
    }

    public /* synthetic */ SilverNotEnoughConfig(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "\u94f6\u5e01\u4e0d\u8db3\uff0c\u662f\u5426\u505a\u4efb\u52a1\u8d5a\u94f6\u5e01\uff1f" : str, (i3 & 2) != 0 ? "\u53d6\u6d88" : str2, (i3 & 4) != 0 ? "\u53bb\u8d5a\u94f6\u5e01" : str3);
    }
}
