package com.tencent.qcircle.weishi.module.publisher.entity;

import android.text.TextUtils;
import com.tencent.qcircle.weishi.module.publisher.constants.CategoryType;
import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.qcircle.weseevideo.model.utils.CollectionUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TemplateBean implements Serializable, Cloneable {
    public static final int STATUS_DOWNLOADED = 1;
    public static final int STATUS_NOT_DOWNLOAD = 0;
    public static final String TEMPLATE_JSON = "template.json";
    public boolean canChange;
    public boolean isStuckPoint;
    public MusicMaterialMetaDataBean musicMaterialMetaDataBean;
    public int reserveSource;
    public String templateJsonPath;
    public String templatePath;
    public String templateId = "";
    public String templateName = "";
    public String url = "";
    public String spec = "";
    public List<String> tags = null;
    public String coverUrl = "";
    public int templateType = 0;
    public String musicId = "";
    public String category = "";
    public String subCategoryId = "";
    public ArrayList<String> subcategories = null;
    public int status = 0;
    public long version = 0;
    public int zipFile = 0;
    public String fileSuffix = "";
    public int templateUiType = 0;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TemplateBean)) {
            return false;
        }
        TemplateBean templateBean = (TemplateBean) obj;
        String str = this.templateId;
        if (str != null && str.equals(templateBean.templateId)) {
            return true;
        }
        return false;
    }

    public String getCategory() {
        return this.category;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getMusicId() {
        return this.musicId;
    }

    public MusicMaterialMetaDataBean getMusicMaterialMetaDataBean() {
        return this.musicMaterialMetaDataBean;
    }

    public String getSpec() {
        return this.spec;
    }

    public int getStatus() {
        return this.status;
    }

    public ArrayList<String> getSubcategories() {
        return this.subcategories;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateJsonDir() {
        if (!TextUtils.isEmpty(this.templateJsonPath)) {
            return this.templateJsonPath.substring(0, this.templateJsonPath.indexOf(TEMPLATE_JSON) - 1);
        }
        return null;
    }

    public String getTemplateJsonPath() {
        return this.templateJsonPath;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public int getTemplateType() {
        return this.templateType;
    }

    public int getTemplateUiType() {
        return this.templateUiType;
    }

    public String getUrl() {
        return this.url;
    }

    public long getVersion() {
        return this.version;
    }

    public boolean isExist() {
        if (TextUtils.isEmpty(this.templateJsonPath)) {
            return true;
        }
        return new File(this.templateJsonPath).exists();
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setMusicId(String str) {
        this.musicId = str;
    }

    public void setMusicMaterialMetaDataBean(MusicMaterialMetaDataBean musicMaterialMetaDataBean) {
        this.musicMaterialMetaDataBean = musicMaterialMetaDataBean;
    }

    public void setSpec(String str) {
        this.spec = str;
    }

    public void setStatus(int i3) {
        this.status = i3;
    }

    public void setSubcategories(ArrayList<String> arrayList) {
        this.subcategories = arrayList;
    }

    public void setTags(ArrayList<String> arrayList) {
        this.tags = arrayList;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public void setTemplateJsonPath(String str) {
        this.templateJsonPath = str;
    }

    public void setTemplateName(String str) {
        this.templateName = str;
    }

    public void setTemplateType(int i3) {
        this.templateType = i3;
        if (i3 == 2) {
            this.category = CategoryType.VIDEO_FUNNY;
        } else if (i3 == 1) {
            this.category = CategoryType.AUTO_TEMPLATE;
        }
    }

    public void setTemplateUiType(int i3) {
        this.templateUiType = i3;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(long j3) {
        this.version = j3;
    }

    @NotNull
    public String toString() {
        return "TemplateBean{templateId='" + this.templateId + "', templateName='" + this.templateName + "'}";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TemplateBean m237clone() {
        TemplateBean templateBean = new TemplateBean();
        templateBean.templateId = this.templateId;
        templateBean.templateName = this.templateName;
        templateBean.url = this.url;
        templateBean.spec = this.spec;
        if (!CollectionUtils.isEmpty(this.tags)) {
            templateBean.tags = new ArrayList(this.tags);
        }
        templateBean.coverUrl = this.coverUrl;
        templateBean.templateType = this.templateType;
        templateBean.musicId = this.musicId;
        templateBean.category = this.category;
        if (!CollectionUtils.isEmpty(this.subcategories)) {
            templateBean.subcategories = new ArrayList<>(this.subcategories);
        }
        templateBean.version = this.version;
        templateBean.isStuckPoint = this.isStuckPoint;
        templateBean.canChange = this.canChange;
        templateBean.reserveSource = this.reserveSource;
        templateBean.templateUiType = this.templateUiType;
        MusicMaterialMetaDataBean musicMaterialMetaDataBean = this.musicMaterialMetaDataBean;
        if (musicMaterialMetaDataBean != null) {
            templateBean.musicMaterialMetaDataBean = musicMaterialMetaDataBean.deepClone();
        }
        templateBean.status = this.status;
        templateBean.zipFile = this.zipFile;
        templateBean.version = this.version;
        templateBean.fileSuffix = this.fileSuffix;
        templateBean.templateJsonPath = this.templateJsonPath;
        templateBean.templatePath = this.templatePath;
        templateBean.subCategoryId = this.subCategoryId;
        return templateBean;
    }
}
