package com.tencent.ttpic.openapi.ai;

import android.graphics.PointF;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.PTEmotionAttr;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTGenderAttr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes27.dex */
public class PTFaceAttrPro {
    private PTEmotionAttr emotionAttr;
    private PTFaceAttr faceAttr;
    private PTGenderAttr genderAttr;

    public List<Integer> getAges() {
        PTFaceAttr pTFaceAttr = this.faceAttr;
        if (pTFaceAttr != null && pTFaceAttr.getFaceStatusList() != null && this.faceAttr.getFaceStatusList().size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (FaceStatus faceStatus : this.faceAttr.getFaceStatusList()) {
                if (faceStatus != null) {
                    arrayList.add(Integer.valueOf(faceStatus.age));
                }
            }
            return arrayList;
        }
        return null;
    }

    public PTFaceAttr getFaceAttr() {
        return this.faceAttr;
    }

    public int getFaceCount() {
        PTFaceAttr pTFaceAttr = this.faceAttr;
        if (pTFaceAttr != null) {
            return pTFaceAttr.getFaceCount();
        }
        return 0;
    }

    public boolean getFaceExpression(PTFaceAttr.PTExpression pTExpression) {
        PTFaceAttr pTFaceAttr = this.faceAttr;
        if (pTFaceAttr != null && pTFaceAttr.getFaceExpression() != null) {
            return this.faceAttr.getFaceExpression().get(pTExpression).booleanValue();
        }
        return false;
    }

    public List<Boolean> getFaceExpressions(PTFaceAttr.PTExpression pTExpression) {
        List<Set<Integer>> expressions;
        boolean z16;
        PTFaceAttr pTFaceAttr = this.faceAttr;
        if (pTFaceAttr != null && (expressions = pTFaceAttr.getExpressions()) != null && expressions.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (Set<Integer> set : expressions) {
                if (set != null && set.contains(Integer.valueOf(pTExpression.value))) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                arrayList.add(Boolean.valueOf(z16));
            }
            return arrayList;
        }
        return null;
    }

    public List<List<PointF>> getFacePoints() {
        PTFaceAttr pTFaceAttr = this.faceAttr;
        if (pTFaceAttr != null) {
            return pTFaceAttr.getAllFacePoints();
        }
        return null;
    }

    public List<Integer> getGenders() {
        PTGenderAttr pTGenderAttr = this.genderAttr;
        if (pTGenderAttr != null && pTGenderAttr.getGenderInfos() != null && this.genderAttr.getGenderInfos().size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<PTGenderAttr.GenderInfo> it = this.genderAttr.getGenderInfos().iterator();
            while (it.hasNext()) {
                PTGenderAttr.GenderInfo next = it.next();
                if (next != null) {
                    arrayList.add(Integer.valueOf(next.curGender));
                }
            }
            return arrayList;
        }
        return null;
    }

    public void setEmotionAttr(PTEmotionAttr pTEmotionAttr) {
        this.emotionAttr = pTEmotionAttr;
    }

    public void setFaceAttr(PTFaceAttr pTFaceAttr) {
        this.faceAttr = pTFaceAttr;
    }

    public void setGenderAttr(PTGenderAttr pTGenderAttr) {
        this.genderAttr = pTGenderAttr;
    }
}
