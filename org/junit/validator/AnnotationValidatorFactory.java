package org.junit.validator;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AnnotationValidatorFactory {
    private static final ConcurrentHashMap<ValidateWith, AnnotationValidator> VALIDATORS_FOR_ANNOTATION_TYPES = new ConcurrentHashMap<>();

    public AnnotationValidator createAnnotationValidator(ValidateWith validateWith) {
        ConcurrentHashMap<ValidateWith, AnnotationValidator> concurrentHashMap = VALIDATORS_FOR_ANNOTATION_TYPES;
        AnnotationValidator annotationValidator = concurrentHashMap.get(validateWith);
        if (annotationValidator != null) {
            return annotationValidator;
        }
        Class<? extends AnnotationValidator> value = validateWith.value();
        if (value != null) {
            try {
                concurrentHashMap.putIfAbsent(validateWith, value.newInstance());
                return concurrentHashMap.get(validateWith);
            } catch (Exception e16) {
                throw new RuntimeException("Exception received when creating AnnotationValidator class " + value.getName(), e16);
            }
        }
        throw new IllegalArgumentException("Can't create validator, value is null in annotation " + validateWith.getClass().getName());
    }
}
