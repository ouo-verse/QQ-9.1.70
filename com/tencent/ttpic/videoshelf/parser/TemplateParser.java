package com.tencent.ttpic.videoshelf.parser;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import java.io.File;

/* loaded from: classes27.dex */
public class TemplateParser {
    private static final String CONFIG_FILENAME = "params.json";
    private static final String CONFIG_FILENAME_ENCRYPTED = "params.dat";
    private static final String TAG = "TemplateParser";

    public static VideoShelfTemplate parse(Context context, String str) {
        VideoShelfTemplate videoShelfTemplate;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str, "params.json");
            String str2 = CONFIG_FILENAME_ENCRYPTED;
            File file2 = new File(str, CONFIG_FILENAME_ENCRYPTED);
            if (file.exists()) {
                str2 = file.getName();
            } else if (file2.exists()) {
                str2 = file2.getName();
            }
            String readFileString = readFileString(context, str, str2);
            if (!TextUtils.isEmpty(str)) {
                try {
                    videoShelfTemplate = (VideoShelfTemplate) new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(readFileString, VideoShelfTemplate.class);
                } catch (JsonSyntaxException e16) {
                    ReportUtil.report("Video template parse error!" + e16);
                    e16.printStackTrace();
                    videoShelfTemplate = null;
                }
                if (videoShelfTemplate != null) {
                    videoShelfTemplate.setFromAssets(str.startsWith("assets://"));
                    videoShelfTemplate.setMaterialPath(str);
                }
                return videoShelfTemplate;
            }
            throw new IllegalArgumentException("video template json is not valid");
        }
        throw new IllegalArgumentException("video template path is not valid");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private static java.lang.String readFileString(android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ttpic.videoshelf.parser.TemplateParser.readFileString(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }
}
