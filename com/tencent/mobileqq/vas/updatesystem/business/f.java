package com.tencent.mobileqq.vas.updatesystem.business;

import android.graphics.Color;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u000f\u0014B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/business/f;", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "", "getBid", "", "id", "", "getScid", "getFrom", "getBusinessDir", "", "isEnableCheckFile", "Lcom/tencent/mobileqq/vas/updatesystem/business/f$b;", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "configCache", "<init>", "()V", "b", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f extends QQVasUpdateBusiness<f> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Integer, Config> configCache = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0011\u0010\u001a\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001d\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0019R\u0011\u0010\u001e\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0019R\u0011\u0010 \u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010!\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0019R\u0011\u0010#\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u0019\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/business/f$b;", "", "", h.F, "b", "", "toString", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getRootPath", "()Ljava/lang/String;", "rootPath", "I", "_textColor", "c", "_textColorNight", "d", "_buttonColor", "e", "_buttonColorNight", "Ljava/io/File;", "()Ljava/io/File;", "headImage", "f", "middleImage", "bottomImage", "buttonImage", "i", "tittleImage", "logoImage", "g", "previewImage", "<init>", "(Ljava/lang/String;IIII)V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.updatesystem.business.f$b, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class Config {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String rootPath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int _textColor;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int _textColorNight;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int _buttonColor;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int _buttonColorNight;

        public Config(@NotNull String rootPath, int i3, int i16, int i17, int i18) {
            Intrinsics.checkNotNullParameter(rootPath, "rootPath");
            this.rootPath = rootPath;
            this._textColor = i3;
            this._textColorNight = i16;
            this._buttonColor = i17;
            this._buttonColorNight = i18;
        }

        @NotNull
        public final File a() {
            if (QQTheme.isNowThemeIsNight()) {
                return new File(this.rootPath, "addgroup_bottom_night.png");
            }
            return new File(this.rootPath, "addgroup_bottom.png");
        }

        public final int b() {
            if (QQTheme.isNowThemeIsNight()) {
                return this._buttonColorNight;
            }
            return this._buttonColor;
        }

        @NotNull
        public final File c() {
            if (QQTheme.isNowThemeIsNight()) {
                return new File(this.rootPath, "addgroup_button_night.png");
            }
            return new File(this.rootPath, "addgroup_button.png");
        }

        @NotNull
        public final File d() {
            if (QQTheme.isNowThemeIsNight()) {
                return new File(this.rootPath, "addgroup_head_night.png");
            }
            return new File(this.rootPath, "addgroup_head.png");
        }

        @NotNull
        public final File e() {
            return new File(this.rootPath, "addgroup_logo.png");
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            if (Intrinsics.areEqual(this.rootPath, config.rootPath) && this._textColor == config._textColor && this._textColorNight == config._textColorNight && this._buttonColor == config._buttonColor && this._buttonColorNight == config._buttonColorNight) {
                return true;
            }
            return false;
        }

        @NotNull
        public final File f() {
            if (QQTheme.isNowThemeIsNight()) {
                return new File(this.rootPath, "addgroup_middle_night.png");
            }
            return new File(this.rootPath, "addgroup_middle.png");
        }

        @NotNull
        public final File g() {
            return new File(this.rootPath, "addgroup_preview.png");
        }

        public final int h() {
            if (QQTheme.isNowThemeIsNight()) {
                return this._textColorNight;
            }
            return this._textColor;
        }

        public int hashCode() {
            return (((((((this.rootPath.hashCode() * 31) + this._textColor) * 31) + this._textColorNight) * 31) + this._buttonColor) * 31) + this._buttonColorNight;
        }

        @NotNull
        public final File i() {
            if (QQTheme.isNowThemeIsNight()) {
                return new File(this.rootPath, "addgroup_title_night.png");
            }
            return new File(this.rootPath, "addgroup_title.png");
        }

        @NotNull
        public String toString() {
            return "Config(rootPath=" + this.rootPath + ", _textColor=" + this._textColor + ", _textColorNight=" + this._textColorNight + ", _buttonColor=" + this._buttonColor + ", _buttonColorNight=" + this._buttonColorNight + ")";
        }
    }

    @Nullable
    public final Config e(int id5) {
        Config config = this.configCache.get(Integer.valueOf(id5));
        if (config != null) {
            return config;
        }
        File file = new File(getSavePath(id5), "config.json");
        if (!file.exists()) {
            QLog.e("TroopComeCardBusiness", 1, "no config");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(FileUtils.readFileToString(file));
            ConcurrentHashMap<Integer, Config> concurrentHashMap = this.configCache;
            Integer valueOf = Integer.valueOf(id5);
            String savePath = getSavePath(id5);
            Intrinsics.checkNotNullExpressionValue(savePath, "getSavePath(id)");
            concurrentHashMap.put(valueOf, new Config(savePath, Color.parseColor(jSONObject.getString("textColor")), Color.parseColor(jSONObject.getString("textColorNight")), Color.parseColor(jSONObject.getString("buttonColor")), Color.parseColor(jSONObject.getString("buttonColorNight"))));
        } catch (Exception e16) {
            QLog.e("TroopComeCardBusiness", 1, e16, new Object[0]);
        }
        return this.configCache.get(Integer.valueOf(id5));
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 40L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    protected String getBusinessDir() {
        return "troop_come_card";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    @NotNull
    public String getFrom() {
        return "TroopComeCardBusiness";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @NotNull
    public String getScid(int id5) {
        return "newComeCard.new." + id5;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }
}
